package com.rs.connect4.loop

import com.rs.connect4.controller.GameController
import com.rs.connect4.domain.State
import com.rs.connect4.ui.UI

import scala.annotation.tailrec

final case class GameLoop(ui: UI, controller: GameController) {

  @tailrec
  def run(state: State): Unit = {
    process(state) match {
      case Some(nextState) => run(nextState)
      case None => ()
    }
  }

  private def process(state: State): Option[State] = {
    displayCurrentStateOnScreen(state)
    state match {
      case State.Terminate => None
      case _ =>
        val nextUserInput = ui.getInput
        controller.process(nextUserInput, state)
    }
  }

  private def displayCurrentStateOnScreen(currentState: State): Unit = {
    val stateAsString = controller.render(currentState)
    ui.display(stateAsString)
  }

}
