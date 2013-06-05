object functions {

	def product1 ( f : Int => Int) ( a:Int, b:Int) :Int = {
		if ( a >b) 1
		else f(a) * product1 (f)(a+1,b)
	}                                         //> product1: (f: Int => Int)(a: Int, b: Int)Int
	product1(x => x*x) ( 3,4)                 //> res0: Int = 144
	
	// use product generate factorial
	def factorial( n:Int ) = product1 ( x=>x)(1,n)
                                                  //> factorial: (n: Int)Int
	factorial (5)                             //> res1: Int = 120
  
  // more generic method to do sum and product
   def mapReduce ( f: Int =>Int, combine: (Int, Int) => Int, zero:Int)(a:Int, b:Int):Int = {
   		 if( a>b) return zero
   		 else combine( f(a), mapReduce(f, combine, zero)( a+1, b))
   }                                              //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
   
   def sum( x:Int, y:Int) = x+y                   //> sum: (x: Int, y: Int)Int
   def product (x:Int, y:Int) = x* y              //> product: (x: Int, y: Int)Int
   
   mapReduce ( x=>x, (x,y)=> x+y, 0)(1,3)         //> res2: Int = 6
   mapReduce ( x=>x, (x,y)=>x*y, 1)(2,4)          //> res3: Int = 24
   
   // then product function can be write as mapReduce
   def product2( f:Int =>Int)(a:Int, b:Int) :Int = mapReduce(f, (x,y) => x*y, 1)(a,b)
                                                  //> product2: (f: Int => Int)(a: Int, b: Int)Int
                                                  
}