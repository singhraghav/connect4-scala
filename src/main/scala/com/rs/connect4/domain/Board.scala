package com.rs.connect4.domain

import com.rs.connect4.domain.Board.Column

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

case class Board(
                  grid: ArrayBuffer[ArrayBuffer[String]],
                  rowValueWherePieceWillLand: Map[Column, Int],
                  boardHeight: Int,
                  boardLength: Int,
                  totalPiecesOnTheBoard: Int
                ) {
  def hasNoEmptySpaceLeft: Boolean = totalPiecesOnTheBoard == (boardHeight * boardLength)

  def consecutiveCheck(isThePieceWeWantToCheck: String => Boolean, n: Int)(colStart: Int, rowStart: Int)(rowFn: Int => Int)(columnFn: Int => Int): Boolean = {

    def breachedBoardLength(currentColumn: Int): Boolean = currentColumn < 0 || currentColumn >= boardLength
    def breachedBoardHeight(currentRow: Int): Boolean = currentRow < 0 || currentRow >= boardHeight

    @tailrec
    def loop(currentN: Int, currentColumn: Int, currentRow: Int): Boolean = {
      if (currentN == 0) true
      else if (breachedBoardLength(currentColumn) || breachedBoardHeight(currentRow)) false
      else if (isThePieceWeWantToCheck(grid(currentRow)(currentColumn))) loop(currentN - 1, columnFn(currentColumn), rowFn(currentRow))
      else false
    }

    loop(currentN = n, currentColumn = colStart, currentRow = rowStart)
  }
}

object Board {
  type Column = Int

  def apply(): Board = {
    val grid = ArrayBuffer.fill(6, 7)("-")
    val rowValueWherePieceWillLand = (0 to 7).map(i => (i, 0)).toMap[Column, Int]
    new Board(grid, rowValueWherePieceWillLand, boardHeight = 6, boardLength = 7, totalPiecesOnTheBoard = 0)
  }
}
