package coursera

object FixedPoints {
	
  /**
   * Fixed point of a function: a number x is called a fixed point of a function f
   * if f(x) = x
   * 
   * x, f(x), f(f(x)), f(f(f(x)))...will be the same value x
   */
  def abs ( x: Double ) = if (x > 0) x else -x
  
  /*
   * Given a function and its initial guess, figure out the fixed point value
   */
  def fixedPoints( f: Double => Double)( guess : Double) : Double = {
    val tolerance = 0.00001
    
    def iterate( guess: Double): Double = {
      
      if(isGoodEnough( guess)) guess else iterate(f(guess))
    }
    
    def isGoodEnough( guess: Double) : Boolean = {
      ( abs(f(guess) - guess)/guess < tolerance)
    }
    
    iterate(guess)
  }
  
  /**
   * Plugin the fixed point function to comes up with sqrt function
   * since sqrt(x) = y such y*y = x therefore y => x/y (f(y) = sqrt(x) = y) 
   * therefore sqrt(x)  is fixed point for y=> x/y
   */
  
  /*
   * However, this does not converge
   */
   def sqrt ( x : Double) : Double = {
     fixedPoints ( y =>  x/y)(1.0)
   }  
   
   /*
    * But we can make it converge by averaging successive values
    */
   
    def sqrt1 ( x : Double) : Double = {
     fixedPoints ( y =>  (x/y + y )/2)(1.0)
   }  
    
    /**
     * Write a sqrt function by using fixed points and averageDamp
     */
    
    /*
     * averageDamp is taking a function and return a function
     */
    def averageDamp (f : Double => Double) ( x:Double) = (x + f(x)) /2
    
    def sqrt2( x : Double ) : Double = {
      fixedPoints ( averageDamp(y => x/y) )(1.0)
    }
}