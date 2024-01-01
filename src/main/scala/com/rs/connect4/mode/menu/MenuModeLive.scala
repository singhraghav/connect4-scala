package com.rs.connect4.mode.menu
import com.rs.connect4.domain.MenuCommand.{NewGame, Quit, Resume}
import com.rs.connect4.domain.{MenuFooterMessage, State}
import com.rs.connect4.parser.menu.MenuCommandParser
import com.rs.connect4.view.menu.MenuView

final case class MenuModeLive(view: MenuView, parser: MenuCommandParser) extends MenuMode {
  override def process(input: String, state: State.Menu): State =
    parser
      .parse(input)
      .map {
        case NewGame => ???
        case Resume  => ???
        case Quit    => ???
      }.getOrElse(state.copy(footerMessage = MenuFooterMessage.InvalidCommand))

  override def render(state: State.Menu): String =
    List(
      view.header,
      view.content(state.game.nonEmpty),
      view.footer(state.footerMessage)
    ).mkString("\n\n")
}
