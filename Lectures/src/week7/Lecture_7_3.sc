package week7

object Lecture_7_3 {
  println("Welcome to the Scala lecture 7.3 worksheet")
                                                  //> Welcome to the Scala lecture 7.3 worksheet
  
  def expr = {
  	val x = {print("x"); 1}
  	lazy val y = {print("y"); 2}
  	def z = {print("z"); 3}
  	z + y + x + z + y + x
  }                                               //> expr: => Int
  expr                                            //> xzyzres0: Int = 12
}