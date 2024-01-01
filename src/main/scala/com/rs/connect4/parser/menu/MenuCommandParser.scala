package com.rs.connect4.parser.menu

import com.rs.connect4.domain.{AppError, MenuCommand}

trait MenuCommandParser {

  def parse(input: String): Either[AppError, MenuCommand]

}
