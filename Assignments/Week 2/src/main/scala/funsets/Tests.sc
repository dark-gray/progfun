package funsets

import FunSets._

object Tests {
  
  val set1: Set  = singletonSet(1)                //> set1  : funsets.FunSets.Set = <function1>
  val set2: Set  = singletonSet(2)                //> set2  : funsets.FunSets.Set = <function1>
  val set3: Set  = singletonSet(3)                //> set3  : funsets.FunSets.Set = <function1>

  val set4: Set  = union(set1, set2)              //> set4  : funsets.FunSets.Set = <function1>
  val set5: Set  = union(set4, set3)              //> set5  : funsets.FunSets.Set = <function1>
  val set6: Set  = x => (x > -6 && x < 6)         //> set6  : funsets.FunSets.Set = <function1>
  val set7: Set  = intersect(set5, set6)          //> set7  : funsets.FunSets.Set = <function1>
  val set8: Set  = union(set5, set6)              //> set8  : funsets.FunSets.Set = <function1>
  val set9: Set  = diff(set6, set5)               //> set9  : funsets.FunSets.Set = <function1>
  val set10: Set = diff(set5, set5)               //> set10  : funsets.FunSets.Set = <function1>
  val set11: Set = filter(set6, set5)             //> set11  : funsets.FunSets.Set = <function1>
  
  printSet(set1)                                  //> {1}
  printSet(set2)                                  //> {2}
  printSet(set3)                                  //> {3}
  printSet(set4)                                  //> {1,2}
  printSet(set5)                                  //> {1,2,3}
  printSet(set6)                                  //> {-5,-4,-3,-2,-1,0,1,2,3,4,5}
  printSet(set7)                                  //> {1,2,3}
  printSet(set8)                                  //> {-5,-4,-3,-2,-1,0,1,2,3,4,5}
  printSet(set9)                                  //> {-5,-4,-3,-2,-1,0,4,5}
  printSet(set10)                                 //> {}
  printSet(set11)                                 //> {1,2,3}
  
  println(forall(set4, set5))                     //> true
  println(forall(set5, set4))                     //> false
  println(forall(set5, set6))                     //> true
  println(forall(set5, set10))                    //> false

  println(exists(set4, set8))                     //> true
  println(exists(set3, set2))                     //> false
  println(exists(set1, set2))                     //> false
  
  printSet(map(set5, x => -x))                    //> {-3,-2,-1}
  printSet(map(set5, x => x*x))                   //> {1,4,9}
  printSet(map(set6, x => -x))                    //> {-5,-4,-3,-2,-1,0,1,2,3,4,5}
  printSet(map(set6, x => x*x))                   //> {0,1,4,9,16,25}
}