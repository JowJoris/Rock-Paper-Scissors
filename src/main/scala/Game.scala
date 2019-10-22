object Game extends App {
  val logic : GameLogic = GameLogic.apply()
  val variables : GameVariables = GameVariables.apply()

  logic.startGame(variables)

}
