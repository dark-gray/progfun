package week4

object Lecture_4_2 {
  println("Welcome to the Scala lecture 4.2 worksheet")
                                                  //> Welcome to the Scala lecture 4.2 worksheet
	//Peano numbers
  abstract class Nat {
		def isZero: Boolean
		def predecessor: Nat
  	def successor = new Succ(this)
		def + (that: Nat): Nat
		def - (that: Nat): Nat
  }
  
  object Zero extends Nat {
  	def isZero = true
  	def predecessor = throw new Error("0.predecessor")
		def +(that: Nat): Nat = that
		def -(that: Nat): Nat = if(that.isZero) this else throw new Error("negative number")
  }
  
  class Succ(n: Nat) extends Nat {
  	def isZero = false
  	def predecessor = n
		def + (that: Nat): Nat = new Succ(n + that)
		def - (that: Nat): Nat = if(that.isZero) n else n - that.predecessor
  }
}