package com.rs.connect4.mode.game
import com.rs.connect4.domain.State
import com.rs.connect4.domain.State.{InitilazingGame, RunningGame}
import com.rs.connect4.mode.game.initializing.InitializingGameMode
import com.rs.connect4.mode.game.running.RunningGameMode

final case class GameModeLive(initializingMode: InitializingGameMode, runningGameMode: RunningGameMode) extends GameMode {

  override def process(input: String, state: State.Game): State = state match {
    case s: InitilazingGame => initializingMode.process(input,s)
    case s: RunningGame => runningGameMode.process(input, s)
  }

  override def render(state: State.Game): String = state match {
    case s: InitilazingGame => initializingMode.render(s)
    case s: RunningGame => runningGameMode.render(s)
  }
}
