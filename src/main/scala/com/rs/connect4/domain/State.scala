package com.rs.connect4.domain

import scala.collection.immutable.Queue

sealed trait State

object State {

  sealed trait Game extends State

  case class RunningGame(
                          board: Board,
                          players: Queue[Player],
                          result: GameResult,
                          footerMessage: RunningGameFooterMessage
                 ) extends Game

  case class InitilazingGame(players: List[Player], enteringPlayerDetails: Boolean, footerMessage: InitilazingGameFooterMessage) extends Game

  case object Terminate extends State

  case class Menu(game: Option[Game], footerMessage: MenuFooterMessage) extends State

  case class Pause() extends State

  val initial: State = Menu(game = None, MenuFooterMessage.Empty)
}
