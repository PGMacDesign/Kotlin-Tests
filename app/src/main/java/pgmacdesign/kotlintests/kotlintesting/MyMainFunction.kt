package pgmacdesign.kotlintests.kotlintesting

import android.os.Build
import pgmacdesign.kotlintests.kotlintesting.KotlinUtilities;
import java.util.function.Consumer

fun main(args: Array<String>){
    //Sample vars
//    sampleVars()

    //For loop enhanced
    var values = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    if(Build.VERSION.SDK_INT >= 24){
        val con: Consumer<Int> = object : Consumer<Int>{
            override fun accept(value: Int) {
                println("int == ${value}")
            }
        }
        println("Printing the values 0")
        values.forEach(con);
    }

    println("Printing the values 1")
    values.forEach({t -> println(t)});
    println("Printing the values 2")
    values.forEach({println(it)});
    println("Printing the values 3")
    values.forEach(::println);
    println("Printing the values 4")
    values.forEach(::patTest);



}

fun patTest(i: Int) {
    println("Not printing int value here, but using for reference.")
}
