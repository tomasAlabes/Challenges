#!/usr/bin/ruby

def has_unique_characters (string)

  chars = string.chars

  chars.each do |c|
    return false if chars.count(c) >= 2
  end

  true

end

puts has_unique_characters('hello')
puts has_unique_characters('bye')
puts has_unique_characters('byeee')
