package fr.morowin.pdc

import fr.morowin.pdc.draws._
import fr.morowin.pdc.models._

import scala.collection.mutable

class PDC {

  def run(draws: (List[(Int, Int)], List[(Int, Int)])): Unit = {
    val (a, b) = draws
    run(a, "TEAM A")
    run(b, "TEAM B")
  }
  def run(draws: List[(Int, Int)], team: String = ""): Unit = printCommunities(computeCommunities(draws), team)

  private def printCommunities(communities: List[(Int, List[Int])], team: String = ""): Unit = {
    println(s"• ${Option.when(team.nonEmpty)(team).getOrElse("TEAM")} COMMUNITIES:")
    communities.foreach { case (community, nodes) =>
      println(s"\t#$community\t→\t${nodes.mkString("[", ", ", "]")}")
    }
  }

  private def computeCommunities(draws: List[(Int, Int)]): List[(Int, List[Int])] = {
    val edges = draws.groupBy(identity).view.mapValues(_.size).map { case ((src, dst), weight) =>
      Edge(src, dst, weight.toDouble)
    }
    val nodes = edges.flatMap(edge => List(edge.src, edge.dst)).toSet
    val graph = Graph(nodes, edges.toSeq)

    louvain(graph).values.toList
      .sortBy(_.size)
      .reverse
      .zipWithIndex
      .map { case (community, index) => index + 1 -> community.toList.sorted }
      .sortBy(_._1)
  }

  private def louvain(graph: Graph): Map[Int, Set[Int]] = {
    var currentGraph = graph
    var currentModularity = Double.MinValue
    var bestCommunities = Map[Int, Set[Int]]()

    while (true) {
      val (communities, nodeToCommunity) = initialPartition(currentGraph)
      var improvement = true

      print(s"[DEBUG]\tLouvain improving communities [${currentGraph.nodes.size}]")
      while (improvement) {
        improvement = false
        currentGraph.nodes.foreach { node =>
          val bestCommunity = findBestCommunity(node, nodeToCommunity, communities, currentGraph)
          if (nodeToCommunity(node) != bestCommunity) {
            val oldCommunity = nodeToCommunity(node)
            communities(oldCommunity) = communities(oldCommunity) - node
            if (communities(oldCommunity).isEmpty) {
              communities.remove(oldCommunity)
            }
            nodeToCommunity(node) = bestCommunity
            communities(bestCommunity) = communities.getOrElse(bestCommunity, Set()) + node
            improvement = true
          }
        }
      }
      println("\t[✔]")

      val newModularity = calculateModularity(currentGraph, communities.toMap)
      if (newModularity > currentModularity) {
        currentModularity = newModularity
        bestCommunities = communities.toMap
      } else {
        return bestCommunities
      }

      currentGraph = aggregateCommunities(currentGraph, nodeToCommunity.toMap)
    }

    bestCommunities
  }

  private def initialPartition(graph: Graph): (mutable.Map[Int, Set[Int]], mutable.Map[Int, Int]) = {
    val communities = mutable.Map[Int, Set[Int]]()
    val nodeToCommunity = mutable.Map[Int, Int]()
    var communityId = 0

    graph.nodes.foreach { node =>
      nodeToCommunity(node) = communityId
      communities(communityId) = Set(node)
      communityId += 1
    }

    (communities, nodeToCommunity)
  }

  private def findBestCommunity(
      node: Int,
      nodeToCommunity: mutable.Map[Int, Int],
      communities: mutable.Map[Int, Set[Int]],
      graph: Graph
  ): Int = {
    val neighborCommunities = graph.edges.filter(edge => edge.src == node || edge.dst == node).map { edge =>
      if (edge.src == node) nodeToCommunity(edge.dst) else nodeToCommunity(edge.src)
    }

    val communityModularity = neighborCommunities.distinct.map { community =>
      val edgesInCommunity =
        graph.edges.count(edge => nodeToCommunity(edge.src) == community && nodeToCommunity(edge.dst) == community)
      val totalEdges = graph.edges.size
      val edgesToCommunity = neighborCommunities.count(_ == community)
      val communitySize = communities(community).size
      community -> ((edgesToCommunity.toDouble / totalEdges) - (communitySize.toDouble / (2 * totalEdges)) * (edgesInCommunity.toDouble / totalEdges))
    }.toMap

    communityModularity.maxBy(_._2)._1
  }

  private def calculateModularity(graph: Graph, communities: Map[Int, Set[Int]]): Double = {
    val totalEdges = graph.edges.size
    communities.values.map { community =>
      val edgesInCommunity = graph.edges.count(edge => community.contains(edge.src) && community.contains(edge.dst))
      val totalDegree = community.toSeq.map(node => graph.edges.count(edge => edge.src == node || edge.dst == node)).sum
      (edgesInCommunity.toDouble / totalEdges) - math.pow(totalDegree.toDouble / (2 * totalEdges), 2)
    }.sum
  }

  private def aggregateCommunities(graph: Graph, nodeToCommunity: Map[Int, Int]): Graph = {
    val newNodes = nodeToCommunity.values.toSet
    val newEdges = graph.edges
      .groupBy(edge => (nodeToCommunity(edge.src), nodeToCommunity(edge.dst)))
      .map { case ((src, dst), edges) =>
        Edge(src, dst, edges.map(_.weight).sum)
      }
      .toSeq
    Graph(newNodes, newEdges)
  }
}

object PDC extends App {
  private val DRAWS = fonte.A38_B42_version0.draws
  new PDC().run(DRAWS)
}
