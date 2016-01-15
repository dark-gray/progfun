package week5

object Lecture_5_5 {
  println("Welcome to the Scala lecture 5.5 worksheet")
                                                  //> Welcome to the Scala lecture 5.5 worksheet

  def sum (xs:List[Int]) = (0::xs) reduceLeft ((x,y) => x + y)
                                                  //> sum: (xs: List[Int])Int
  def product (xs:List[Int]) = (1::xs) reduceLeft ((x,y) => x * y)
                                                  //> product: (xs: List[Int])Int
  def sum2 (xs:List[Int]) = (xs foldLeft 0) (_ + _)
                                                  //> sum2: (xs: List[Int])Int
  def product2 (xs:List[Int]) = (xs foldLeft 1) (_ * _)
                                                  //> product2: (xs: List[Int])Int
  
  val nums = List(1, 2, 3, 4)                     //> nums  : List[Int] = List(1, 2, 3, 4)
  sum (nums)                                      //> res0: Int = 10
  sum2(nums)                                      //> res1: Int = 10
  product (nums)                                  //> res2: Int = 24
  product2(nums)                                  //> res3: Int = 24
  
  ///---------------------------------------------------------------------------
  def concat[T](xs: List[T], ys: List[T]): List[T] =
    (xs foldRight ys)(_ :: _)                     //> concat: [T](xs: List[T], ys: List[T])List[T]
	
	concat(List(1, 2, 3), List(4, 5, 6))      //> res4: List[Int] = List(1, 2, 3, 4, 5, 6)
	
  //def concat2[T](xs: List[T], ys: List[T]): List[T] =
  //  (xs foldLeft ys)(_ :: _)
	
  ///---------------------------------------------------------------------------
	def mapFun[T, U](xs: List[T], f: T => U): List[U] =
		(xs foldRight List[U]()) (f(_) :: _)
                                                  //> mapFun: [T, U](xs: List[T], f: T => U)List[U]
  mapFun[Int,Int](nums, _ * 4 )                   //> res5: List[Int] = List(4, 8, 12, 16)
    
	def lengthFun[T](xs: List[T]): Int =
		(xs foldRight 0) ((x,y) => 1 + y) //> lengthFun: [T](xs: List[T])Int
	
	lengthFun(List(89, 4, 32))                //> res6: Int = 3
}