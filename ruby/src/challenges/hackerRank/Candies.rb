#!/usr/bin/ruby

=begin
Alice is a kindergarden teacher. She wants to give some candies to the children in her class.
All the children sit in a line and each  of them  has a rating score according to his or
her usual performance. Alice wants to give at least 1 candy for each child.
Children get jealous of their immediate neighbors, so if two children sit next to each other
 then the one with the higher rating must get more candies. Alice wants to save money, so
she wants to minimize the total number of candies.

Input
The first line of the input is an integer N, the number of children in Alice’s class.
Each of the following N lines contains an integer indicates the rating of each child.

Output
A single line containing the minimum number of candies Alice must give.

Sample Input
3
1
2
2

Sample Ouput
4

=end

print 'amount of students? '
size = gets.chomp
students = Hash.new

print 'students? '
student = gets.chomp

until student.empty?

  students[student.to_i] = 1
  student = gets.chomp

end

student_keys = students.keys

student_keys.each { |rating|

  #incomplete...

}