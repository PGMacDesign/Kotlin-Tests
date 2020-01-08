package pgmacdesign.kotlintests.kotlintesting

import com.google.gson.*
import java.lang.reflect.Type

class KotlinUtilities {

    private var gson: Gson? = null;

    private fun getGson(): Gson? {
        if(gson == null){
            gson = GsonBuilder()
                    .setLenient()
//                    .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
//                    .setDateFormat()
                    .create()
        }
        return gson
    }

    /**
     * Convert Object passed to a JSON String
     * Will return an empty String if it cannot parse it properly
     */
    fun toJson(item: Any): String {
        var toReturn : String? = getGson()?.toJson(item, item::class.java)
        if(toReturn != null){
            return toReturn;
        }
        toReturn = getGson()?.toJson(item, item::class.javaObjectType)
        if(toReturn != null){
            return toReturn;
        }
        toReturn = getGson()?.toJson(item, item::class.javaPrimitiveType)
        if(toReturn != null){
            return toReturn;
        }
        return String();
    }

    /**
     * Convert Json String to Object of type passed
     * Pass in `YOUR_ITEM::class.java`
     */
    fun <T> fromJson(jsonString: String, item: Class<T>): T? {
        try {
            return getGson()?.fromJson(jsonString, item);
        } catch (e: JsonIOException){
            e.printStackTrace()
            return item as T;
        }
//        print("item::class.java == ");
//        println(item::class.toString())
//        when(item::class){
//            Int::class -> return jsonString.toInt() as T;
//            String::class -> return jsonString as T;
//            Float::class -> return jsonString.toFloat() as T;
//            Double::class -> return jsonString.toDouble() as T;
//            Long::class -> return jsonString.toLong() as T;
//            Short::class -> return jsonString.toShort() as T;
//            Boolean::class -> return jsonString.toBoolean() as T;
//            else -> return getGson()?.fromJson(jsonString, item);
//        }
    }

    /**
     * Convert Json String to Object of type passed
     */
    fun <T> fromJson(jsonString: String, item: Type): T? {
        return getGson()?.fromJson(jsonString, item);
    }

//    /**
//     * From: https://stackoverflow.com/a/41751144/2480714
//     */
//    class RestDeserializer<T>(targetClass: Class<T>, key: String?) : JsonDeserializer<T> {
//        val targetClass = targetClass
//        val key = key
//        override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): T {
//            val data = json!!.asJsonObject.get(key ?: "")
//            return Gson().fromJson(data, targetClass)
//        }
//    }
}
