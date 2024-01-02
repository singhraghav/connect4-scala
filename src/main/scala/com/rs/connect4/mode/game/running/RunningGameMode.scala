package com.rs.connect4.mode.game.running

import com.rs.connect4.domain.State
import com.rs.connect4.domain.State.{Game, RunningGame}

trait RunningGameMode {

  def process(input: String, state: RunningGame): State

  def render(state: RunningGame): String

}
