package fr.morowin.pdc.draws

trait DrawAggregation {
  def buildFor(draws: List[(Int, Int)]): List[(Int, Int)] =
    draws.flatMap { case (a, b) => List(a -> b /*, b -> a*/ ) }
}
