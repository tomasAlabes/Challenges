package challenges.cracking.linkedLists

import scala.collection.mutable.ListBuffer

class Node(private var _data:Int) extends LinkedNode { // typical private field in class, with '_' because of later data fn

  private var _next:Option[Node] = None

  override def next:Option[Node] = _next // public getter
  override def next_= (newNext:Option[Node]) = { // public setter, the '_' are conventions
    _next = newNext
  }

  def data:Int = _data //public getter

  override def appendToTail(data: Int) = {

    val end:Node = new Node(data)
    var self:Node = this

    while (self.next.nonEmpty) {
      self = self.next.get
    }

    self.next = Some(end)

  }

  override def size():Int = {
    var count: Int = 1
    var current: Option[Node] = this.next

    while(current.nonEmpty){
      count+=1
      current = current.get.next
    }

    count
  }

  override def deleteNode(data:Int):Option[Node] = {
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

  override def removeDuplicates() = {
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

  override def nthToLast(n:Int):Option[Node] = {

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

  override def delete():Boolean = {
    if (this.next.isEmpty) return false

    val next = this.next.get

    this._data = next.data
    this.next = next.next

    true
  }

  override def toString:String = {
    println(data)
    if (_next.nonEmpty) {
      _next.get.toString
    }
    data.toString
  }

}

object LinkedListUtil {

  def sumLists(list1:Node, list2:Node):Int = {
    require(list1 != null && list2 != null)

    var current = list1

    val n:StringBuilder = new StringBuilder
    n.append(current.data)
    while (current.next.nonEmpty){
      n.append(current.next.get.data)
      current = current.next.get
    }

    val n1:Int = n.toString().reverse.toInt

    current = list2
    n.clear()
    n.append(current.data)
    while (current.next.nonEmpty){
      n.append(current.next.get.data)
      current = current.next.get
    }

    val n2:Int = n.toString().reverse.toInt

    n1 + n2

  }

}