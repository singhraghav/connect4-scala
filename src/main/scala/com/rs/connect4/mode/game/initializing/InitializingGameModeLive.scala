package com.rs.connect4.mode.game.initializing
import com.rs.connect4.domain.AppError.{InvalidPlayer, ParseError}
import com.rs.connect4.domain.InitializingGameCommands.{AddPlayer, InsertPlayerDetails, Quit, StartGame}
import com.rs.connect4.domain.State.RunningGame
import com.rs.connect4.domain.{AppError, Board, GameResult, InitilazingGameFooterMessage, Piece, Player, RunningGameFooterMessage, State}
import com.rs.connect4.parser.game.initializing.InitializingCommandParser
import com.rs.connect4.view.game.initializing.InitializingView

import scala.collection.immutable.Queue

case class InitializingGameModeLive(view: InitializingView, parser: InitializingCommandParser) extends InitializingGameMode {

  override def process(input: String, state: State.InitilazingGame): State = {

    def errorHandler(error: AppError): State = error match {
      case ParseError => state.copy(footerMessage = InitilazingGameFooterMessage.InValidCommand)
      case InvalidPlayer(message) => state.copy(footerMessage = InitilazingGameFooterMessage.SelectionError(message))
    }

    parser.parse(input)
      .flatMap {
        case AddPlayer => Right(state.copy(enteringPlayerDetails = true))
        case Quit => Right(State.Terminate)
        case StartGame => Right(RunningGame(Board(), Queue.from(state.players), GameResult.OnGoing, RunningGameFooterMessage.Empty))
        case InsertPlayerDetails(name, colorCode) =>
          state.players.find(_.piece.color == colorCode)
            .map(existingPlayer => Left(InvalidPlayer(s"Error: Color Code Should Be Unique For Every Player, ${existingPlayer.name} already selected color $colorCode")))
            .getOrElse(Right(state.copy(players = Player(name, Piece(colorCode)) :: state.players, footerMessage = InitilazingGameFooterMessage.Empty)))
      }.fold(errorHandler, identity)
  }

  override def render(state: State.InitilazingGame): String =
    List(
      view.header(state.players),
      view.content(state.players.size, state.enteringPlayerDetails),
      view.footer(state.footerMessage)
    ).mkString("\n\n")

}
