package com.rs.connect4.parser.game.running

import com.rs.connect4.domain.AppError.ParseError
import com.rs.connect4.domain.RunningGameCommand.Put
import com.rs.connect4.domain.{AppError, RunningGameCommand}

import scala.util.{Success, Try}

case class RunningCommandParser() {

  def parse(input: String): Either[AppError, RunningGameCommand] =
    input.toLowerCase() match {
      case "menu" => Right(RunningGameCommand.Menu)
      case other =>
        val mayBeValidColumnNumber = Try(other.toInt)
        mayBeValidColumnNumber match {
          case Success(column) if column >=1 || column <= 7 => Right(Put(column))
          case _ => Left(ParseError)
        }
    }

}
