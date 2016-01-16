package week6

object Lecture_6_2 {
  println("Welcome to the Scala lecture 6.2 worksheet")
                                                  //> Welcome to the Scala lecture 6.2 worksheet
  def isPrime(n: Int): Boolean = (2 until n) forall (d => n%d != 0)
                                                  //> isPrime: (n: Int)Boolean
  
  val n = 7                                       //> n  : Int = 7
  
  //(1 until n) map (i => (1 until i) map (j => (i , j)))
  (1 until n) flatMap (i =>
  	(1 until i) map (j => (i , j))) filter (pair =>
  		isPrime(pair._1 + pair._2))       //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
  
  for {
  	i <- 1 until n
  	j <- 1 until i
  	if isPrime (i + j)
  } yield (i, j)                                  //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
                                                  
  ///---------------------------------------------------------------------------
  // The scalar product of two vectors:
  
  def scalarProduct (xs: Vector[Double], ys: Vector[Double]): Double =
  	//(xs zip ys).map(xy => xy._1 * xy._2).sum
		(for ((x, y) <- xs zip ys) yield x * y).sum
                                                  //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double
}