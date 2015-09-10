package week2

object Lecture_2_5 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(96); 
  println("Welcome to the Scala lecture 2.5-2.6 worksheet");$skip(385); 
                                                 
  //--------------------------------------------------------------------------------
  // Functions for rational numbers.
  //--------------------------------------------------------------------------------
  def addRational(r: Rational, s: Rational): Rational = new Rational(r.numer * s.denom + s.numer * r.denom, r.denom * s.denom);System.out.println("""addRational: (r: week2.Rational, s: week2.Rational)week2.Rational""");$skip(56); 
  def makeString(r: Rational) = r.numer + "/" + r.denom;System.out.println("""makeString: (r: week2.Rational)String""");$skip(302); val res$0 = 
                                                  
  //--------------------------------------------------------------------------------
  // Tests for functions.
  //--------------------------------------------------------------------------------
  addRational(new Rational(1, 2), new Rational(2, 3));System.out.println("""res0: week2.Rational = """ + $show(res$0));$skip(66); val res$1 = 
  makeString(addRational(new Rational(1, 2), new Rational(2, 3)));System.out.println("""res1: String = """ + $show(res$1));$skip(227); 

  //--------------------------------------------------------------------------------
  // Rational class tests.
  //--------------------------------------------------------------------------------
  val x = new Rational(1, 3);System.out.println("""x  : week2.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : week2.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : week2.Rational = """ + $show(z ));$skip(14); val res$2 = 
  
  x.numer;System.out.println("""res2: Int = """ + $show(res$2));$skip(10); val res$3 = 
  x.denom;System.out.println("""res3: Int = """ + $show(res$3));$skip(13); val res$4 = 

  x.add(y);System.out.println("""res4: week2.Rational = """ + $show(res$4));$skip(15); val res$5 = 
  
  x.sub(z);System.out.println("""res5: week2.Rational = """ + $show(res$5));$skip(8); val res$6 = 
  x.neg;System.out.println("""res6: week2.Rational = """ + $show(res$6));$skip(22); val res$7 = 
  
  x.sub(y).sub(z);System.out.println("""res7: week2.Rational = """ + $show(res$7));$skip(12); val res$8 = 
  x - y - z;System.out.println("""res8: week2.Rational = """ + $show(res$8));$skip(15); val res$9 = 
  
  y.add(y);System.out.println("""res9: week2.Rational = """ + $show(res$9));$skip(8); val res$10 = 
  y + y;System.out.println("""res10: week2.Rational = """ + $show(res$10));$skip(16); val res$11 = 
  
  x.less(y);System.out.println("""res11: Boolean = """ + $show(res$11));$skip(8); val res$12 = 
  x < y;System.out.println("""res12: Boolean = """ + $show(res$12));$skip(15); val res$13 = 
  
  x.max(y);System.out.println("""res13: week2.Rational = """ + $show(res$13));$skip(10); val res$14 = 
  x max y;System.out.println("""res14: week2.Rational = """ + $show(res$14));$skip(21); val res$15 = 
  
  new Rational(2);System.out.println("""res15: week2.Rational = """ + $show(res$15));$skip(222); 
  
  //--------------------------------------------------------------------------------
  // Identifier naming tests.
  //--------------------------------------------------------------------------------
  def _ger_++ = 0;System.out.println("""_ger_++ : => Int""");$skip(17); 
  def _ser_= = 0;System.out.println("""_ser_= : => Int""")}
}


//--------------------------------------------------------------------------------
// Rational class.
//--------------------------------------------------------------------------------
class Rational(x: Int, y: Int) {
	require(y != 0, "denominator must be nonzero")
	require(y > 0,  "denominator must be positive")
	
	// The second constructor (non primary), that takes only numerator (denominator equals "1").
	def this(x: Int) = this(x, 1)

  def numer = x
  def denom = y
  
	// Greatest commond divider method.
	private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a%b)
	//private val g = gcd(x, y)
  //def numer = x / g
  //def denom = y / g
  
  
  def less(that: Rational) = numer * that.denom < that.numer * denom
  def < (that: Rational)   = numer * that.denom < that.numer * denom
  
  
  //def max(that: Rational) = if(this.less(that)) that else this
  def max(that: Rational) = if(this < that) that else this


  def add(that: Rational) = new Rational(numer * that.denom + denom * that.numer, denom * that.denom)
  def + (that: Rational)  = new Rational(numer * that.denom + denom * that.numer, denom * that.denom)


  def neg: Rational       = new Rational(-numer, denom)
  def unary_- : Rational  = new Rational(-numer, denom)
  
  
  def sub(that: Rational) = add(that.neg)
  def - (that: Rational)  = this + -that
    
    
  def mul(that: Rational) = new Rational(numer * that.numer, denom * that.denom)
    
    
  def div(that: Rational) = new Rational(numer * that.denom, denom * that.numer)
    

  override def toString = {
		val g = gcd(x, y)
	  numer/g + "/" + denom/g
  }
}
