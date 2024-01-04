package com.rs.connect4.domain

sealed trait AppError

object AppError {
  case object ParseError extends AppError

  case class InvalidPlayer(message: String) extends AppError

  case object ColumnFull extends AppError
}