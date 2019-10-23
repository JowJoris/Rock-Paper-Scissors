case class GameLogic() {
  var variables: GameVariables = _

  def startGame(gameVariables: GameVariables): Unit = {
    variables = gameVariables
    println("Welcome to Rock Paper Scissors!\n")
    makeChoices()
  }

  def makeChoices(): Unit = {
    playerChoice()
    computerChoice()
    calculateWinner()
  }

  def playerChoice(): Unit = {
    val input = scala.io.StdIn.readLine("Choose 'Rock', 'Paper' or 'Scissors\n").capitalize
    playerOption(input)
  }

  def computerChoice(): Unit = {
    val r = scala.util.Random
    variables.computerInput = r.nextInt(3) + 1
  }

  def playerOption(input: String): Unit = {
    val playerOption = getValueOfOption(input)
    if(playerOption != 0){
      variables.playerInput = playerOption
    }
    else {
      println("Wrong input!")
      playerChoice()
    }
  }

  def getValueOfOption(input: String): Int = {
    variables.valueOfOption.getOrElse(input, 0)
  }

  def getOptionOfValue(input: Int): String = {
    variables.optionOfValue.getOrElse(input, "")
  }

  def calculateWinner(): Unit = {
    if (variables.playerInput == variables.computerInput){
      println("Draw! You both chose " + getOptionOfValue(variables.playerInput))
    }
    else if (variables.playerInput % 3 > variables.computerInput % 3){
      println("You win :) Your choice: " +
        getOptionOfValue(variables.playerInput) +
        ", Computer: " +
        getOptionOfValue(variables.computerInput))
      variables.scorePlayer += 1
    }
    else {
      println("You lose :( Your choice: " +
        getOptionOfValue(variables.playerInput) +
        ", Computer: " +
        getOptionOfValue(variables.computerInput))
      variables.scoreComputer += 1
    }
    scoreOverview()
  }

  def scoreOverview(): Unit = {
    println("\nScore:")
    println("You: " + variables.scorePlayer)
    println("Computer: " + variables.scoreComputer)
    endGame()
  }

  def endOption(input: String) : Unit = {
    if(input.equals("Restart")){
      makeChoices()
    }
    else if (input.equals("Exit")){
      println("Goodbye!")
    }
    else {
      println("Wrong input!")
      endGame()
    }
  }

  def endGame(): Unit = {

    val input = scala.io.StdIn.readLine("Type Restart to play again or type Exit to quit the game\n").capitalize
    endOption(input)
  }

}
