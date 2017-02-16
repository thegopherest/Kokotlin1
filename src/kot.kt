


//TODO hello worlds

//fun Home1.Home1.Home1.main(args: Array<String>) = println("Hello!")

// Fun function:)
fun main(args: Array<String>) = if (args[0].toInt() > args[1].toInt()) print(args[0]) else print(args[1])

//fun Home1.Home1.Home1.main(args: Array<String>) : Unit {
//    println("Hello, World!")
//}

//fun Home1.Home1.Home1.main(args: Array<String>) {
//    if( args.size > 0)
//        println("Hello, ${args[0]}!")
//    else
//        println("Hello, Kotlin!")
//}

//TODO console

// How to make .jar with your code:
// kotlinc hello.kt -include-runtime -d hello.jar
// full paths needed instead of hello.kt and hello.jar when you using Win systems

//fun Home1.Home1.Home1.main(args: Array<String>){
//    println("Hello, World from command line!")
//}

//TODO variables

// val - immutable
// var - mutable

//fun Home1.Home1.Home1.main(args: Array<String>){
//    i = k.toInt()
//    println(a == b)
//}
//
//var i = 1
//val k = "this is a string"
//
//val a = 0f
//val b = 0

// toString

//fun Home1.Home1.Home1.main(args: Array<String>){
//    val name = if (args.size > 0) args[0] else "Иван Заиндервенелый"
//    println("Привет, $name")
//}

//fun Home1.Home1.Home1.main(args: Array<String>){
//    println(mayakovsky)
//    println(mayakovskyLiteral)
//}
//
//val mayakovsky = "В моде" +
//                         "в каждой" +
//                                 "так положено," +
//                  "что нельзя без пуговицы," +
//                                         "а без головы можно."
//
//val mayakovskyLiteral = """
//                           В моде
//                                 в каждой
//                                         так положено,
//                           что нельзя без пуговицы,
//                                                  а без головы можно.
//"""

//fun Home1.Home1.Home1.main(args: Array<String>){
//    val basicArray = mutableListOf("Петька","Василий Иваныч","Анка")
//    basicArray.add("Пулемет")
//    println(basicArray)
//}


//TODO null and not-null

//fun Home1.Home1.Home1.main(args: Array<String>){
//    println(funWithNullable(3))
//    println(funWithNullable(null))
//}

//fun funWithNullable(a: Int?): Int{
//    a?.let{
//      return a
//    }
//    return 42
//}

//TODO to show REPL!!! (read-eval-print loop)

//TODO basic functions

//TODO control-flow switches

// if () {} else {}

//fun Home1.Home1.Home1.main(args: Array<String>){
//    val name = if (args.size > 0)
//        when(args[0]){
//            "усы" -> {
//                println("abc")
//                "Василий Иванович"}
//            "борода" -> "Дровосек"
//            "портянки" -> "Петька"
//            "коса" -> "Анка"
//            else -> "Иван Заиндервенелый"
//        }
//        else "Анонимус"
//    println("Привет, $name!")
//
//    //to refactor!
//}

//TODO loops - are statements

//TODO for

//fun Home1.Home1.Home1.main(args: Array<String>){
//    if (args.size < 1) return
//
//    val basicArray = mutableListOf("Петька","Василий Иваныч","Анка")
//
//    for (name in basicArray){
//        println(if (name == args[0]) name else "не попадос")
//    }
//}

//fun Home1.Home1.Home1.main(args: Array<String>){
//    println("1")
//    for(i in 1..100 step 3)
//        println("[i = $i]")
//
//    println()
//    println("2")
//    val y = 100500
//    for(i in 1..y)
//        print(y - i)
//
//    println()
//    println("3")
//    for(i in 1 until 10)
//        for(j in 50 downTo 0 step 4)
//            print("| $i $j ")
//}


//TODO while
//

//fun Home1.Home1.Home1.main(args: Array<String>){
//    if (args.size < 1) return
//
//    val repetitions = args[0].toInt()
//
//    var i = 0
//    while(i < repetitions){
//        println("and again $i")
//        i++
//    }
//}
//

//import java.util.*
//
//fun Home1.Home1.Home1.main(args: Array<String>){
//    val interestingMap = HashMap<String,String>()
//
//    interestingMap.put("Анка","Пулемет")
//    interestingMap.put("Казачок","Шашка")
//    interestingMap.put("Чапаев","Усы")
//    interestingMap.put("Петька","Портянки")
//
//    for ((name,attribute) in interestingMap ){
//        println("Главное оружие $name - это $attribute ")
//    }
//
//    //Pair
//}

//fun Home1.Home1.Home1.main(args: Array<String>){
//    for(c in 'a'..'z')
//        println(c)
//}

//TODO ranges and arrays
//TODO strings
//TODO exceptions

//fun Home1.Home1.Home1.main(args: Array<String>) {
//    //val n: Int = args[0].toInt()
//
//    val number = try {
//        args[0].toInt()
//    } catch (e: ArrayIndexOutOfBoundsException) {
//        println("Бяда, не хватает аргументов!")
//        return
//    } catch (e: NumberFormatException){
//        println("Бяда, плохой аргумент!")
//        return
//        //throw IllegalStateException(e)
//    }
//    println(if (number % 2 == 0) "even" else "odd")
//}

//TODO random

//import  java.util.*
//
//private val random = Random()
//fun Home1.Home1.Home1.main(args: Array<String>){
//    for(i in 1..100)
//        println(random.nextInt(5))
//}/**
