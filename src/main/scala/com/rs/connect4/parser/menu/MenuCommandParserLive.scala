package com.rs.connect4.parser.menu
import com.rs.connect4.domain.AppError.ParseError
import com.rs.connect4.domain.{AppError, MenuCommand}

final case class MenuCommandParserLive() extends MenuCommandParser {

  override def parse(input: String): Either[AppError, MenuCommand] = {
    input.toLowerCase() match {
      case "new game" => Right(MenuCommand.NewGame)
      case "resume"   => Right(MenuCommand.Resume)
      case "quit"     => Right(MenuCommand.Quit)
      case _          => Left(ParseError)
    }
  }

}
