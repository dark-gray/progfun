package week2

object Lecture_2_3 {
  println("Welcome to the Scala lecture 2.3 worksheet")
                                                  //> Welcome to the Scala lecture 2.3 worksheet

  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x#481676: Double#1598)Double#1598

  val tolerance = 0.0001                          //> tolerance  : Double#1598 = 1.0E-4

  def isCloseEnough(x: Double, y: Double) = abs((x - y) / x) / x < tolerance
                                                  //> isCloseEnough: (x#481678: Double#1598, y#481679: Double#1598)Boolean#2504

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      println("guess = " + guess)
      val next = f(guess)
      if (isCloseEnough(guess, next)) next else iterate(next)
    }

    iterate(firstGuess)
  }                                               //> fixedPoint: (f#481684: Double#1598 => Double#1598)(firstGuess#481685: Double
                                                  //| #1598)Double#1598

  fixedPoint(x => 1 + x / 2)(1)                   //> guess = 1.0
                                                  //| guess = 1.5
                                                  //| guess = 1.75
                                                  //| guess = 1.875
                                                  //| guess = 1.9375
                                                  //| guess = 1.96875
                                                  //| guess = 1.984375
                                                  //| guess = 1.9921875
                                                  //| guess = 1.99609375
                                                  //| guess = 1.998046875
                                                  //| guess = 1.9990234375
                                                  //| guess = 1.99951171875
                                                  //| res0: Double#1598 = 1.999755859375
  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1)
                                                  //> sqrt: (x#481938: Double#1598)Double#1598

	// Test
  sqrt(2)                                         //> guess = 1.0
                                                  //| guess = 1.5
                                                  //| guess = 1.4166666666666665
                                                  //| guess = 1.4142156862745097
                                                  //| res1: Double#1598 = 1.4142135623746899

   //-------------------------------------------------------------------------------------
  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
                                                  //> averageDamp: (f#481944: Double#1598 => Double#1598)(x#481945: Double#1598)Do
                                                  //| uble#1598
  
  def sqrt2(x: Double) = fixedPoint(averageDamp(y =>  x / y))(1)
                                                  //> sqrt2: (x#481949: Double#1598)Double#1598
  
  sqrt2(2)                                        //> guess = 1.0
                                                  //| guess = 1.5
                                                  //| guess = 1.4166666666666665
                                                  //| guess = 1.4142156862745097
                                                  //| res2: Double#1598 = 1.4142135623746899
  
}