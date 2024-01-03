package com.rs.connect4.domain

import com.rs.connect4.domain.AppError.ParseError

import scala.util.Try

sealed trait MenuCommand

object MenuCommand {

  final case object NewGame extends MenuCommand

  final case object Resume extends MenuCommand

  final case object Quit extends MenuCommand
}

sealed trait InitializingGameCommands

object InitializingGameCommands {

  final case object StartGame extends InitializingGameCommands

  final case object AddPlayer extends InitializingGameCommands

  final case class InsertPlayerDetails(name: String, colorCode: String) extends InitializingGameCommands

  object InsertPlayerDetails {
    def fromString(input: String): Either[AppError, InsertPlayerDetails] = Try {
      val combined = input.split(",")
      val name = combined(0).trim
      val colorCode = combined(1).trim

      if (name.isEmpty || colorCode.isEmpty || colorCode.length > 1) throw new IllegalAccessException("illegal argument for player details")
      else InsertPlayerDetails(name, colorCode)
    }.toEither.left.map(_ => ParseError)
  }

  final case object Quit extends InitializingGameCommands
}

sealed trait RunningGameCommand

object RunningGameCommand {
  case object Menu extends RunningGameCommand

  case class Put(column: Int) extends RunningGameCommand
}