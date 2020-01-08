package pgmacdesign.kotlintests.kotlintesting

import com.google.gson.annotations.SerializedName
import java.util.*

abstract class PersonV4 (@SerializedName("first_name")
                         var firstName: String? = null,
                         @SerializedName("last_name")
                         var lastName: String? = null,
                         @SerializedName("age")
                         var age: Int = 21){

    /**
     * Note! This open declaration here allows it to be overridden
     */
    abstract val someNewId: String;

    @SerializedName("uuid")
    val uuid: String? = UUID.randomUUID().toString();

    /**
     * Static initializer like in Java
     * NOTE! This init block is part of the Primary Constructor (above) and runs BEFORE
     * any secondary constructors (Below)
     */
    init {
        println("This runs first")
//        this.someNewId = this.uuid + "x";
        //^ This cannot run because as it is abstract, it cannot be initialized in this class
    }

    init {
        println("This runs second")
    }

    constructor(year: Int): this() {
        println("This runs third, regardless of where it is placed ")
        this.age+= year;
    }

}