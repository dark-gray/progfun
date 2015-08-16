package week2

object Lecture_2_2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(92); 
  println("Welcome to the Scala lecture 2.2 worksheet");$skip(151); 

  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  };System.out.println("""sum: (f#396935: Int#1082 => Int#1082)(Int#1082, Int#1082) => Int#1082""");$skip(28); 

  def id(x: Int): Int = x;System.out.println("""id: (x#397190: Int#1082)Int#1082""");$skip(36); 
  def cube(x: Int): Int = x * x * x;System.out.println("""cube: (x#397191: Int#1082)Int#1082""");$skip(18); val res$0 = 

  sum(id)(1, 7);System.out.println("""res0: Int#1082 = """ + $show(res$0));$skip(197); 

  //-------------------------------------------------------------------------------------
  def sum2(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum(f)(a + 1, b)
  };System.out.println("""sum2: (f#397199: Int#1082 => Int#1082)(a#397200: Int#1082, b#397201: Int#1082)Int#1082""");$skip(19); val res$1 = 

  sum2(id)(1, 7);System.out.println("""res1: Int#1082 = """ + $show(res$1));$skip(211); 

  //-------------------------------------------------------------------------------------
  //Exercise 1
	def product(f: Int => Int)(a: Int, b: Int): Int = {
	if (a > b) 1
	else f(a) * product(f)(a + 1, b)
	};System.out.println("""product: (f#397210: Int#1082 => Int#1082)(a#397211: Int#1082, b#397212: Int#1082)Int#1082""");$skip(34); val res$2 = 
	// Test
	product(x => x*x)(1, 4);System.out.println("""res2: Int#1082 = """ + $show(res$2));$skip(151); 
	
  //-------------------------------------------------------------------------------------
  //Exercise 2
  def fact(n: Int) = product(x => x)(1, n);System.out.println("""fact: (n#397223: Int#1082)Int#1082""");$skip(22); val res$3 = 
  
  //Test
  fact(5);System.out.println("""res3: Int#1082 = """ + $show(res$3));$skip(288); 

  //-------------------------------------------------------------------------------------
  //Exercise 3
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  };System.out.println("""mapReduce: (f#397226: Int#1082 => Int#1082, combine#397227: (Int#1082, Int#1082) => Int#1082, zero#397228: Int#1082)(a#397229: Int#1082, b#397230: Int#1082)Int#1082""");$skip(95); 
  
  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b);System.out.println("""product2: (f#397237: Int#1082 => Int#1082)(a#397238: Int#1082, b#397239: Int#1082)Int#1082""");$skip(97); 
                                                  
  def fact2(n: Int) = product2(x => x)(1, n);System.out.println("""fact2: (n#397245: Int#1082)Int#1082""");$skip(38); val res$4 = 
  
  //Test
	product2(x => x*x)(1, 4);System.out.println("""res4: Int#1082 = """ + $show(res$4));$skip(11); val res$5 = 
  fact2(5);System.out.println("""res5: Int#1082 = """ + $show(res$5))}
}
