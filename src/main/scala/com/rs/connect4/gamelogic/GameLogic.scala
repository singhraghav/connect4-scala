package com.rs.connect4.gamelogic

import com.rs.connect4.domain.AppError.ColumnFull
import com.rs.connect4.domain.{Board, GameResult, Piece, Player}

trait GameLogic {

  def putPiece(board: Board, column: Int, piece: Piece): Either[ColumnFull.type, Board]

  def gameResult(columnOfLatestPiece: Int, rowOfLatestPiece: Int, currentPlayer: Player, board: Board): GameResult

}
