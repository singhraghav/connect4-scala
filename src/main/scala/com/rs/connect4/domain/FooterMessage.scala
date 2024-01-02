package com.rs.connect4.domain


sealed trait RunningGameFooterMessage

object RunningGameFooterMessage {
  case object Empty extends RunningGameFooterMessage

  case object InValidCommand extends RunningGameFooterMessage

  case object ColumnFull extends RunningGameFooterMessage
}

sealed trait MenuFooterMessage

object MenuFooterMessage {
  final case object Empty extends MenuFooterMessage

  final case object InvalidCommand extends MenuFooterMessage
}


sealed trait InitilazingGameFooterMessage

object InitilazingGameFooterMessage {

  case object Empty extends InitilazingGameFooterMessage

  case object InValidCommand extends InitilazingGameFooterMessage

  case class SelectionError(message: String) extends InitilazingGameFooterMessage
}

