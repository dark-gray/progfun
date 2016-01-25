package week7

object Lecture_7_5 {
  println("Welcome to the Scala lecture 7.5 worksheet")
                                                  //> Welcome to the Scala lecture 7.5 worksheet
  
  val problem = new Pouring(Vector(4, 9, 19))     //> problem  : week7.Pouring = week7.Pouring@17d0578
  problem.moves                                   //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with w
                                                  //| eek7.Lecture_7_5.problem.Move] = Vector(Empty(0), Empty(1), Empty(2), Fill(0
                                                  //| ), Fill(1), Fill(2), Pour(0,1), Pour(0,2), Pour(1,0), Pour(1,2), Pour(2,0), 
                                                  //| Pour(2,1))
  problem.pathSets.take(3).toList                 //> res1: List[Set[week7.Lecture_7_5.problem.Path]] = List(Set(--> Vector(0, 0, 
                                                  //| 0)), Set(Empty(1)--> Vector(0, 0, 0), Pour(1,0)--> Vector(0, 0, 0), Fill(1)-
                                                  //| -> Vector(0, 9, 0), Fill(0)--> Vector(4, 0, 0), Fill(2)--> Vector(0, 0, 19),
                                                  //|  Pour(0,2)--> Vector(0, 0, 0), Empty(2)--> Vector(0, 0, 0), Pour(0,1)--> Vec
                                                  //| tor(0, 0, 0), Empty(0)--> Vector(0, 0, 0), Pour(1,2)--> Vector(0, 0, 0), Pou
                                                  //| r(2,0)--> Vector(0, 0, 0), Pour(2,1)--> Vector(0, 0, 0)), Set(Fill(2) Pour(2
                                                  //| ,1)--> Vector(0, 19, 0), Pour(0,2) Fill(1)--> Vector(0, 9, 0), Empty(2) Fill
                                                  //| (0)--> Vector(4, 0, 0), Fill(1) Pour(2,0)--> Vector(0, 9, 0), Pour(1,2) Fill
                                                  //| (0)--> Vector(4, 0, 0), Empty(1) Pour(1,2)--> Vector(0, 0, 0), Pour(1,0) Fil
                                                  //| l(2)--> Vector(0, 0, 19), Pour(2,1) Pour(2,1)--> Vector(0, 0, 0), Empty(2) P
                                                  //| our(0,1)--> Vector(0, 0, 0), Fill(1) Fill(0)--> Vector(4, 9, 0), Pour(2,0) P
                                                  //| our(2,0)--> Vector(0, 0, 0), Empty(2) Pour(1,0)--> Vector(0, 0, 0), Pour(2,0
                                                  //| ) Empty(0)--> Vector(0, 
                                                  //| Output exceeds cutoff limit.
	problem.solutions(18)                     //> res2: Stream[week7.Lecture_7_5.problem.Path] = Stream(Fill(2) Pour(1,2) Fill
                                                  //| (1) Pour(2,1)--> Vector(0, 18, 0), ?)
}