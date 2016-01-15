package week5

import math.Ordering

object Lecture_5_3 {
  println("Welcome to the Scala lecture 5.3 worksheet")
                                                  //> Welcome to the Scala lecture 5.3 worksheet
  /// Ver 1
  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))
    }
  }                                               //> msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]

  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
  msort(nums)((x: Int, y: Int) => x < y)          //> res0: List[Int] = List(-4, 1, 2, 5, 7)
  msort(fruits)((x: String, y: String) => x.compareTo(y) < 0)
                                                  //> res1: List[String] = List(apple, banana, orange, pineapple)

  ///---------------------------------------------------------------------------
  /// Ver 2
  def msort2[T](xs: List[T])(ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs splitAt n
      merge(msort2(fst)(ord), msort2(snd)(ord))
    }
  }                                               //> msort2: [T](xs: List[T])(ord: scala.math.Ordering[T])List[T]

  msort2(nums)(Ordering.Int)                      //> res2: List[Int] = List(-4, 1, 2, 5, 7)
  msort2(fruits)(Ordering.String)                 //> res3: List[String] = List(apple, banana, orange, pineapple)

  ///---------------------------------------------------------------------------
  /// Ver 3
  def msort3[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs splitAt n
      merge(msort3(fst), msort3(snd))
    }
  }                                               //> msort3: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]
  
  msort3(nums)                                    //> res4: List[Int] = List(-4, 1, 2, 5, 7)
  msort3(fruits)                                  //> res5: List[String] = List(apple, banana, orange, pineapple)
}