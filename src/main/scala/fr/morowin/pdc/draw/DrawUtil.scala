package fr.morowin.pdc.draw

trait DrawUtil {
  def buildFor(draws: List[(Int, Int)]): List[(Int, Int)] =
    draws /*.flatMap { case (a, b) => List(a -> b, b -> a) }*/
}
