import scala.util.Random

trait FiveCardStud extends CardGame {
  val shuffle: (Random, Deck) => Deck = (random, deck) => Deck(random.shuffle(deck.cards))
  val dealCard: Deck => (Deck, Option[Card]) = deck => deck.cards match {
    case x :: xs => (Deck(xs), Some(Card(x.suit, x.rank)))
    case Nil => (Deck(List.empty[Card]), None)
  }

  val dealHand: Deck => (Deck, Hand) = deck => {
    // pick up 5 cards
    val (d1, h1) = dealCard(deck)
    val (d2, h2) = dealCard(d1)
    val (d3, h3) = dealCard(d2)
    val (d4, h4) = dealCard(d3)
    val (finalDeck, h5) = dealCard(d4)

    val cards = for {
      c1 <- h1
      c2 <- h2
      c3 <- h3
      c4 <- h4
      c5 <- h5
    } yield List(c1, c2, c3, c4, c5)

    (finalDeck, Hand(cards.getOrElse(List.empty[Card])))
  }
}
