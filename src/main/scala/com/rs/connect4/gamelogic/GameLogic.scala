package com.rs.connect4.gamelogic

import com.rs.connect4.domain.{AppError, Board, GameResult, Piece}

trait GameLogic {

  def putPiece(board: Board, column: Int, piece: Piece): Either[AppError, Board]

  def gameResult(columnOfLatestPiece: Int, rowOfLatestPiece: Int, currentPlayerPiece: Piece): GameResult

}
