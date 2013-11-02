package challenges.hackerRank

import scala.collection.mutable

/*

There are N integers in an array A. All but one integer occurs in pairs. Your task is to find out that number that occurs only once.

Input Format

The first line of the input contains an integer N indicating N integers in the array A. Next line contains N integers each separated by a single space.

Constraints

1 <= N < 100
N % 2 = 1 ( N is an odd number )
0 <= i <= 100, ∀ i ∈ A

Output Format

Output (S) which is the number that occurs only once.

Example:

Input:
3
5 5 4

Output: (the lonely integer)
4

*/

object Solution {

  def main(args: Array[String]) {
    val size: String = readLine()
    val numbers: String = readLine()

    val map = mutable.HashMap[Int, Boolean]()
    val array: Array[String] = numbers.split(" ")

    for (x <- array) {
      val number:Int = Integer.valueOf(x)
      if (map.contains(number)) {
        map.put(number, true)
      } else {
        map.put(number, false)
      }
    }

    val solution: Int = map.find(_._2 == false).get._1
    println(solution)
  }

}