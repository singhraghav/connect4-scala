package com.rs.connect4

import com.rs.connect4.controller.GameController
import com.rs.connect4.domain.State
import com.rs.connect4.gamelogic.GameLogicLive
import com.rs.connect4.loop.GameLoop
import com.rs.connect4.mode.game.GameModeLive
import com.rs.connect4.mode.game.initializing.{InitializingGameMode, InitializingGameModeLive}
import com.rs.connect4.mode.game.running.{RunningGameMode, RunningGameModeLive}
import com.rs.connect4.mode.menu.MenuModeLive
import com.rs.connect4.parser.game.initializing.InitializingCommandParser
import com.rs.connect4.parser.game.running.RunningCommandParser
import com.rs.connect4.parser.menu.MenuCommandParserLive
import com.rs.connect4.ui.{ConsoleUI, UI}
import com.rs.connect4.view.game.initializing.InitializingViewLive
import com.rs.connect4.view.game.running.RunningGameView
import com.rs.connect4.view.menu.MenuViewLive

object Main extends App {

  val ui: UI = ConsoleUI()

  val controller: GameController = {

    val menuMode = {
      val menuView = MenuViewLive()
      val parser = MenuCommandParserLive()
      MenuModeLive(view = menuView, parser = parser)
    }

    val gameMode = {
      val initializingMode: InitializingGameMode = {
        InitializingGameModeLive(InitializingViewLive(), InitializingCommandParser())
      }

      val runningGameMode: RunningGameMode = {
        RunningGameModeLive(RunningGameView(), RunningCommandParser(), GameLogicLive())
      }
      GameModeLive(initializingMode, runningGameMode)
    }

    GameController(menuMode = menuMode, gameMode = gameMode)
  }

  GameLoop(ui, controller).run(State.initial)

}