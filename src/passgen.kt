import java.util.*

fun main(args: Array<String>){
    val leng = 10
    if(leng > 1)
    {
        var pass = UUID.randomUUID().toString()
        while(pass.length < leng)
        {
            pass += UUID.randomUUID().toString()
        }
        if(pass.length > leng)
        {
            pass = pass.substring(0, leng)
        }
        println(pass)
    }
}