package com.rs.connect4.mode.menu

import com.rs.connect4.domain.State
import com.rs.connect4.domain.State.Menu

trait MenuMode {

  def process(input: String, state: Menu): State

  def render(state: Menu): String

}
