package rangos

/**
 * La clase `As` representa el rango de la carta dos en un juego de cartas.
 *
 * Esta clase hereda de `Rangos` y define el valor y el orden del rango de la carta dos.
 */
class As extends Rangos{
  /**
   * El valor de la carta "As"
   */
  val value: Int = 11
  /**
   * El orden de la carta "As", que define su posición en el rango.
   * Este valor se utiliza en operaciones de comparación y ordenación de cartas.
   */
  val order: Int = 1
}
