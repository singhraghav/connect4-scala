package com.rs.connect4.view.menu
import com.rs.connect4.domain.MenuFooterMessage

final case class MenuViewLive() extends MenuView {

  override def header: String =
    """
      |  ______   ______   .__   __. .__   __.  _______   ______ .___________.    _  _
      | /      | /  __  \  |  \ |  | |  \ |  | |   ____| /      ||           |   | || |
      ||  ,----'|  |  |  | |   \|  | |   \|  | |  |__   |  ,----'`---|  |----`   | || |_
      ||  |     |  |  |  | |  . `  | |  . `  | |   __|  |  |         |  |        |__   _|
      ||  `----.|  `--'  | |  |\   | |  |\   | |  |____ |  `----.    |  |           | |
      | \______| \______/  |__| \__| |__| \__| |_______| \______|    |__|           |_|
      |""".stripMargin

  override def content(suspendedRunningGame: Boolean): String = {
    val availableCommands = {
      val defaultOptions = List("New Game", "Quit")
      if (suspendedRunningGame) "Resume" :: defaultOptions else defaultOptions
    }
    availableCommands
      .map(cmd => s"* $cmd")
      .mkString("\n")
  }

  override def footer(message: MenuFooterMessage): String =
    message match {
      case MenuFooterMessage.Empty => ""
      case MenuFooterMessage.InvalidCommand => "Invalid Command. Try again."
    }
}
