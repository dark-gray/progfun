package week6

object Lecture_6_6 {
  println("Welcome to the Scala lecture 6.6 worksheet")
                                                  //> Welcome to the Scala lecture 6.6 worksheet
	val romanNumerals = Map('I' -> 1, 'V' -> 5, 'X' -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[Char,Int] = Map(I -> 1, V ->
                                                  //|  5, X -> 10)
	val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)
	capitalOfCountry("Switzerland")           //> res0: String = Bern
	//capitalOfCountry("Andorra")
	capitalOfCountry get "Andorra"            //> res1: Option[String] = None
	capitalOfCountry get "US"                 //> res2: Option[String] = Some(Washington)
	
	def showCapital(country: String) = capitalOfCountry.get(country) match {
		case Some(capital) => capital
		case None => "Missing data."
	}                                         //> showCapital: (country: String)String
	
	showCapital("Andorra")                    //> res3: String = Missing data.
	showCapital("US")                         //> res4: String = Washington
	
  val cap1 = capitalOfCountry withDefaultValue "<unknown>"
                                                  //> cap1  : scala.collection.immutable.Map[String,String] = Map(US -> Washington
                                                  //| , Switzerland -> Bern)
  cap1("Andorra")                                 //> res5: String = <unknown>
  
  ///---------------------------------------------------------------------------
  
  val fruit = List("apple", "pear", "orange", "pineapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pineapple)
  fruit sortWith (_.length < _.length)            //> res6: List[String] = List(pear, apple, orange, pineapple)
  fruit.sorted                                    //> res7: List[String] = List(apple, orange, pear, pineapple)
  fruit groupBy (_.head)                          //> res8: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pineapple), a -> List(apple), o -> List(orange))
 
  ///---------------------------------------------------------------------------
  // Poly, версия 1.
  /**
  class Poly(val terms: Map[Int, Double]) {
  	val terms = terms0 withDefaultValue 0.0
  	def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
  	def adjust(term: (Int, Double)): (Int, Double) = {
  		val (exp, coeff) = term
 			terms get exp match {
  			case Some(coeff1) => exp -> (coeff + coeff1)
  			case None         => exp -> coeff
   		}
 	}
  	override def toString =
  		(for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff+"x^"+exp) mkString " + "
  }
  
  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))
  p1 + p2
  p1.terms(7)
  */
  ///---------------------------------------------------------------------------
  // Poly, версия 2.
   
  class Poly(terms0: Map[Int, Double]) {
  	def this (bindings: (Int, Double)*) = this(bindings.toMap)
  	val terms = terms0 withDefaultValue 0.0
  	/*
  	// +, версия 1.
  	def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
  	def adjust(term: (Int, Double)): (Int, Double) = {
  		val (exp, coeff) = term
  		exp -> (coeff + terms(exp))
  	}
  	*/
  	// +, версия 2.
  	def + (other: Poly) =
  		new Poly((other.terms foldLeft terms)(addTerm))
  	def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
  		val (exp, coeff) = term
  		terms + (exp -> (coeff + terms(exp)))
  	}
  	
  	override def toString =
  		(for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff+"x^"+exp) mkString " + "
  }
  
  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2) //> p1  : week6.Lecture_6_6.Poly = 6.2x^5 + 4.0x^3 + 2.0x^1
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0)           //> p2  : week6.Lecture_6_6.Poly = 7.0x^3 + 3.0x^0
  p1 + p2                                         //> res9: week6.Lecture_6_6.Poly = 6.2x^5 + 11.0x^3 + 2.0x^1 + 3.0x^0
  p1.terms(7)                                     //> res10: Double = 0.0
}