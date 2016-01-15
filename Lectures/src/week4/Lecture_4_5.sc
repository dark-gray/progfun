package week4

object Lecture_4_5 {
  println("Welcome to the Scala lecture 4.5 worksheet")
                                                  //> Welcome to the Scala lecture 4.5 worksheet

  trait Expr {
  	def isNumber: Boolean
  	def isSum: Boolean
  	def numValue: Int
  	def leftOp: Expr
  	def rightOp: Expr
  	
		def eval: Int
  }
  
  class Number (n: Int) extends Expr {
  	def isNumber: Boolean = true
  	def isSum: Boolean = false
  	def numValue: Int = n
  	def leftOp: Expr = throw new Error("Number has no leftOp")
  	def rightOp: Expr = throw new Error("Number has no rightOp")
  	
  	def eval: Int = n
  }
  
  class Sum (e1: Expr, e2: Expr) extends Expr {
  	def isNumber: Boolean = false
  	def isSum: Boolean = true
  	def numValue: Int = throw new Error("Sum has no numValue")
  	def leftOp: Expr = e1
  	def rightOp: Expr = e2
  	
  	def eval: Int = e1.eval + e2.eval
  }
  
	/**
  class Prod (e1: Expr, e2: Expr) extends Expr {    // e1 * e2
  	
  }
  
  class Var (x: String) extends Expr {              // Variable 'x'
  	
  }
	*/
	
	/** Eval, ver 1
  def eval (e: Expr): Int = {
  	if (e.isNumber) e.numValue
  	else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
  	else throw new Error("Unknown expression " + e)
  }
  */
  
	/** Eval, ver 2
  def eval (e: Expr): Int = {
  	if (e.isInstanceOf[Number]) e.asInstanceOf[Number].numValue
  	else if (e.isInstanceOf[Sum]) eval(e.asInstanceOf[Sum].leftOp) + eval(e.asInstanceOf[Sum].rightOp)
  	else throw new Error("Unknown expression " + e)
  }
*/
}