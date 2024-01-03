package com.rs.connect4.view.game.running

import com.rs.connect4.domain.{Board, GameResult, Player, RunningGameFooterMessage}

import scala.collection.immutable.Queue

trait RunningView {

  def header(result: GameResult, allPlayers: Queue[Player]): String

  def content(board: Board, result: GameResult): String

  def footer(message: RunningGameFooterMessage): String

}
