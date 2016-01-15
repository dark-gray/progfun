package week5

object Lecture_5_1 {
  println("Welcome to the Scala lecture 5.1 worksheet")
                                                  //> Welcome to the Scala lecture 5.1 worksheet

  def last[T](xs: List[T]): T = xs match {
    case List()  => throw new Error("lats of empty list")
    case List(x) => x
    case y :: ys => last(ys)
  }                                               //> last: [T](xs: List[T])T

  def init[T](xs: List[T]): List[T] = xs match {
    case List()  => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }                                               //> init: [T](xs: List[T])List[T]
  
  init(List(1,2,3))                               //> res0: List[Int] = List(1, 2)
  
  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List()  => ys
    case z :: zs => z :: concat(zs, ys)
  }                                               //> concat: [T](xs: List[T], ys: List[T])List[T]
  
  def reverse[T](xs: List[T]): List[T] = xs match {
    case List()  => xs
    case y :: ys => reverse(ys) ++ List(y)
  }                                               //> reverse: [T](xs: List[T])List[T]
  
  def removeAt[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n + 1)
                                                  //> removeAt: [T](n: Int, xs: List[T])List[T]
  
  removeAt(1, List('a', 'b', 'c', 'd'))           //> res1: List[Char] = List(a, c, d)
}