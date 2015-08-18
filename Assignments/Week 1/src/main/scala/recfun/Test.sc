package recfun

object Test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  /**
   * Exercise 1
   */
  Main.pascal(1, 1)                               //> res0: Int = 1
  Main.pascal(0, 2)                               //> res1: Int = 1
  Main.pascal(1, 2)                               //> res2: Int = 2
  Main.pascal(1, 3)                               //> res3: Int = 3
  Main.pascal(0, 4)                               //> res4: Int = 1
  Main.pascal(1, 4)                               //> res5: Int = 4
  Main.pascal(2, 4)                               //> res6: Int = 6
  Main.pascal(3, 4)                               //> res7: Int = 4
  Main.pascal(4, 4)                               //> res8: Int = 1

  /**
   * Exercise 2
   */
  Main.balance("(just an) example".toList)        //> res9: Boolean = true
  Main.balance("(if (zero? x) max (/ 1 x))".toList)
                                                  //> res10: Boolean = true
  Main.balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList)
                                                  //> res11: Boolean = true
  Main.balance(":-)".toList)                      //> res12: Boolean = false
  Main.balance("())(".toList)                     //> res13: Boolean = false

  /**
   * Exercise 3
   */
  Main.countChange(4, List(1,2))                  //> res14: Int = 3
  Main.countChange(300, List(5,10,20,50,100,200,500))
                                                  //> res15: Int = 1022
  Main.countChange(301, List(5,10,20,50,100,200,500))
                                                  //> res16: Int = 0
  Main.countChange(300, List(500,5,50,100,20,200,10))
                                                  //> res17: Int = 1022

}