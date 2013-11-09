package challenges.cracking.linkedLists

import org.scalatest.{BeforeAndAfter, FunSuite}

class NodeTest extends FunSuite with BeforeAndAfter {

  var n1:Node = _

  before {
    n1 = new Node(1)

    n1.appendToTail(3)
    n1.appendToTail(2)
    n1.appendToTail(2)
    n1.appendToTail(4)
    n1.appendToTail(5)

  }

  test("new list have 6 nodes") {
    assert(n1.size == 6)
  }

  test("delete data 3 node") {
    n1.deleteNode(3)
    assert(n1.size == 5)
    assert(n1.next.get.data != 3)
  }

  test("removing list duplicates") {
    n1.removeDuplicates()
    assert(n1.size == 5)
  }

  test("get last 2 nodes") {
    val nth:Option[Node] = n1.nthToLast(2)
    assert(nth.nonEmpty)
    assert(nth.get.size == 2)
  }

  test("get last 20 nodes") {
    val nth:Option[Node] = n1.nthToLast(20)
    assert(nth.isEmpty)
  }

  test("delete first node") {
    assert(n1.delete())
    assert(n1.size == 5)
    assert(n1.data != 1)
  }

  test("delete last node") {
    val lastNode: Node = n1.nthToLast(1).get
    assert(!lastNode.delete())
  }

  test("sum lists") {
    val lastNode: Node = n1.nthToLast(3).get
    // 542231 + 542 = 542773
    assert(542773 == LinkedListUtil.sumLists(n1, lastNode))
  }

}
