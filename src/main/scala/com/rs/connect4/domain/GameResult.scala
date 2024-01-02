package com.rs.connect4.domain

sealed trait GameResult

object GameResult {
  case object OnGoing extends GameResult

  case class Win(piece: Piece) extends GameResult

  case object Draw extends GameResult
}