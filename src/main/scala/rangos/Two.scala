package rangos

/**
 * La clase `Two` representa el rango de la carta dos en un juego de cartas.
 *
 * Esta clase hereda de `Rangos` y define el valor y el orden del rango de la carta dos.
 */
class Two extends Rangos{
  /**
   * El valor de la carta "Dos"
   */
  val value: Int = 2
  /**
   * El orden de la carta "Dos", que define su posición en el rango.
   * Este valor se utiliza en operaciones de comparación y ordenación de cartas.
   */
  val order: Int = 2
}
