package coursera

object Sum {
  /*
   * Take the sun of the integer between a and b
   */
	def sumInts1( a: Int, b: Int) : Int = if ( a > b) 0 else a + sumInts( a+1, b )
	
	/**
	 * Try to use higher order functions
	 */
	
	def sum( f: Int => Int, a:Int, b: Int) : Int = {
	  if ( a > b) 0 else f(a) + sum ( f, a + 1, b)
	}
	
	/*
	 * Sum Int
	 */
	def sumInts ( a : Int, b : Int)  = sum ( id, a, b)
	
	/*
	 * Sum cubes between a and b
	 */
	def sumCubes ( a: Int, b: Int ) = sum ( cube, a, b )
	
	
	def id ( x : Int ): Int = x
	def cube ( x : Int ) : Int = x * x * x 
	
	// or can be written as anonymous and passing into the functions
	
	def sumCubes2 ( a: Int, b: Int ) = sum ( x => x * x * x , a, b )
	
	/*
	 * exercise to sum up, function also can be passed in as a standalone parameter
	 */ 
	def sum1( f: Int => Int ) ( a: Int, b:Int) : Int = {
	  
	  def loop ( a: Int, acc:Int) : Int = {
	    
	    if( a > b ) acc
	    else loop( a + 1, acc + f(a))
	  }
	  loop ( a, 0)
	}
	
	/*
	 * Example for currying - function returning functions
	 */
	def sum2( f: Int => Int) : (Int, Int) => Int = {
	  def sumF(a : Int, b: Int) : Int = {
	    if ( a > b) 0
	    else f(a) + sumF(a+1, b)
	  }
	  sumF
	}
	
	// use: sum2(x => x) (1,2)
	
	/*
	 * sum2 can be also rewriten as
	 * it is multiple Parameter lists
	 * this way sum3(x => x*x) is a valid method, a and b can be applied later
	 * 
	 * Type of sum3
	 * (Int => Int) => (Int,Int) => Int
	 */
	def sum3( f : Int=> Int) ( a:Int, b:Int) : Int = 
	  if ( a >b) 0 else f(a) + sum3(f)(a+1,b)
	
	def sumInts2 = sum2( x => x)
	// use: sumInts2(1,2)
}