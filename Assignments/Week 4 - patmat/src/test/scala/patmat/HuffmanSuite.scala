package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
	trait TestTrees {
    val t0 = Leaf('a',2)
		val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
		val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
    
    val l0 = List('a','b','c','a')
    val l1 = List(Leaf('a',2), Leaf('b',5), Leaf('c',8))
	}

  type Bit = Int

  ///---------------------------------------------------------------------------
  /// Тесты для изучения работы библиотечных функций.
  
  test("minBy") {
    assert(List(('t', 2), ('e', 1), ('a', 3)).minBy(_._2) === ('e',1))
  }
  
  test("sortBy") {
    assert(List(('t', 2), ('e', 1), ('a', 3)).sortBy(_._2) === List(('e',1), ('t',2), ('a',3)))
  }
  
  test("sortWith") {
    assert(List(('t', 2), ('e', 1), ('a', 3)).sortWith((x1, x2) => x1._2 < x2._2) === List(('e',1), ('t',2), ('a',3)))
  }
  ///---------------------------------------------------------------------------
  
  test("weight of the tree 0") {
    new TestTrees {
      assert(weight(t0) === 2)
    }
  }
  
  test("weight of the tree 1") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("weight of the tree 2") {
    new TestTrees {
      assert(weight(t2) === 9)
    }
  }

  test("chars of the tree 0") {
    new TestTrees {
      assert(chars(t0) === List('a'))
    }
  }
  
  test("chars of the tree 1") {
    new TestTrees {
      assert(chars(t1) === List('a','b'))
    }
  }
  
  test("chars of the tree 2") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("times of the l0") {
    new TestTrees {
      assert(times(l0) === List(('a', 2), ('b', 1), ('c', 1)) )
    }
  }


  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }


  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('a', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('a',3)))
  }

  
  test("singleton 1") {
    assert(singleton(List(Leaf('e',1), Leaf('t',2), Leaf('a',3))) === false)
  }
  
  test("singleton 2") {
    assert(singleton(List(Leaf('e',1))) === true)
  }
  
  test("singleton 3") {
    assert(singleton(List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3))) === true)
  }
  
  
  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
    assert(combine(combine(leaflist)) === List(Fork(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4), List('e', 't', 'x'), 7)))
  }

  test("until") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(until(singleton, combine)(leaflist) === List(Fork(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4), List('e', 't', 'x'), 7)))
  }

  test("createCodeTree") {
    val chars = List('x', 'e', 't', 'x', 't', 'x','x')
    assert(createCodeTree(chars) === Fork(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4), List('e', 't', 'x'), 7))
  }
  
  test("decode text") {
    val tree = Fork(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4), List('e', 't', 'x'), 7)
    val key: List[Bit]  = List(1, 0, 0, 0, 1, 1, 0, 1, 1, 1)
    assert(decode(tree, key) === List('x', 'e', 't', 'x', 't', 'x','x'))
  }
  
  test("encode text using Huffman tree") {
    val tree = Fork(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4), List('e', 't', 'x'), 7)
    val text = List('x', 'e', 't', 'x', 't', 'x','x')
    assert(encode(tree)(text) === List(1, 0, 0, 0, 1, 1, 0, 1, 1, 1))
  }
  
  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("codeBits") {
    val table = List(('e', List(0,0)), ('t', List(0,1)), ('x', List(1)))
    assert(codeBits(table)('e') === List(0,0))
    assert(codeBits(table)('t') === List(0,1))
    assert(codeBits(table)('x') === List(1))
  }
  
  test("convert") {
    val tree = Fork(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4), List('e', 't', 'x'), 7)
    assert(convert(tree) === List(('e', List(0,0)), ('t', List(0,1)), ('x', List(1))))
  }
  
  test("quickEncode") {
    val tree = Fork(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4), List('e', 't', 'x'), 7)
    val text = List('x', 'e', 't', 'x', 't', 'x','x')
    assert(encode(tree)(text) === List(1, 0, 0, 0, 1, 1, 0, 1, 1, 1))
  }
  
}
