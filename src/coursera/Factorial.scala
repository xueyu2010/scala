package coursera

object Factorial {
  /**
   * Non tail recursive factorial functions
   */
  
  def factorial1( n : Int) : Int = 
    if ( n ==1 ) n else n * factorial1( n - 1)
  
  /**
   * Write a tail recursive function for factorial
   */
	def factorial ( n: Int ) : Int = {
	  def loop ( acc: Int, n : Int) : Int = 
	    if ( n == 0 ) acc
	    else loop ( acc * n , n - 1)
	    
	   loop( 1, n) 
	}
	
}