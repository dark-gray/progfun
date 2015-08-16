package week2

object Lecture_2_3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(92); 
  println("Welcome to the Scala lecture 2.3 worksheet");$skip(46); 

  def abs(x: Double) = if (x < 0) -x else x;System.out.println("""abs: (x#481676: Double#1598)Double#1598""");$skip(27); 

  val tolerance = 0.0001;System.out.println("""tolerance  : Double#1598 = """ + $show(tolerance ));$skip(79); 

  def isCloseEnough(x: Double, y: Double) = abs((x - y) / x) / x < tolerance;System.out.println("""isCloseEnough: (x#481678: Double#1598, y#481679: Double#1598)Boolean#2504""");$skip(265); 

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      println("guess = " + guess)
      val next = f(guess)
      if (isCloseEnough(guess, next)) next else iterate(next)
    }

    iterate(firstGuess)
  };System.out.println("""fixedPoint: (f#481684: Double#1598 => Double#1598)(firstGuess#481685: Double#1598)Double#1598""");$skip(34); val res$0 = 

  fixedPoint(x => 1 + x / 2)(1);System.out.println("""res0: Double#1598 = """ + $show(res$0));$skip(60); 
  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1);System.out.println("""sqrt: (x#481938: Double#1598)Double#1598""");$skip(21); val res$1 = 

	// Test
  sqrt(2);System.out.println("""res1: Double#1598 = """ + $show(res$1));$skip(160); 

   //-------------------------------------------------------------------------------------
  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2;System.out.println("""averageDamp: (f#481944: Double#1598 => Double#1598)(x#481945: Double#1598)Double#1598""");$skip(68); 
  
  def sqrt2(x: Double) = fixedPoint(averageDamp(y =>  x / y))(1);System.out.println("""sqrt2: (x#481949: Double#1598)Double#1598""");$skip(14); val res$2 = 
  
  sqrt2(2);System.out.println("""res2: Double#1598 = """ + $show(res$2))}
  
}
