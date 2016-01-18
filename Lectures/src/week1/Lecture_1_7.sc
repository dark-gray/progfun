package week1

object Lecture_1_7 {
  println("Welcome to the lecture 1.7 worksheet") //> Welcome to the lecture 1.7 worksheet
	
	// Greatest common divisor.
	def gcd (a: Int, b: Int): Int =
		if (b == 0) a else gcd(b, a % b)  //> gcd: (a: Int, b: Int)Int
	
	gcd(14, 21)                               //> res0: Int = 7
	
//------------------------------------------------------------------------------
	
  def factorial(n: Int): Int = {

    def fact_iter(acc: Int, n: Int): Int = {
      if (n == 0) acc else fact_iter(acc * n, n - 1)
    }

    fact_iter(1, n)
  }                                               //> factorial: (n: Int)Int

  factorial(3)                                    //> res1: Int = 6
  factorial(5)                                    //> res2: Int = 120
  factorial(10)                                   //> res3: Int = 3628800

//------------------------------------------------------------------------------

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int

}