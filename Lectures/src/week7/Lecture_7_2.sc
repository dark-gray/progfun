package week7

object Lecture_7_2 {
  println("Welcome to the Scala lecture 7.2 worksheet")
                                                  //> Welcome to the Scala lecture 7.2 worksheet
  
  val xs = Stream.cons(1, Stream.cons(2, Stream.empty))
                                                  //> xs  : Stream.Cons[Int] = Stream(1, ?)
  Stream(1, 2, 3)                                 //> res0: scala.collection.immutable.Stream[Int] = Stream(1, ?)
	(1 to 1000).toStream                      //> res1: scala.collection.immutable.Stream[Int] = Stream(1, ?)
	
	5 #:: xs                                  //> res2: scala.collection.immutable.Stream[Int] = Stream(5, ?)
	
	def streamRange(lo: Int, hi: Int): Stream[Int] =
		if (lo >= hi) Stream.empty
		else Stream.cons(lo, streamRange(lo + 1, hi))
                                                  //> streamRange: (lo: Int, hi: Int)Stream[Int]
		
	def listRange(lo: Int, hi: Int): List[Int] =
		if (lo >= hi) Nil
		else lo :: listRange(lo + 1, hi)  //> listRange: (lo: Int, hi: Int)List[Int]
	
	
	def streamRange2(lo: Int, hi: Int): Stream[Int] = {
		println(lo+" ")
		if (lo >= hi) Stream.empty
		else Stream.cons(lo, streamRange(lo + 1, hi))
  }                                               //> streamRange2: (lo: Int, hi: Int)Stream[Int]
  
	streamRange2(1, 10).take(3).toList        //> 1 
                                                  //| res3: List[Int] = List(1, 2, 3)
}