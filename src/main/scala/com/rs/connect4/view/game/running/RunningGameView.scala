package com.rs.connect4.view.game.running
import com.rs.connect4.domain.GameResult.{Draw, OnGoing, Win}
import com.rs.connect4.domain.{Board, GameResult, Player, RunningGameFooterMessage}

import scala.collection.immutable.Queue

case class RunningGameView() extends RunningView {

  override def header(result: GameResult, allPlayers: Queue[Player]): String = {
    result match {
      case OnGoing =>
        val turn = allPlayers.head
        s"""${turn.asDisplayString} turn to play
           |
           |Select the column in which you want to drop the piece or type `menu` and confirm with <enter>
           |""".stripMargin
      case Win(playerWhoWon) =>
        s"""The game ended with ${playerWhoWon.asDisplayString} win.
           |
           |Press <enter> to continue.""".stripMargin
      case Draw =>
        s"""The game ended in a draw.
           |
           |Press <enter> to continue.""".stripMargin
    }
  }

  override def content(board: Board, result: GameResult): String = {
    val numOfColumns = board.grid(0).size
    val rowSeparator = s"""╬═════╬${"═════╬" * (numOfColumns - 1)}"""
    val gridAsString =
      board
        .grid
        .toList
        .reverse
        .map { row =>
          row.toList.map(_.toUpperCase()).mkString("║  ", "  ║  ", "  ║")
        }
        .mkString(s"\n$rowSeparator\n")
    val colHeader = (1 to numOfColumns).map(_.toString).mkString("   ", "     ", "   ")
    val enclosingLine = s"""${"╬═════" * numOfColumns}╬"""

    s"""$colHeader\n$enclosingLine\n$gridAsString\n$enclosingLine"""
  }

  override def footer(message: RunningGameFooterMessage): String = message match {
    case RunningGameFooterMessage.Empty => ""
    case RunningGameFooterMessage.InValidCommand => "Invalid command. Try again."
    case RunningGameFooterMessage.ColumnFull => "Chosen Column is already full. Try another."
  }
}
