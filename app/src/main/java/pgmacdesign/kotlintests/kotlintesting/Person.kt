package pgmacdesign.kotlintests.kotlintesting

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.util.*

///Class Setup with no constructors and just normal setup following Java's getter / setter approach
class Person {
    @SerializedName("uuid")
    val uuid: String? = UUID.randomUUID().toString();
    @SerializedName("first_name")
    var firstName: String? = null;
    @SerializedName("last_name")
    var lastName: String? = null;
    @SerializedName("age")
    var age: Int? = null;
}
fun Person.toJson() : String{
    return Gson().toJson(this, this.javaClass);
}

