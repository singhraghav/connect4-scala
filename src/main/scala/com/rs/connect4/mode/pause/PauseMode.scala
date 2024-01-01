package com.rs.connect4.mode.pause

import com.rs.connect4.domain.State
import com.rs.connect4.domain.State.Pause

trait PauseMode {

  def process(input: String, state: Pause): State

  def render(state: Pause): String

}
