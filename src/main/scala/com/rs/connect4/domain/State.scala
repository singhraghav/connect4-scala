package com.rs.connect4.domain

sealed trait State

object State {

  case class Game() extends State

  case object Terminate extends State

  case class Menu(game: Option[Game], footerMessage: MenuFooterMessage) extends State

  case class Pause() extends State

  val initial: State = Menu(game = None, MenuFooterMessage.Empty)
}
