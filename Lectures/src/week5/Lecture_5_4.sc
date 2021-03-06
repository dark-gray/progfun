package week5

object Lecture_5_4 {
  println("Welcome to the Scala lecture 5.4 worksheet")
                                                  //> Welcome to the Scala lecture 5.4 worksheet

  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil     => Nil
    case y :: ys => (y * y) :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]

  def squareList2(xs: List[Int]): List[Int] =
    xs map (x => x * x)                           //> squareList2: (xs: List[Int])List[Int]

  squareList(List(1, 2, 3))                       //> res0: List[Int] = List(1, 4, 9)
  squareList2(List(1, 2, 3))                      //> res1: List[Int] = List(1, 4, 9)

  ///---------------------------------------------------------------------------

  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)

  nums filter (x => x > 0)                        //> res2: List[Int] = List(2, 5, 7, 1)
  nums filterNot (x => x > 0)                     //> res3: List[Int] = List(-4)
  nums partition (x => x > 0)                     //> res4: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))
  nums takeWhile (x => x > 0)                     //> res5: List[Int] = List(2)
  nums dropWhile (x => x > 0)                     //> res6: List[Int] = List(-4, 5, 7, 1)
  nums span (x => x > 0)                          //> res7: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))

  ///---------------------------------------------------------------------------
  // Моя версия.
  def pack1[T](xs: List[T]): List[List[T]] = xs match {
    case Nil     => Nil
    case y :: ys => (List(y) ::: (ys takeWhile (x => x == y))) :: pack(ys dropWhile (x => x == y))
  }                                               //> pack1: [T](xs: List[T])List[List[T]]

  // Версия из лекции.
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]

  val data = List("a", "a", "a", "b", "c", "c", "a")
                                                  //> data  : List[String] = List(a, a, a, b, c, c, a)
  pack1(data)                                     //> res8: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a)
                                                  //| )
  pack (data)                                     //> res9: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a)
                                                  //| )
  
  ///---------------------------------------------------------------------------
	
	def encode[T](xs: List[T]): List[(T, Int)] =
		pack(xs) map (ys => (ys.head, ys.length))
                                                  //> encode: [T](xs: List[T])List[(T, Int)]
	
	encode(data)                              //> res10: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
}