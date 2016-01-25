package week6

object Lecture_6_1 {
  println("Welcome to the Scala lecture 6.1 worksheet")
                                                  //> Welcome to the Scala lecture 6.1 worksheet
  
	def arr = Array(1, 2, 3)                  //> arr: => Array[Int]
	5 +: arr                                  //> res0: Array[Int] = Array(5, 1, 2, 3)
	arr :+ 5                                  //> res1: Array[Int] = Array(1, 2, 3, 5)
	
	def vec = Vector(1, 2, 3)                 //> vec: => scala.collection.immutable.Vector[Int]
	5 +: vec                                  //> res2: scala.collection.immutable.Vector[Int] = Vector(5, 1, 2, 3)
	vec :+ 5                                  //> res3: scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 5)
	
	
  val xs = Array(1, 2, 3, 44)                     //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (x => x * 2)                             //> res4: Array[Int] = Array(2, 4, 6, 88)
  
  val s = "Hello, World!"                         //> s  : String = Hello, World!
  s filter (c => c.isUpper)                       //> res5: String = HW
  s exists (c => c.isUpper)                       //> res6: Boolean = true
  s forall (c => c.isUpper)                       //> res7: Boolean = false
  
  val pairs = List(1, 2, 3) zip s                 //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  pairs.unzip                                     //> res8: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
  
  s flatMap (c => List('.', c))                   //> res9: String = .H.e.l.l.o.,. .W.o.r.l.d.!
  s map (c => List('.', c))                       //> res10: scala.collection.immutable.IndexedSeq[List[Char]] = Vector(List(., H)
                                                  //| , List(., e), List(., l), List(., l), List(., o), List(., ,), List(.,  ), Li
                                                  //| st(., W), List(., o), List(., r), List(., l), List(., d), List(., !))
  
  xs.sum                                          //> res11: Int = 50
  xs.product                                      //> res12: Int = 264
  xs.max                                          //> res13: Int = 44
  xs.min                                          //> res14: Int = 1
  
  ///---------------------------------------------------------------------------
  
  val r: Range = 1 until 5                        //> r  : Range = Range(1, 2, 3, 4)
  val t: Range = 1 to 5                           //> t  : Range = Range(1, 2, 3, 4, 5)
  
  1 to 10 by 3                                    //> res15: scala.collection.immutable.Range = Range(1, 4, 7, 10)
  6 to 1 by -2                                    //> res16: scala.collection.immutable.Range = Range(6, 4, 2)
  
  ///---------------------------------------------------------------------------
  // The scalar product of two vectors:
  
  def scalarProduct (xs: Vector[Double], ys: Vector[Double]): Double =
  	(xs zip ys).map(xy => xy._1 * xy._2).sum  //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double
  
  ///---------------------------------------------------------------------------
  def isPrime(n: Int): Boolean = (2 until n) forall (d => n%d != 0)
                                                  //> isPrime: (n: Int)Boolean
}