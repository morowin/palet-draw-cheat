package fr.morowin.pdc.draw.laiton

import fr.morowin.pdc.draw.DrawUtil

object Tirage_16_24 extends DrawUtil {
  private object A {
    private val drawA1: List[(Int, Int)] = List(3 -> 11, 12 -> 2, 15 -> 10, 7 -> 14, 5 -> 1, 16 -> 13, 9 -> 4, 8 -> 6)
    private val drawA2: List[(Int, Int)] = List(13 -> 14, 4 -> 6, 3 -> 1, 12 -> 7, 10 -> 8, 16 -> 11, 15 -> 9, 2 -> 5)
    private val drawA3: List[(Int, Int)] = List(12 -> 6, 4 -> 14, 1 -> 2, 3 -> 7, 13 -> 8, 10 -> 16, 11 -> 9, 5 -> 15)
    private val drawA4: List[(Int, Int)] = List(11 -> 13, 15 -> 12, 3 -> 6, 5 -> 4, 14 -> 8, 16 -> 2, 7 -> 1, 10 -> 9)
    private val drawA5: List[(Int, Int)] = List(2 -> 13, 1 -> 9, 14 -> 3, 15 -> 16, 4 -> 12, 10 -> 6, 5 -> 7, 8 -> 11)
    private val drawA6: List[(Int, Int)] = List(5 -> 13, 16 -> 4, 10 -> 12, 1 -> 14, 6 -> 15, 11 -> 7, 9 -> 8, 2 -> 3)
    val draw: List[(Int, Int)] = buildFor(drawA1 ++ drawA2 ++ drawA3 ++ drawA4 ++ drawA5 ++ drawA6)
  }
  private object B {
    private val drawB1: List[(Int, Int)] = List(
      20 -> 23,
      9 -> 12,
      24 -> 22,
      21 -> 15,
      17 -> 13,
      11 -> 10,
      19 -> 16,
      18 -> 14,
      1 -> 2,
      3 -> 4,
      5 -> 6,
      7 -> 8
    )
    private val drawB2: List[(Int, Int)] = List(
      1 -> 20,
      5 -> 2,
      24 -> 8,
      18 -> 17,
      3 -> 4,
      19 -> 22,
      6 -> 7,
      21 -> 23,
      9 -> 10,
      11 -> 12,
      13 -> 14,
      15 -> 16
    )
    private val drawB3: List[(Int, Int)] = List(
      6 -> 3,
      4 -> 9,
      7 -> 16,
      5 -> 10,
      8 -> 2,
      12 -> 15,
      13 -> 11,
      1 -> 14,
      17 -> 18,
      19 -> 20,
      21 -> 22,
      23 -> 24
    )
    private val drawB4: List[(Int, Int)] = List(
      14 -> 9,
      21 -> 19,
      15 -> 13,
      12 -> 18,
      16 -> 22,
      20 -> 24,
      11 -> 23,
      10 -> 17,
      1 -> 2,
      3 -> 4,
      5 -> 6,
      7 -> 8
    )
    private val drawB5: List[(Int, Int)] = List(
      19 -> 5,
      18 -> 1,
      3 -> 17,
      2 -> 4,
      8 -> 23,
      21 -> 7,
      20 -> 22,
      24 -> 6,
      9 -> 10,
      11 -> 12,
      13 -> 14,
      15 -> 16
    )
    private val drawB6: List[(Int, Int)] = List(
      3 -> 7,
      6 -> 13,
      16 -> 2,
      14 -> 10,
      9 -> 8,
      4 -> 12,
      15 -> 5,
      1 -> 11,
      17 -> 18,
      19 -> 20,
      21 -> 22,
      23 -> 24
    )
    val draw: List[(Int, Int)] = buildFor(drawB1 ++ drawB2 ++ drawB3 ++ drawB4 ++ drawB5 ++ drawB6)
  }
  val draw: (List[(Int, Int)], List[(Int, Int)]) = A.draw -> B.draw
}
