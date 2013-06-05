import coursera.Sqrt
import coursera.Sum

object WorkingSet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val x = 1                                       //> x  : Int = 1
  def increase(i: Int) = i + 1                    //> increase: (i: Int)Int
  increase(x)                                     //> res0: Int = 2

  Sqrt.sqrt(0.001)                                //> res1: Double = 0.03162278245070105
  Sqrt.sqrt(0.1e-20)                              //> res2: Double = 3.1622778383672726E-11
  Sqrt.sqrt(1.0e60)                               //> res3: Double = 1.0000000031080746E30

	Sum.sumInts( 2,4)                         //> res4: Int = 9
	Sum.sum2(x => x)(1,2)                     //> res5: Int = 3
	Sum.sumInts2( 1,2)                        //> res6: Int = 3
	
}