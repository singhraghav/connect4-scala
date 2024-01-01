package com.rs.connect4.domain

sealed trait AppError

object AppError {
  case object ParseError extends AppError

}