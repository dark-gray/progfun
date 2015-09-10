package week2

object Lecture_2_5 {
  println("Welcome to the Scala lecture 2.5-2.6 worksheet")
                                                  //> Welcome to the Scala lecture 2.5-2.6 worksheet
                                                 
  //--------------------------------------------------------------------------------
  // Functions for rational numbers.
  //--------------------------------------------------------------------------------
  def addRational(r: Rational, s: Rational): Rational = new Rational(r.numer * s.denom + s.numer * r.denom, r.denom * s.denom)
                                                  //> addRational: (r: week2.Rational, s: week2.Rational)week2.Rational
  def makeString(r: Rational) = r.numer + "/" + r.denom
                                                  //> makeString: (r: week2.Rational)String
                                                  
  //--------------------------------------------------------------------------------
  // Tests for functions.
  //--------------------------------------------------------------------------------
  addRational(new Rational(1, 2), new Rational(2, 3))
                                                  //> res0: week2.Rational = 7/6
  makeString(addRational(new Rational(1, 2), new Rational(2, 3)))
                                                  //> res1: String = 7/6

  //--------------------------------------------------------------------------------
  // Rational class tests.
  //--------------------------------------------------------------------------------
  val x = new Rational(1, 3)                      //> x  : week2.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : week2.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : week2.Rational = 3/2
  
  x.numer                                         //> res2: Int = 1
  x.denom                                         //> res3: Int = 3

  x.add(y)                                        //> res4: week2.Rational = 22/21
  
  x.sub(z)                                        //> res5: week2.Rational = 7/-6
  x.neg                                           //> res6: week2.Rational = 1/-3
  
  x.sub(y).sub(z)                                 //> res7: week2.Rational = -79/42
  x - y - z                                       //> res8: week2.Rational = -79/42
  
  y.add(y)                                        //> res9: week2.Rational = 10/7
  y + y                                           //> res10: week2.Rational = 10/7
  
  x.less(y)                                       //> res11: Boolean = true
  x < y                                           //> res12: Boolean = true
  
  x.max(y)                                        //> res13: week2.Rational = 5/7
  x max y                                         //> res14: week2.Rational = 5/7
  
  new Rational(2)                                 //> res15: week2.Rational = 2/1
  
  //--------------------------------------------------------------------------------
  // Identifier naming tests.
  //--------------------------------------------------------------------------------
  def _ger_++ = 0                                 //> _ger_++ : => Int
  def _ser_= = 0                                  //> _ser_= : => Int
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