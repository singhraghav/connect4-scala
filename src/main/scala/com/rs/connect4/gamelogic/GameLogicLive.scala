package com.rs.connect4.gamelogic
import com.rs.connect4.domain.AppError.ColumnFull
import com.rs.connect4.domain.Board.Column
import com.rs.connect4.domain.{Board, GameResult, Piece, Player}

case class GameLogicLive() extends GameLogic {

  override def putPiece(board: Board, column: Int, piece: Piece): Either[ColumnFull.type, Board] = {
    val emptyRowForThisColumns = board.rowValueWherePieceWillLand(column)
    if(emptyRowForThisColumns >= board.boardHeight)
      Left(ColumnFull)
    else {
      board.grid(emptyRowForThisColumns)(column) = piece.color
      val updatedBoard = {
        board.copy(rowValueWherePieceWillLand = board.rowValueWherePieceWillLand ++ Map[Column, Int]((column, emptyRowForThisColumns + 1)))
      }
      Right(updatedBoard)
    }
  }

  override def gameResult(columnOfLatestPiece: Int, rowOfLatestPiece: Int, currentPlayer: Player, board: Board): GameResult = {
    type RowUpdater = Int => Int
    type ColumnUpdater = Int => Int

    def boardConsecutivePieceChecker: RowUpdater => ColumnUpdater => Boolean =
      board.consecutiveCheck(piece => piece == currentPlayer.piece.color, n = 4)(colStart = columnOfLatestPiece, rowStart = rowOfLatestPiece)

    def wonInSouthernDirection(): Boolean = boardConsecutivePieceChecker(row => row - 1)(identity)

    def wonInWesternDirection(): Boolean = boardConsecutivePieceChecker(identity)(col => col - 1)

    def wonInEasternDirection(): Boolean = boardConsecutivePieceChecker(identity)(col => col + 1)

    def wonInNorthWestDiagonal(): Boolean = boardConsecutivePieceChecker(row => row + 1)(col => col - 1)

    def wonInSouthWestDiagonal(): Boolean = boardConsecutivePieceChecker(row => row - 1)(col => col - 1)

    def wonInNorthEastDiagonal(): Boolean = boardConsecutivePieceChecker(row => row + 1)(col => col + 1)

    def wonInSouthEastDiagonal(): Boolean = boardConsecutivePieceChecker(row => row - 1)(col => col + 1)
    
    def wonInOneOfDiagonal(): Boolean = wonInNorthWestDiagonal() || wonInSouthWestDiagonal() || wonInNorthEastDiagonal() || wonInSouthEastDiagonal()
    
    if(wonInSouthernDirection() || wonInWesternDirection() || wonInEasternDirection() || wonInOneOfDiagonal())
      GameResult.Win(currentPlayer)
    else 
      GameResult.OnGoing
  }
}
