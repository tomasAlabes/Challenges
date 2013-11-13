package challenges.cracking.linkedLists

trait LinkedNode {

  var next:Option[Node]

  def appendToTail(data:Int)

  def size():Int

  def deleteNode(data:Int):Option[Node]

  def removeDuplicates()

  def nthToLast(n:Int):Option[Node]

  def delete():Boolean

}
