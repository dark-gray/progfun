package week4

object Lecture_4_7 {
  println("Welcome to the Scala lecture 4.7 worksheet")
                                                  //> Welcome to the Scala lecture 4.7 worksheet

	def isort(xs: scala.List[Int]): scala.List[Int] = xs match {
		case List() => List()
		case y :: ys => insert(y, isort(ys))
	}                                         //> isort: (xs: List[Int])List[Int]
	
	def insert(x: Int, xs: scala.List[Int]): scala.List[Int] = xs match {
		case List() => List(x)
		case y :: ys => if(x <= y) x :: xs else y :: insert(x, ys)
	}                                         //> insert: (x: Int, xs: List[Int])List[Int]
}