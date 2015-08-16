package week2

object Lecture_2_2 {
  println("Welcome to the Scala lecture 2.2 worksheet")
                                                  //> Welcome to the Scala lecture 2.2 worksheet

  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }                                               //> sum: (f#396935: Int#1082 => Int#1082)(Int#1082, Int#1082) => Int#1082

  def id(x: Int): Int = x                         //> id: (x#397190: Int#1082)Int#1082
  def cube(x: Int): Int = x * x * x               //> cube: (x#397191: Int#1082)Int#1082

  sum(id)(1, 7)                                   //> res0: Int#1082 = 28

  //-------------------------------------------------------------------------------------
  def sum2(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum(f)(a + 1, b)
  }                                               //> sum2: (f#397199: Int#1082 => Int#1082)(a#397200: Int#1082, b#397201: Int#108
                                                  //| 2)Int#1082

  sum2(id)(1, 7)                                  //> res1: Int#1082 = 28

  //-------------------------------------------------------------------------------------
  //Exercise 1
	def product(f: Int => Int)(a: Int, b: Int): Int = {
	if (a > b) 1
	else f(a) * product(f)(a + 1, b)
	}                                         //> product: (f#397210: Int#1082 => Int#1082)(a#397211: Int#1082, b#397212: Int#
                                                  //| 1082)Int#1082
	// Test
	product(x => x*x)(1, 4)                   //> res2: Int#1082 = 576
	
  //-------------------------------------------------------------------------------------
  //Exercise 2
  def fact(n: Int) = product(x => x)(1, n)        //> fact: (n#397223: Int#1082)Int#1082
  
  //Test
  fact(5)                                         //> res3: Int#1082 = 120

  //-------------------------------------------------------------------------------------
  //Exercise 3
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }                                               //> mapReduce: (f#397226: Int#1082 => Int#1082, combine#397227: (Int#1082, Int#
                                                  //| 1082) => Int#1082, zero#397228: Int#1082)(a#397229: Int#1082, b#397230: Int
                                                  //| #1082)Int#1082
  
  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> product2: (f#397237: Int#1082 => Int#1082)(a#397238: Int#1082, b#397239: In
                                                  //| t#1082)Int#1082
                                                  
  def fact2(n: Int) = product2(x => x)(1, n)      //> fact2: (n#397245: Int#1082)Int#1082
  
  //Test
	product2(x => x*x)(1, 4)                  //> res4: Int#1082 = 576
  fact2(5)                                        //> res5: Int#1082 = 120
}