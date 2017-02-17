package Pack1

import org.jetbrains.annotations.Mutable

fun main(args: Array<String>){
    var func = "2 * 3 / ( ( 4 + 6 ) * 6 ) * ( 99 + 2 )".split(' ').toMutableList()
    Calc(func)
    println(func[0])
    println(func.size)
}

fun Calc(func: MutableList<String>) {
    var start = -1
    var fin = -1
    var counter = 0
    var a = 0
    while(a < func.size )
    {
        if(func[a] == "(")
        {
            if(counter == 0)
            {
                start = a
            }
            counter++
        }
        if (func[a] == ")")
        {
            counter--
            if(counter == 0)
            {
                fin = a
                func.removeAt(start)
                func.removeAt(fin - 1)
                Calc(func.subList(start, fin - 1))
                a = start
            }
        }
        a++
    }

    a = 0
    while (a < func.size)
    {
        when(func[a]){
            "*" ->{
                func.set(a, (func[a - 1].toDouble() * func[a + 1].toDouble()).toString())
                func.removeAt(a - 1)
                func.removeAt(a)

            }
            "/" ->{
                func.set(a, (func[a - 1].toDouble() / func[a + 1].toDouble()).toString())
                func.removeAt(a - 1)
                func.removeAt(a)
            }
            else -> {a++}
        }
    }
    a = 0
    while (a < func.size)
    {
        when(func[a]){
            "+" ->{
                func.set(a, (func[a - 1].toDouble() + func[a + 1].toDouble()).toString())
                func.removeAt(a - 1)
                func.removeAt(a)

            }
            "-" ->{
                func.set(a, (func[a - 1].toDouble() - func[a + 1].toDouble()).toString())
                func.removeAt(a - 1)
                func.removeAt(a)
            }
            else -> {a++}
        }
    }
}

