package com.rs.connect4

import com.rs.connect4.controller.GameController
import com.rs.connect4.domain.State
import com.rs.connect4.loop.GameLoop
import com.rs.connect4.ui.UI

object Main extends App {

  val ui: UI = ???

  val controller: GameController = ???

  GameLoop(ui, controller).run(State.initial)

}