package week2

//import week1.Lecture_1_7.factorial              // при импорте почему-то не вычисляются выражения после  сохранении файла

object Lecture_2_1 {
  println("Welcome to the Scala lecture 2.1 worksheet")
                                                  //> Welcome to the Scala lecture 2.1 worksheet
  
  def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0
  else f(a) + sum(f, a + 1, b)                    //> sum: (f#241405: Int#1082 => Int#1082, a#241406: Int#1082, b#241407: Int#1082
                                                  //| )Int#1082
  
  
  // Дополнительные функции
  def sumInts(a: Int, b: Int)       = sum(x => x, a, b)
                                                  //> sumInts: (a#241656: Int#1082, b#241657: Int#1082)Int#1082
  def sumCubes(a: Int, b: Int)      = sum(x => x*x*x, a, b)
                                                  //> sumCubes: (a#241660: Int#1082, b#241661: Int#1082)Int#1082
  def sumFactorials(a: Int, b: Int) = sum(factorial, a, b)
                                                  //> sumFactorials: (a#241667: Int#1082, b#241668: Int#1082)Int#1082
  
  def id(x: Int): Int   = x                       //> id: (x#241672: Int#1082)Int#1082
  def cube(x: Int): Int = x * x * x               //> cube: (x#241673: Int#1082)Int#1082
 // def fact(x: Int): Int = if (x == 0) 1 else fact(x - 1)  //неверный код в слайде лекции
  def factorial(n: Int): Int = {                  // код из лекции 1.7
    def fact_iter(n: Int, acc: Int): Int = {
      if (n == 0) acc else fact_iter(n - 1, acc * n)
    }
    fact_iter(n, 1)
  }                                               //> factorial: (n#241669: Int#1082)Int#1082
  
  // Тесты.
  sumInts(1, 6)                                   //> res0: Int#1082 = 21
  sumCubes(1, 3)                                  //> res1: Int#1082 = 36
  sumFactorials(1, 4)                             //> res2: Int#1082 = 33

//-------------------------------------------------------------------------------------
  // Последнее упражнение в лекции.
  def sum2(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }                                               //> sum2: (f#241685: Int#1082 => Int#1082, a#241686: Int#1082, b#241687: Int#10
                                                  //| 82)Int#1082
  
  // Тесты.
  sum(x => x, 1, 7)                               //> res3: Int#1082 = 28
  sum(x => x*x, 3, 5)                             //> res4: Int#1082 = 50
}