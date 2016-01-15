package week4

object Lecture_4_6 {
  println("Welcome to the Scala lecture 4.6 worksheet")
                                                  //> Welcome to the Scala lecture 4.6 worksheet
                                                  
	trait Expr
  case class Number (n: Int) extends Expr
  case class Sum (e1: Expr, e2: Expr) extends Expr
  
  def eval (e: Expr): Int = e match {
  	case Number (n: Int) => n
  	case Sum (e1: Expr, e2: Expr) => eval(e1) + eval(e2)
  }                                               //> eval: (e: week4.Lecture_4_6.Expr)Int
  
  def show (e: Expr): String = e match {
  	case Number (x) => x.toString
  	case Sum (l, r) => show(l) + " + " + show(r)
  }                                               //> show: (e: week4.Lecture_4_6.Expr)String
  
  show(Sum(Number(1), Number(44)))                //> res0: String = 1 + 44
}