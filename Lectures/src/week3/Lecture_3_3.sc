package week3

import week3._

object Lecture_3_3 {
  println("Welcome to the Scala lecture 3.3 worksheet")
                                                  //> Welcome to the Scala lecture 3.3 worksheet
  
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
                                                  //> singleton: [T](elem: T)week3.Cons[T]

	singleton[Int](1)                         //> res0: week3.Cons[Int] = week3.Cons@643faf
	singleton[Boolean](true)                  //> res1: week3.Cons[Boolean] = week3.Cons@8dacdf

	singleton(1)                              //> res2: week3.Cons[Int] = week3.Cons@79be86
	singleton(true)                           //> res3: week3.Cons[Boolean] = week3.Cons@ce8af7
	
	/// Моя реализация.
	def nth[T](n: Int, lst: List[T]): T = {
		def loop (count: Int, lst: List[T]): T = {
			if (lst.isEmpty) throw new IndexOutOfBoundsException ("Out of bounds.")
			else if (count == n) lst.head
			else loop(count + 1, lst.tail)
		}
		loop(0, lst)
	}                                         //> nth: [T](n: Int, lst: week3.List[T])T

	/// Реализация из видеолекции.
	def nth2[T](n: Int, xs: List[T]): T =
		if (xs.isEmpty) throw new IndexOutOfBoundsException
		else if(n == 0) xs.head
		else nth2(n - 1, xs.tail)         //> nth2: [T](n: Int, xs: week3.List[T])T
		
	val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : week3.Cons[Int] = week3.Cons@1684286

	nth(2, list)                              //> res4: Int = 3
	nth2(2, list)                             //> res5: Int = 3
	//nth(-1, list)
	nth2(4, list)                             //> java.lang.IndexOutOfBoundsException
                                                  //| 	at week3.Lecture_3_3$$anonfun$main$1.nth2$1(week3.Lecture_3_3.scala:28)
                                                  //| 
                                                  //| 	at week3.Lecture_3_3$$anonfun$main$1.apply$mcV$sp(week3.Lecture_3_3.scal
                                                  //| a:37)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week3.Lecture_3_3$.main(week3.Lecture_3_3.scala:5)
                                                  //| 	at week3.Lecture_3_3.main(week3.Lecture_3_3.scala)
	nth2(-1, list)
}