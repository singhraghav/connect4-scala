package com.rs.connect4.mode.game.running
import com.rs.connect4.domain.{AppError, MenuFooterMessage, RunningGameCommand, RunningGameFooterMessage, State}
import com.rs.connect4.gamelogic.GameLogic
import com.rs.connect4.parser.game.running.RunningCommandParser
import com.rs.connect4.view.game.running.RunningView

case class RunningGameModeLive(view: RunningView, parser: RunningCommandParser, gameLogic: GameLogic) extends RunningGameMode {

  override def process(input: String, state: State.RunningGame): State =
    parser.parse(input)
      .flatMap {
        case RunningGameCommand.Menu => Right(State.Menu(game = Some(state), MenuFooterMessage.Empty))
        case RunningGameCommand.Put(column) => putField(column, state)
      }.getOrElse(state.copy(footerMessage = RunningGameFooterMessage.InValidCommand))

  private def putField(column: Int, state: State.RunningGame): Either[AppError, State.RunningGame] = {
    val (currentPlayer, remainingTurns) = state.players.dequeue
    for {
      updatedBoard <- gameLogic.putPiece(state.board, column, currentPlayer.piece)
      newResult    <- Right(gameLogic.gameResult(column, state.board.rowValueWherePieceWillLand(column), currentPlayer.piece))
    } yield state.copy(board = updatedBoard, remainingTurns.enqueue(currentPlayer), result = newResult)
  }

  override def render(state: State.RunningGame): String =
    List(
      view.header(state.result, state.players),
      view.content(state.board, state.result),
      view.footer(state.footerMessage)
    ).mkString("\n\n")

}
