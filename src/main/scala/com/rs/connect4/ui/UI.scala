package com.rs.connect4.ui

trait UI {

  def getInput: String

  def display(body: String): Unit

}
