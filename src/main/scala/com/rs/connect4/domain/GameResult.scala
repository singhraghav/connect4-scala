package com.rs.connect4.domain

sealed trait GameResult

object GameResult {
  case object OnGoing extends GameResult

  case class Win(player: Player) extends GameResult

  case object Draw extends GameResult
}