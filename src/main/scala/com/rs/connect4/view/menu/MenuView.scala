package com.rs.connect4.view.menu

import com.rs.connect4.domain.MenuFooterMessage

trait MenuView {

  def header: String

  def content(suspendedRunningGame: Boolean): String

  def footer(message: MenuFooterMessage): String
}
