package com.rs.connect4.view.game.initializing
import com.rs.connect4.domain.InitilazingGameFooterMessage.{Empty, InValidCommand, SelectionError}
import com.rs.connect4.domain.{InitilazingGameFooterMessage, Player}

case class InitializingViewLive() extends InitializingView {

  override def header(players: List[Player]): String = {
    if (players.isEmpty)
      """
        |   _   _   _   _   _   _   _   _   _   _   _   _
        |  / \ / \ / \ / \ / \ / \ / \ / \ / \ / \ / \ / \
        | | I | n | i | t | i | a | l | i | z | i | n | g |
        | |___|___|___|___|___|___|___|___|___|___|___|___|
        |""".stripMargin
    else
      ("Initialized Players:" :: players.map(_.asDisplayString))
        .mkString("\n")
  }

  override def content(initializedCount: Int, wantToEnterPlayerDetails: Boolean): String = {
    val menuOptions =
    if (initializedCount == 0 && !wantToEnterPlayerDetails)
      List("Add Player", "Quit")
    else if (initializedCount == 2)
      List("Start Game", "Quit")
    else
      List(s"Enter Player ${initializedCount + 1} Name and One Character Code For Board Piece Color separated by ',': e.g - Raghav,R")

    menuOptions.map(cmd => s"* $cmd").mkString("\n")
  }

  override def footer(message: InitilazingGameFooterMessage): String = message match {
    case Empty => ""
    case InValidCommand => "Invalid Command. Try again."
    case SelectionError(message) => message
  }

}
