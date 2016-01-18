package week1

object Lecture_1_6 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  1 + 2                                           //> res0: Int#1082(3) = 3
  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x#222405: Double#1598)Double#1598
  abs(-90)                                        //> res1: Double#1598 = 90.0
  abs(78)                                         //> res2: Double#1598 = 78.0

  def sqrt(x: Double) = {
      def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2
      
    sqrtIter(1.0)
  }                                               //> sqrt: (x#222407: Double#1598)Double#1598

  sqrt(2)                                         //> res3: Double#1598 = 1.4142156862745097
  sqrt(4)                                         //> res4: Double#1598 = 2.000609756097561
  sqrt(1e-6)                                      //> res5: Double#1598 = 0.0010000001533016628
  sqrt(1e60)                                      //> res6: Double#1598 = 1.0000788456669446E30
}