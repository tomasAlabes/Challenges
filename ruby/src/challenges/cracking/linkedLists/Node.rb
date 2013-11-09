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

    until this.next.nil?
      this = this.next
    end

    this.next = new_node

  end

  def size
    count = 1
    current = @next
    until current.nil?
      count+=1
      current = current.next
    end

    count

  end

  def delete_node (data)

    node = self
    if node.data == data
        return self.next
    end

    until node.next.nil?
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

    until this.next.nil?

      next_node = this.next

      if datas.include?(next_node.data)
        this.next = next_node.next
      else
        datas.push(next_node.data)
      end

      this = next_node

    end

  end

  def nth_to_last(n)
    this = self

    return nil if n < 1

    p1 = p2 = this

    (n - 1).times { # skip n-1 steps ahead
      return nil if p2.nil? # not found since list size < n }
      p2 = p2.next
    }

    until p2.next.nil?
      p1 = p1.next
      p2 = p2.next
    end

    p1

  end

  def delete
    return false if self.next.nil?

    next_node = self.next

    @next = next_node.next
    @data = next_node.data

    true

  end

  def to_s
    puts data
    puts @next.data if @next != nil
  end

end

class Linked_List_Utils

  def self.sum_linked_lists(list1, list2) #static method
    raise ArgumentError, 'Neither list can be nil' if list1.nil? or list2.nil?
    current = list1
    str_num = list1.data.to_s

    until current.next.nil?
      str_num.concat(current.next.data.to_s)
      current = current.next
    end
    n1 = str_num.to_s.reverse.to_i

    current = list2
    str_num = list2.data.to_s

    until current.next.nil?
      str_num.concat(current.next.data.to_s)
      current = current.next
    end
    n2 = str_num.to_s.reverse.to_i

    return (n1 + n2)

  end

end