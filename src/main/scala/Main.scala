import scala.util.Random

object Main extends App with TexasHoldem {
  val printHand: Hand => Hand = { hand =>
    hand.cards foreach println
    hand
  }

  def suit[T](suit: Suit) = List(
    Card(suit, Two),
    Card(suit, Three),
    Card(suit, Four),
    Card(suit, Five),
    Card(suit, Six),
    Card(suit, Seven),
    Card(suit, Eight),
    Card(suit, Nine),
    Card(suit, Ten),
    Card(suit, Jack),
    Card(suit, Queen),
    Card(suit, King),
    Card(suit, Ace))

  val random = new Random(1234)
  val carddeck = shuffle(random, Deck(
    suit(Heart) ++
      suit(Spade) ++
      suit(Club) ++
      suit(Diamond)))

  val player1: (Deck, Hand) = dealHand(carddeck)
  val player2 = dealHand(player1._1)

  println("Player 1 Hand: ")
  printHand(player1._2)
  println("Player 2 Hand: ")
  printHand(player2._2)


}
