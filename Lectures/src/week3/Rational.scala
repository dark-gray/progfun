package week3

/**
 * @author ���������
 */
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