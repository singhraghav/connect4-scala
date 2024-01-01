package com.rs.connect4.controller

import com.rs.connect4.domain.State
import com.rs.connect4.mode.game.GameMode
import com.rs.connect4.mode.menu.MenuMode
import com.rs.connect4.mode.pause.PauseMode

final case class GameController(menuMode: MenuMode, gameMode: GameMode, pauseMode: PauseMode) {

  def process(input: String, state: State): Option[State] = state match {
    case s: State.Menu => Some(menuMode.process(input, s))
    case s: State.Game => Some(gameMode.process(input, s))
    case s: State.Pause => Some(pauseMode.process(input, s))
    case State.Terminate => None
  }

  def render(state: State): String = state match {
    case s: State.Menu => menuMode.render(s)
    case s: State.Game => gameMode.render(s)
    case s: State.Pause => pauseMode.render(s)
    case State.Terminate => "Quitting Game ......"
  }

}
