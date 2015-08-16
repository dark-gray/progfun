package week2

//import week1.Lecture_1_7.factorial              // при импорте почему-то не вычисляются выражения после  сохранении файла

object Lecture_2_1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(216); 
  println("Welcome to the Scala lecture 2.1 worksheet");$skip(97); 
  
  def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0
  else f(a) + sum(f, a + 1, b);System.out.println("""sum: (f#241405: Int#1082 => Int#1082, a#241406: Int#1082, b#241407: Int#1082)Int#1082""");$skip(90); 
  
  
  // Дополнительные функции
  def sumInts(a: Int, b: Int)       = sum(x => x, a, b);System.out.println("""sumInts: (a#241656: Int#1082, b#241657: Int#1082)Int#1082""");$skip(60); 
  def sumCubes(a: Int, b: Int)      = sum(x => x*x*x, a, b);System.out.println("""sumCubes: (a#241660: Int#1082, b#241661: Int#1082)Int#1082""");$skip(59); 
  def sumFactorials(a: Int, b: Int) = sum(factorial, a, b);System.out.println("""sumFactorials: (a#241667: Int#1082, b#241668: Int#1082)Int#1082""");$skip(31); 
  
  def id(x: Int): Int   = x;System.out.println("""id: (x#241672: Int#1082)Int#1082""");$skip(36); 
  def cube(x: Int): Int = x * x * x;System.out.println("""cube: (x#241673: Int#1082)Int#1082""");$skip(290); 
 // def fact(x: Int): Int = if (x == 0) 1 else fact(x - 1)  //неверный код в слайде лекции
  def factorial(n: Int): Int = {                  // код из лекции 1.7
    def fact_iter(n: Int, acc: Int): Int = {
      if (n == 0) acc else fact_iter(n - 1, acc * n)
    }
    fact_iter(n, 1)
  };System.out.println("""factorial: (n#241669: Int#1082)Int#1082""");$skip(31); val res$0 = 
  
  // Тесты.
  sumInts(1, 6);System.out.println("""res0: Int#1082 = """ + $show(res$0));$skip(17); val res$1 = 
  sumCubes(1, 3);System.out.println("""res1: Int#1082 = """ + $show(res$1));$skip(22); val res$2 = 
  sumFactorials(1, 4);System.out.println("""res2: Int#1082 = """ + $show(res$2));$skip(297); 

//-------------------------------------------------------------------------------------
  // Последнее упражнение в лекции.
  def sum2(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  };System.out.println("""sum2: (f#241685: Int#1082 => Int#1082, a#241686: Int#1082, b#241687: Int#1082)Int#1082""");$skip(35); val res$3 = 
  
  // Тесты.
  sum(x => x, 1, 7);System.out.println("""res3: Int#1082 = """ + $show(res$3));$skip(22); val res$4 = 
  sum(x => x*x, 3, 5);System.out.println("""res4: Int#1082 = """ + $show(res$4))}
}
