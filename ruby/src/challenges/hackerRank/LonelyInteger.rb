#!/usr/bin/ruby

print 'size?'
size = gets.chomp
print 'numbers?'
numbers = gets.chomp

map = Hash.new

array = numbers.split(' ')

array.each{ |x|

  number = x.to_i

  if map[number] != nil
    map[number] = true
  else
    map[number] = false
  end
}

solution = map.select{ | _ , v | !v }.keys[0]

print solution
