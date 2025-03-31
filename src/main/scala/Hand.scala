import rangos.Rangos

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * La clase `Hand` representa una mano de cartas y proporciona un método para analizar las cartas y determinar
 * el tipo de mano más alta (par, trío, full house, etc.).
 *
 * @param cards Una lista de cartas representadas por objetos `Card`.
 */
class Hand (cards:ArrayBuffer[Card]){

  /**
   * Mapa mutable que almacena el conteo de las cartas de la mano.
   * La clave es el orden del rango de la carta (`card.rank.order`), y el valor es la cantidad de veces
   * que ese rango se repite en la mano.
   */
  val counter: mutable.Map[Int, Int] = mutable.Map()
  def check():String= {
    //es for es para que las cartas se vayan sumando
    for (card <- cards) {
      // Si el rango de la carta ya está presente en el mapa `counter`, incrementa su contador.
      if (counter.contains(card.rank.order)) {
        counter(card.rank.order) += 1  // Si existe, sumamos 1
      } else {
        counter(card.rank.order) = 1   // Si no existe, añadimos con valor 1
      }
    }
    //obtenermos la carta que mas se repite
    val (maxRank, count) = counter.maxBy(_._2)
    //la sacamos para repetir el proceso
    counter.remove(maxRank)
    //con esta info podemos hacer las reviciones
    val (secondMax, secondCount) = counter.maxBy(_._2)

    //de aca en adelante ponemos las condiciones necesarias para las manos
    //noten que usando las herramientas que tenemos actualmente en el curos tenemos una cadena intermnia de if
    //pero cuando avancemos un poco mas podremos hacerlo de una manera mas elegante
    //si ven algo parecido en la tarea concideren que es lo mejor que pueden hacer con lo que tienen en ese momento
    //ya que probablemente tengan algo mejor que esto
    if (count == 2 && secondCount == 2) {
      f"Dos pares de $maxRank y $secondMax"
    } else if ((secondCount == 2 && count == 3) || ((secondCount == 3 && count == 2))) {
      f"Full house de $maxRank y $secondMax"
    } else if (count == 3) {
      f"La mano más alta es un trío de $maxRank"
    } else if (count == 2) {
      f"La mano más alta es un par de $maxRank"
    } else {
      //podriamos hacer un metodo para ordenar las cartas y botener la mas alta pero ya pierde el objetivo del ejercicio
      "La mano más alta es carta más alta"
    }
  }
}
