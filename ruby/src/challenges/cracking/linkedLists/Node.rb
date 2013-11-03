class Node

  attr_reader :data
  attr_accessor :next

  def initialize(data)
    @data = data
    @next = nil
  end

  def append_to_tail(data)

    new_node = Node.new(data)
    this = self

    while this.next != nil
      this = this.next
    end

    this.next = new_node

  end

  def delete_node (head, data)

    node = head
    if node.data == data
        return head.next
    end

    while node.next != nil
      if node.next.data == data
        node.next = node.next.next
        return head # head didn't change
      end
      node = node.next
    end

    nil # not found

  end

  def to_s
    puts data
    puts @next.data if @next != nil
  end

end

n1 = Node.new(1)
n1.append_to_tail(3)
n1.append_to_tail(2)

n1.delete_node(n1, 3)

n1.to_s