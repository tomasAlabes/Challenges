package challenges.cracking.linkedLists

import scala.collection.mutable.ListBuffer

class Node(private var _data:Int) {

  private var _next:Option[Node] = None

  def next:Option[Node] = _next
  def next_= (newNext:Option[Node]) = {
    _next = newNext
  }

  def data:Int = _data

  def appendToTail(data: Int) = {

    val end:Node = new Node(data)
    var self:Node = this

    while (self.next.nonEmpty) {
      self = self.next.get
    }

    self.next = Some(end)

  }

  def deleteNode(data:Int):Option[Node] = {
    var node:Node = this
    if(node.data == data){
      return this.next
    }

    while (node.next.nonEmpty) {
      if (node.next.get.data == data) {
        node.next = node.next.get.next
        return Some(this) // head didn't change
      }
      node = node.next.get
    }

    None // not found
  }

  def removeDuplicates() = {
    val datas:ListBuffer[Int] = new ListBuffer[Int]()
    var self = this

    datas += self.data

    while (self.next.nonEmpty) {

      val nextNode:Node = self.next.get

      if(datas.contains(nextNode.data)){
        self.next = nextNode.next
      }else{
        datas += nextNode.data
      }

      self = nextNode
    }

    // val immutableDatas = datas.toList never needed

  }

  def nthToLast(n:Int):Option[Node] = {

    if (n < 1) return None

    var p1:Option[Node] = Some(this)
    var p2:Option[Node] = Some(this)

    for (i <- 1 to n-1) {
      if (p2.isEmpty) return None
      p2 = p2.get.next
    }

    while (p2.get.next.nonEmpty) {
      p1 = p1.get.next
      p2 = p2.get.next
    }

    p1

  }

  override def toString:String = {
    println(data)
    if (_next.nonEmpty) {
      _next.get.toString
    }
    data.toString
  }

}


object LinkedListMain {

  def main(args: Array[String]) {
    val n1:Node = new Node(1)

    n1.appendToTail(3)
    n1.appendToTail(2)
    n1.appendToTail(2)
    n1.appendToTail(4)
    n1.appendToTail(5)

    n1.deleteNode(3)

    n1.removeDuplicates()

    n1.toString

    println("\n")
    n1.nthToLast(2).get.toString

  }

}