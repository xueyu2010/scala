package coursera

object Sqrt {
  /**
   * Algorithm :
   * 1) start with initial guess, for example 1.0
   * 2) then improve it by doing guess = mean of guess/input and guess
   */

  /**
   * Test:
   * 0.001
   * 0.1e-20
   * 1.0e20
   * 1.0e50
   *
   * how to improve isGoodEnough to handle both small and large numbers
   */
  def abs(x: Double) = if (x < 0) -x else x //> abs: (x: Double)Double

  // put all the function inside of sqrt so that the name of the function
  // would not be polluted.
  def sqrt(x: Double): Double = {

    def isGoodEnough(guess: Double, input: Double): Boolean = {
      abs(guess * guess - input) / input < 0.0001
    }

    // improves the guess by taking the mean of guess and input / guess
    def improve(guess: Double, input: Double): Double = (guess + input / guess) / 2

    // main recursive function for compute the squre root
    def sqrtItr(guess: Double, input: Double): Double = {
      if (isGoodEnough(guess, input)) guess
      else sqrtItr(improve(guess, input), input)
    }
    sqrtItr(1.0, x)
  }
}