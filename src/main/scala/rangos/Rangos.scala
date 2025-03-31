package rangos

/**
 * El trait `Rangos` define la estructura básica para los rangos de las cartas.
 *
 * Cualquier clase que extienda este trait debe proporcionar un valor (`value`) y un orden (`order`)
 * para representar el rango de una carta en un juego de cartas.
 */
trait Rangos {
  /**
   * El valor numérico del rango de la carta.
   */
  val value:Int
  /**
   * El orden del rango de la carta, que define su posición relativa
   * en comparación con otros rangos en el juego.
   */
  val order:Int
}
