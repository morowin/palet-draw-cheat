package fr.morowin.pdc.draw.laiton

import fr.morowin.pdc.draw.DrawUtil

object Tirage_18_22 extends DrawUtil {
  private object A {
    private val drawA1: List[(Int, Int)] =
      List(3 -> 12, 4 -> 17, 14 -> 1, 10 -> 7, 6 -> 5, 8 -> 2, 16 -> 11, 15 -> 18, 9 -> 13)
    private val drawA2: List[(Int, Int)] =
      List(5 -> 12, 4 -> 8, 3 -> 18, 14 -> 9, 15 -> 13, 2 -> 10, 6 -> 11, 1 -> 7, 16 -> 17)
    private val drawA3: List[(Int, Int)] =
      List(18 -> 1, 4 -> 5, 15 -> 7, 12 -> 2, 6 -> 9, 10 -> 16, 13 -> 17, 3 -> 14, 8 -> 11)
    private val drawA4: List[(Int, Int)] =
      List(1 -> 2, 4 -> 12, 3 -> 8, 5 -> 10, 18 -> 13, 16 -> 15, 14 -> 11, 17 -> 9, 7 -> 6)
    private val drawA5: List[(Int, Int)] =
      List(2 -> 11, 1 -> 3, 7 -> 16, 9 -> 12, 18 -> 6, 17 -> 10, 15 -> 4, 13 -> 14, 8 -> 5)
    private val drawA6: List[(Int, Int)] =
      List(17 -> 8, 9 -> 15, 4 -> 10, 5 -> 1, 6 -> 2, 7 -> 3, 14 -> 12, 11 -> 13, 18 -> 16)
    val draw: List[(Int, Int)] = buildFor(drawA1 ++ drawA2 ++ drawA3 ++ drawA4 ++ drawA5 ++ drawA6)
  }
  private object B {
    private val drawB1: List[(Int, Int)] =
      List(18 -> 9, 11 -> 16, 10 -> 6, 5 -> 22, 17 -> 15, 7 -> 19, 21 -> 8, 12 -> 14, 13 -> 20, 1 -> 2, 3 -> 4)
    private val drawB2: List[(Int, Int)] =
      List(16 -> 2, 4 -> 9, 10 -> 13, 15 -> 18, 3 -> 1, 20 -> 12, 11 -> 19, 14 -> 21, 17 -> 22, 5 -> 6, 7 -> 8)
    private val drawB3: List[(Int, Int)] =
      List(5 -> 19, 13 -> 7, 20 -> 16, 3 -> 17, 2 -> 4, 6 -> 14, 8 -> 15, 22 -> 21, 18 -> 1, 9 -> 10, 11 -> 12)
    private val drawB4: List[(Int, Int)] =
      List(11 -> 22, 10 -> 20, 8 -> 17, 3 -> 18, 21 -> 7, 5 -> 4, 9 -> 2, 6 -> 19, 1 -> 12, 13 -> 14, 15 -> 16)
    private val drawB5: List[(Int, Int)] =
      List(4 -> 13, 2 -> 7, 15 -> 9, 12 -> 5, 3 -> 22, 1 -> 21, 8 -> 6, 14 -> 16, 11 -> 10, 17 -> 18, 19 -> 20)
    private val drawB6: List[(Int, Int)] =
      List(14 -> 5, 9 -> 7, 15 -> 19, 12 -> 4, 16 -> 6, 3 -> 11, 13 -> 8, 17 -> 10, 18 -> 20, 21 -> 22, 1 -> 2)
    val draw: List[(Int, Int)] = buildFor(drawB1 ++ drawB2 ++ drawB3 ++ drawB4 ++ drawB5 ++ drawB6)
  }
  val draw: (List[(Int, Int)], List[(Int, Int)]) = A.draw -> B.draw
}
