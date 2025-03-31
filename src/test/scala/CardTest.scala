import munit.FunSuite
import pintas.{Diamond, Pica}
import rangos.{As, Ten, Three, Two}

import scala.collection.mutable.ArrayBuffer

class CardTest extends FunSuite {
  var AsP: Card = _
  var ThreeP: Card = _
  var TwoP: Card = _
  var tenD: Card = _
  var twoD: Card = _
  var carts: ArrayBuffer[Card] = _
  var mano: Hand = _

  // Setup inicial
  override def beforeEach(context: BeforeEach): Unit = {
    AsP = new Card(new As, new Pica)
    ThreeP = new Card(new Three, new Pica)
    TwoP = new Card(new Two, new Pica)
    tenD = new Card(new Ten, new Diamond)
    twoD = new Card(new Two, new Diamond)
    carts = ArrayBuffer[Card]()
  }

  test("Check a par") {
    carts += AsP
    carts += TwoP
    carts += tenD
    carts += twoD
    carts += ThreeP
    mano = new Hand(carts)

    assertEquals(mano.check(), "La mano más alta es un par de 2")
  }

  test("Check dos pares") {
    carts += ThreeP
    carts += TwoP
    carts += TwoP // Añadimos otro par
    carts += tenD
    carts += ThreeP
    mano = new Hand(carts)

    assertEquals(mano.check(), "Dos pares de 2 y 3")
  }

  test("Check un trío") {
    carts += AsP
    carts += AsP // Añadimos un par extra
    carts += AsP // Añadimos otro As
    carts += tenD
    carts += ThreeP
    mano = new Hand(carts)

    assertEquals(mano.check(), "La mano más alta es un trío de 1")
  }

  test("Check full house") {
    carts += AsP
    carts += AsP // Añadimos un par
    carts += AsP // Añadimos el trío
    carts += twoD // Añadimos un par
    carts += twoD // Añadimos el segundo dos
    mano = new Hand(carts)

    assertEquals(mano.check(), "Full house de 1 y 2")
  }
}
