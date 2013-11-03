package challenges.cracking.linkedLists

class Node(private var _data:Int) {

  private var _next:Option[Node] = None

  def next:Option[Node] = _next
  def next_= (newNext:Node) = {
    _next = Some(newNext)
  }

  def data:Int = _data

  def appendToTail(data: Int) = {

    val end:Node = new Node(data)
    var self:Node = this

    while (self.next.nonEmpty) {
      self = self.next.get
    }

    self.next = end

  }

  def deleteNode(head:Node, data:Int):Option[Node] = {
    var node:Node = head
    if(node.data == data){
      return head.next
    }

    while (node.next.nonEmpty) {
      if (node.next.get.data == data) {
        node.next = node.next.get.next.get
        return Some(head) // head didn't change
      }
      node = node.next.get
    }

    None // not found
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

    n1.deleteNode(n1, 3)

    n1.toString

  }

}