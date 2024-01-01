package com.rs.connect4.controller

import com.rs.connect4.domain.State
import com.rs.connect4.mode.game.GameMode
import com.rs.connect4.mode.menu.MenuMode
import com.rs.connect4.mode.pause.PauseMode

final class GameController(menuMode: MenuMode, gameMode: GameMode, pauseMode: PauseMode) {

  def process(input: String, state: State): Option[State] = ???

  def render(state: State): String = ???

}
