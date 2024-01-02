package com.rs.connect4.parser.game.initializing

import com.rs.connect4.domain.InitializingGameCommands.{AddPlayer, InsertPlayerDetails, Quit, StartGame}
import com.rs.connect4.domain.{AppError, InitializingGameCommands}

case class InitializingCommandParser() {

  def parse(input: String): Either[AppError, InitializingGameCommands] =
    input.toLowerCase() match {
      case "add player" => Right(AddPlayer)
      case "quit"       => Right(Quit)
      case "start game" => Right(StartGame)
      case other        => InsertPlayerDetails.fromString(other)
    }
}
