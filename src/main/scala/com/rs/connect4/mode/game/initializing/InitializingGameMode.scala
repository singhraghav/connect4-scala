package com.rs.connect4.mode.game.initializing

import com.rs.connect4.domain.State

trait InitializingGameMode {

  def process(input: String, state: State.InitilazingGame): State

  def render(state: State.InitilazingGame): String

}
