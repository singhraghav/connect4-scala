package com.rs.connect4.mode.game

import com.rs.connect4.domain.State
import com.rs.connect4.domain.State.Game

trait GameMode {

  def process(input: String, state: Game): State

  def render(state: Game): String

}
