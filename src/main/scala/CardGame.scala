import scala.util.Random

trait CardGame {
  sealed trait Suit
  case object Heart extends Suit
  case object Diamond extends Suit
  case object Spade extends Suit
  case object Club extends Suit

  sealed abstract class Rank(val value: Int)
  case object Two extends Rank(2)
  case object Three extends Rank(3)
  case object Four extends Rank(4)
  case object Five extends Rank(5)
  case object Six extends Rank(6)
  case object Seven extends Rank(7)
  case object Eight extends Rank(8)
  case object Nine extends Rank(9)
  case object Ten extends Rank(10)
  case object Jack extends Rank(11)
  case object Queen extends Rank(12)
  case object King extends Rank(13)
  case object Ace extends Rank(14)

  case class Card(suit: Suit, rank: Rank)

  case class Hand(cards: List[Card])
  case class Deck(cards: List[Card])

  case class Player(name: String, hand: Hand)
  case class Game(deck: Deck, players: List[Player])

  val shuffle: (Random, Deck) => Deck
  val dealCard: Deck => (Deck, Option[Card])
  val dealHand: Deck => (Deck, Hand)
}



