package com.rs.connect4.domain

sealed trait MenuFooterMessage

object MenuFooterMessage {
  final case object Empty extends MenuFooterMessage

  final case object InvalidCommand extends MenuFooterMessage
}
