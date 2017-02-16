fun main(args: Array<String>){
    val basicArray = listOf("asd","sadgjjgfdj","fdgkjgkldye","q","ppppp")
    var newArray =  Array(26, { i -> mutableListOf(" " + (i + 97).toChar()) })
    for (i in 0..basicArray.size - 1)
    {
        newArray[basicArray[i][0].toLowerCase().toInt() - 97].add(basicArray[i])
    }
   for (list in newArray)
   {
       if (list.size > 1) {
           for (word in list) {
               println(word)
           }
       }
   }
}