package com.rs.connect4.gamelogic
import com.rs.connect4.domain.{AppError, Board, GameResult, Piece}

case class GameLogicLive() extends GameLogic {

  override def putPiece(board: Board, column: Int, piece: Piece): Either[AppError, Board] = ???

  override def gameResult(columnOfLatestPiece: Int, rowOfLatestPiece: Int): GameResult = ???
}
