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

    until this.next == nil
      this = this.next
    end

    this.next = new_node

  end

  def delete_node (data)

    node = self
    if node.data == data
        return self.next
    end

    until node.next == nil
      if node.next.data == data
        node.next = node.next.next
        return self # head didn't change
      end
      node = node.next
    end

    nil # not found

  end

  def remove_duplicates
    datas = [@data]
    this = self

    until this.next == nil

      next_node = this.next

      if datas.include?(next_node.data)
        this.next = next_node.next
      else
        datas.push(next_node.data)
      end

      this = next_node

    end

  end

  def to_s
    puts data
    puts @next.data if @next != nil
  end

end

n1 = Node.new(1)
n1.append_to_tail(3)
n1.append_to_tail(2)
n1.append_to_tail(2)

n1.delete_node(3)

n1.remove_duplicates()

n1.to_s