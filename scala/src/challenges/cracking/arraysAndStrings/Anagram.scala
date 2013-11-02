package challenges.cracking.arraysAndStrings

object Anagram {

  def isAnagram(string:String):Boolean = {
    string == string.reverse
  }

  def main(args: Array[String]) {
    println(isAnagram("ana"))
    println(isAnagram("Ana"))
    println(isAnagram("bye"))
  }

}