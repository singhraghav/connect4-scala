package com.rs.connect4.domain

case class Player(name: String, piece: Piece) {
  def asDisplayString: String = s"- [ Name : $name , Color : ${piece.color} ]"
}

