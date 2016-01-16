package week6

object Lecture_6_1 {
  println("Welcome to the Scala lecture 6.1 worksheet")
                                                  //> Welcome to the Scala lecture 6.1 worksheet
  
  val xs = Array(1, 2, 3, 44)                     //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(2, 4, 6, 88)
  
  val s = "Hello, World!"                         //> s  : String = Hello, World!
  s filter (c => c.isUpper)                       //> res1: String = HW
  s exists (c => c.isUpper)                       //> res2: Boolean = true
  s forall (c => c.isUpper)                       //> res3: Boolean = false
  
  val pairs = List(1, 2, 3) zip s                 //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  pairs.unzip                                     //> res4: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
  
  s flatMap (c => List('.', c))                   //> res5: String = .H.e.l.l.o.,. .W.o.r.l.d.!
  
  xs.sum                                          //> res6: Int = 50
  xs.product                                      //> res7: Int = 264
  xs.max                                          //> res8: Int = 44
  xs.min                                          //> res9: Int = 1
  
  ///---------------------------------------------------------------------------
  
  val r: Range = 1 until 5                        //> r  : Range = Range(1, 2, 3, 4)
  val t: Range = 1 to 5                           //> t  : Range = Range(1, 2, 3, 4, 5)
  
  1 to 10 by 3                                    //> res10: scala.collection.immutable.Range = Range(1, 4, 7, 10)
  6 to 1 by -2                                    //> res11: scala.collection.immutable.Range = Range(6, 4, 2)
  
  ///---------------------------------------------------------------------------
  // The scalar product of two vectors:
  
  def scalarProduct (xs: Vector[Double], ys: Vector[Double]): Double =
  	(xs zip ys).map(xy => xy._1 * xy._2).sum  //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double
  
  ///---------------------------------------------------------------------------
  def isPrime(n: Int): Boolean = (2 until n) forall (d => n%d != 0)
                                                  //> isPrime: (n: Int)Boolean
}