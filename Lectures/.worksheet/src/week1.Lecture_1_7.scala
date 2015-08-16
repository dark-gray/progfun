package week1

object Lecture_1_7 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(86); 
  println("Welcome to the lecture 1.7 worksheet");$skip(167); 

  def factorial(n: Int): Int = {

    def fact_iter(n: Int, acc: Int): Int = {
      if (n == 0) acc else fact_iter(n - 1, acc * n)
    }

    fact_iter(n, 1)
  };System.out.println("""factorial: (n#417661: Int#1082)Int#1082""");$skip(17); val res$0 = 

  factorial(3);System.out.println("""res0: Int#1082 = """ + $show(res$0));$skip(15); val res$1 = 
  factorial(5);System.out.println("""res1: Int#1082 = """ + $show(res$1));$skip(16); val res$2 = 
  factorial(10);System.out.println("""res2: Int#1082 = """ + $show(res$2));$skip(173); 

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  };System.out.println("""sum: (f#417912: Int#1082 => Int#1082, a#417913: Int#1082, b#417914: Int#1082)Int#1082""")}

}
