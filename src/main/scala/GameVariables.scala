import scala.collection.immutable.HashMap

case class GameVariables() {
  var scorePlayer: Int = 0
  var scoreComputer: Int = 0

  var playerInput: Int = 0
  var computerInput: Int = 0

  val valueOfOption: HashMap[String, Int] =
    HashMap("Rock" -> 1, "Paper" -> 2, "Scissors" -> 3)

  val optionOfValue: HashMap[Int, String] =
    HashMap(1 -> "Rock", 2 -> "Paper", 3 -> "Scissors")
}
