package com.rs.connect4.gamelogic
import com.rs.connect4.domain.Board.Column
import com.rs.connect4.domain.{AppError, Board, GameResult, Piece}

case class GameLogicLive() extends GameLogic {

  override def putPiece(board: Board, column: Int, piece: Piece): Either[AppError, Board] = {
    val emptyRowForThisColumns = board.rowValueWherePieceWillLand(column)
    board.grid(emptyRowForThisColumns)(column) = piece.color
    val updatedBoard = {
    board.copy(rowValueWherePieceWillLand = board.rowValueWherePieceWillLand ++ Map[Column, Int]((column, emptyRowForThisColumns + 1)))
    }
    Right(updatedBoard)
  }

  override def gameResult(columnOfLatestPiece: Int, rowOfLatestPiece: Int, currentPlayerPiece: Piece): GameResult = {
    println(s"Column - $columnOfLatestPiece, row - $rowOfLatestPiece")
    GameResult.OnGoing
  }
}
