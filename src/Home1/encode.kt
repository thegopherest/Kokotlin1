package Home1

import com.sun.xml.internal.fastinfoset.util.StringArray

fun main(args: Array<String>){
    val str = "aaaaaabbbbbaccccddeeeee"
    var save = str[0]
    var counter = -1
    var newSrt = ""
    for (lett in 1..str.length - 1){
        if (counter == -1)
        {
            counter++
        }
        else if(str[lett] == save)
        {
            counter++
        }
        else
        {
            newSrt += save
            newSrt += counter + 1
            counter = 0
            save = str[lett]
        }
    }
    newSrt += save
    newSrt += counter + 1
    print(newSrt)
}

