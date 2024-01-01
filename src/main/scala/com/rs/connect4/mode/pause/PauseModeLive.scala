package com.rs.connect4.mode.pause
import com.rs.connect4.domain.State

final case class PauseModeLive() extends PauseMode {

  override def process(input: String, state: State.Pause): State = ???

  override def render(state: State.Pause): String = ???
}
