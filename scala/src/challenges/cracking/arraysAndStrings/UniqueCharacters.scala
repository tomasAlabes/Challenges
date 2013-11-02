package challenges.cracking.arraysAndStrings

// Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?

object UniqueCharacters {

  def hasUniqueCharacters(string:String):Boolean = {
    val chars: Array[Char] = string.toArray

    for (c <- chars){
      if(chars.count(_ == c) >= 2){
        return false
      }
    }
    true
  }

  def main(args: Array[String]) {
    println(hasUniqueCharacters("hello"))
    println(hasUniqueCharacters("bye"))
    println(hasUniqueCharacters("byeeeee"))
  }

}