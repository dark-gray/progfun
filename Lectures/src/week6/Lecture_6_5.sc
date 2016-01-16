package week6

object Lecture_6_5 {
  println("Welcome to the Scala lecture 6.5 worksheet")
                                                  //> Welcome to the Scala lecture 6.5 worksheet
                                                  
  case class Book (title:String,authors:List[String])
  
	val books: List[Book] = List(
	//val books = Set(
		Book(title   = "Structure and Interpretation of Computer Programs",
				 authors = List("Abelson, Harald","Sussman, Gerald J.")),
		Book(title   = "Introduction to Functional Programming",
				 authors = List("Bird, Richard","Wadler, Phil")),
		Book(title   = "Effective Java",
				 authors = List("Bloch, Joshua")),
		Book(title   = "Java Puzzlers",
				 authors = List("Bloch, Joshua","Gafter, Neal")),
		Book(title   = "Programming in Scala",
				 authors = List("Odersky, Martin","Spoon, Lex","Venners, Bill")))
                                                  //> books  : List[week6.Lecture_6_5.Book] = List(Book(Structure and Interpretati
                                                  //| on of Computer Programs,List(Abelson, Harald, Sussman, Gerald J.)), Book(Int
                                                  //| roduction to Functional Programming,List(Bird, Richard, Wadler, Phil)), Book
                                                  //| (Effective Java,List(Bloch, Joshua)), Book(Java Puzzlers,List(Bloch, Joshua,
                                                  //|  Gafter, Neal)), Book(Programming in Scala,List(Odersky, Martin, Spoon, Lex,
                                                  //|  Venners, Bill)))
                                                  
  for (b <- books; a <- b.authors if a startsWith "Bird,") yield b.title
                                                  //> res0: List[String] = List(Introduction to Functional Programming)
  
  books flatMap(b => for (a <- b.authors if a startsWith "Bird,") yield b.title)
                                                  //> res1: List[String] = List(Introduction to Functional Programming)
  books flatMap(b => for (a <- b.authors withFilter(a => a startsWith "Bird,")) yield b.title)
                                                  //> res2: List[String] = List(Introduction to Functional Programming)
  //books flatMap(b => b.authors withFilter(a => a startsWith "Bird,") map(y => y.title))
  
}