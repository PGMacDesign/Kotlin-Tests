package pgmacdesign.kotlintests.kotlintesting

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Utilizing a different approach with a constructor.
 * Primary constructor (the one below) does not allow for code inside of it
 *
 */
class PersonV2 constructor(
        @SerializedName("first_name")
        var firstName: String? = null,
        @SerializedName("last_name")
        var lastName: String? = null) {

    @SerializedName("uuid")
    val uuid: String? = UUID.randomUUID().toString();
}