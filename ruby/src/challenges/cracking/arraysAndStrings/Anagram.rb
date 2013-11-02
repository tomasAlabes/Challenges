#!/usr/bin/ruby

def is_anagram? (string)
  string == string.reverse
end

puts is_anagram?('ana')
puts is_anagram?('Ana') #is not case sensitive
puts is_anagram?('bye')