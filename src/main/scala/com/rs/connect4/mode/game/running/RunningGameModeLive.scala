package com.rs.connect4.mode.game.running
import com.rs.connect4.domain.State
import com.rs.connect4.parser.game.running.RunningCommandParser
import com.rs.connect4.view.game.running.RunningView

case class RunningGameModeLive(view: RunningView, parser: RunningCommandParser) extends RunningGameMode {

  override def process(input: String, state: State.RunningGame): State = ???

  override def render(state: State.RunningGame): String =
    List(
      view.header(state.result, state.players),
      view.content(state.board, state.result),
      view.footer(state.footerMessage)
    ).mkString("\n\n")

}
