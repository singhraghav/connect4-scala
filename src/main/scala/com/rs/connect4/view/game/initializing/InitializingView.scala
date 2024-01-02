package com.rs.connect4.view.game.initializing

import com.rs.connect4.domain.{InitilazingGameFooterMessage, Player}

trait InitializingView {

  def header(players: List[Player]): String

  def content(initializedCount: Int, wantToEnterPlayerDetails: Boolean): String

  def footer(message: InitilazingGameFooterMessage): String

}
