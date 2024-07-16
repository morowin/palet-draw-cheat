package fr.morowin.pdc

import fr.morowin.pdc.draw._

object Main extends App {
  // val DRAW = fonte.A38_B42_version0.draw
  val DRAW = laiton.Tirage_16_24.draw
  new PDC().run(DRAW)
}
