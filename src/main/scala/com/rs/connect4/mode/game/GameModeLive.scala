package com.rs.connect4.mode.game
import com.rs.connect4.domain.State

final case class GameModeLive() extends GameMode {

  override def process(input: String, state: State.Game): State = ???

  override def render(state: State.Game): String = ???
}
