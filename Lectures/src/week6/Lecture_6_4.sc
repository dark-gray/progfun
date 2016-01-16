package week6

object Lecture_6_4 {
  println("Welcome to the Scala lecture 6.4 worksheet")
                                                  //> Welcome to the Scala lecture 6.4 worksheet
  
  case class Book (title:String,authors:List[String])
  
	val books: List[Book] = List(
	//val books = Set(
		Book(title   = "Structure and Interpretation of Computer Programs",
				 authors = List("Abelson, Harald","Sussman, Gerald J.")),
		Book(title   = "Introduction to Functional Programming",
				 authors = List("Bird, Richard","Wadler, Phil")),
		Book(title   = "Effective Java",
				 authors = List("Bloch, Joshua")),
		//Book(title   = "Effective Java 2",
		//		 authors = List("Bloch, Joshua")),
		Book(title   = "Java Puzzlers",
				 authors = List("Bloch, Joshua","Gafter, Neal")),
		Book(title   = "Programming in Scala",
				 authors = List("Odersky, Martin","Spoon, Lex","Venners, Bill")))
                                                  //> books  : List[week6.Lecture_6_4.Book] = List(Book(Structure and Interpretati
                                                  //| on of Computer Programs,List(Abelson, Harald, Sussman, Gerald J.)), Book(Int
                                                  //| roduction to Functional Programming,List(Bird, Richard, Wadler, Phil)), Book
                                                  //| (Effective Java,List(Bloch, Joshua)), Book(Java Puzzlers,List(Bloch, Joshua,
                                                  //|  Gafter, Neal)), Book(Programming in Scala,List(Odersky, Martin, Spoon, Lex,
                                                  //|  Venners, Bill)))
  
  for (b <- books; a <- b.authors if a startsWith "Bird,") yield b.title
                                                  //> res0: List[String] = List(Introduction to Functional Programming)
  for (b <- books if (b.title indexOf "Program") >= 0) yield b.title
                                                  //> res1: List[String] = List(Structure and Interpretation of Computer Programs,
                                                  //|  Introduction to Functional Programming, Programming in Scala)
	for {
		b1 <- books
		b2 <- books
		if b1 != b2
		a1 <- b1.authors
		a2 <- b2.authors
		if a1 == a2
	} yield a1                                //> res2: List[String] = List(Bloch, Joshua, Bloch, Joshua)
	
	for {
		b1 <- books
		b2 <- books
		if b1.title < b2.title
		a1 <- b1.authors
		a2 <- b2.authors
		if a1 == a2
	} yield a1                                //> res3: List[String] = List(Bloch, Joshua)
}