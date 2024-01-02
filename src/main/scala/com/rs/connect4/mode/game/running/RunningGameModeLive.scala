package com.rs.connect4.mode.game.running
import com.rs.connect4.domain.State

case class RunningGameModeLive() extends RunningGameMode {

  override def process(input: String, state: State.RunningGame): State = ???

  override def render(state: State.RunningGame): String = ???

}
