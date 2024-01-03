package com.rs.connect4.domain

import com.rs.connect4.domain.Board.Column

import scala.collection.mutable.ArrayBuffer

case class Board(grid: ArrayBuffer[ArrayBuffer[String]], rowValueWherePieceWillLand: Map[Column, Int])

object Board {
  type Column = Int

  def apply(): Board = {
    val grid = ArrayBuffer.fill(6, 7)("")
    val rowValueWherePieceWillLand = (0 to 7).map(i => (i, 0)).toMap[Column, Int]
    new Board(grid, rowValueWherePieceWillLand)
  }
}
