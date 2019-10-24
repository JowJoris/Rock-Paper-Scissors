case class GameLogic() {
  val variables : GameVariables = GameVariables.apply()

  def startGame(): Unit = {
    println("Welcome to Rock Paper Scissors!\n")
    playerChoice()
  }

  def playerChoice(): Unit = {
    val input = scala.io.StdIn.readLine("Choose 'Rock', 'Paper' or 'Scissors. Type Exit to quit\n").capitalize
    playerOption(input)
  }

  def computerChoice(): Unit = {
    val r = scala.util.Random
    variables.computerInput = r.nextInt(3) + 1
    calculateWinner()
  }

  def playerOption(input: String): Unit = {
    if (input.equals("Exit")) {
      println("Goodbye!")
    }
    else {
      val playerOption = getValueOfOption(input)
      if (playerOption != 0) {
        variables.playerInput = playerOption
        computerChoice()
      }
      else {
        println("Wrong input!")
        playerChoice()
      }
    }
  }

  def getValueOfOption(input: String): Int = {
    variables.valueOfOption.getOrElse(input, 0)
  }

  def getOptionOfValue(input: Int): String = {
    variables.optionOfValue.getOrElse(input, "")
  }

  def playerWin(): Unit = {
    println("You win :) Your choice: " +
      getOptionOfValue(variables.playerInput) +
      ", Computer: " +
      getOptionOfValue(variables.computerInput))
    variables.scorePlayer += 1
  }

  def computerWin(): Unit = {
    println("You lose :( Your choice: " +
      getOptionOfValue(variables.playerInput) +
      ", Computer: " +
      getOptionOfValue(variables.computerInput))
    variables.scoreComputer += 1
  }

  def calculateWinner(): Unit = {
    if (variables.playerInput == variables.computerInput) {
      println("Draw! You both chose " + getOptionOfValue(variables.playerInput))
    }
    else {
      if (variables.playerInput == 1 && variables.computerInput == 3) {
        playerWin()
      }
      else if (variables.playerInput == 3 && variables.computerInput == 1) {
        computerWin()
      }
      else if (variables.playerInput > variables.computerInput) {
        playerWin()
      }
      else {
        computerWin()
      }
    }
    scoreOverview()
  }

  def scoreOverview(): Unit = {
    println("\nScore:")
    println("=========")
    println("You: " + variables.scorePlayer)
    println("Computer: " + variables.scoreComputer + "\n")
    playerChoice()
  }
}
