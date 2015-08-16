package week1

object Lecture_1_7 {
  println("Welcome to the lecture 1.7 worksheet") //> Welcome to the lecture 1.7 worksheet

  def factorial(n: Int): Int = {

    def fact_iter(n: Int, acc: Int): Int = {
      if (n == 0) acc else fact_iter(n - 1, acc * n)
    }

    fact_iter(n, 1)
  }                                               //> factorial: (n#230408: Int#1082)Int#1082

  factorial(3)                                    //> res0: Int#1082 = 6
  factorial(5)                                    //> res1: Int#1082 = 120
  factorial(10)                                   //> res2: Int#1082 = 3628800

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }                                               //> sum: (f#230659: Int#1082 => Int#1082, a#230660: Int#1082, b#230661: Int#1082
                                                  //| )Int#1082

}