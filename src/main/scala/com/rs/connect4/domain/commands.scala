package com.rs.connect4.domain

sealed trait MenuCommand

object MenuCommand {

  final case object NewGame extends MenuCommand

  final case object Resume extends MenuCommand

  final case object Quit extends MenuCommand
}
