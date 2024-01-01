package com.rs.connect4.ui

import com.rs.connect4.ui.ConsoleUI.codeToClearScreen

import scala.io.StdIn

final case class ConsoleUI() extends UI {

  override def getInput: String = StdIn.readLine()

  override def display(body: String): Unit = {
    print(codeToClearScreen)
    println(body)
  }
}

object ConsoleUI {
  val codeToClearScreen = "\u001b[H\u001b[2J"
}
