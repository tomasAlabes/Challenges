require 'test-unit'
require '../../../../src/challenges/cracking/linkedLists/Node'


class NodeTest < Test::Unit::TestCase

  def setup
    @n1 = Node.new(1)
    @n1.append_to_tail 3
    @n1.append_to_tail 2
    @n1.append_to_tail 2
    @n1.append_to_tail 4
    @n1.append_to_tail 5
  end

  def test_get_size
    assert_equal(6, @n1.size)
  end

  def test_delete_node
    @n1.delete_node 3 # 1-2-2-4-5

    assert_not_equal(@n1.next.data, 3)
    assert_equal(5, @n1.size)
  end

  def test_remove_duplicates
    @n1.remove_duplicates() # 1-3-2-4-5

    assert_equal(5, @n1.size)
  end

  def test_nth_to_last
    last_two = @n1.nth_to_last(2) # 4-5
    assert_equal(2, last_two.size)
    assert_equal(last_two.data, 4)
    assert_equal(last_two.next.data, 5)
  end

  def test_delete
    @n1.delete

    assert_equal(5, @n1.size)
    assert_equal(3, @n1.data)
  end

  def test_sum_lists
    last_two = @n1.nth_to_last(3)
    # 542231 + 542 = 542773
    assert_equal(542773, Linked_List_Utils.sum_linked_lists(@n1, last_two))
  end

end