package com.rs.connect4.mode.menu
import com.rs.connect4.domain.State
import com.rs.connect4.view.menu.MenuView

final case class MenuModeLive(view: MenuView) extends MenuMode {
  override def process(input: String, state: State.Menu): State = ???

  override def render(state: State.Menu): String =
    List(
      view.header,
      view.content(state.game.nonEmpty),
      view.footer(state.footerMessage)
    ).mkString("\n\n")
}
