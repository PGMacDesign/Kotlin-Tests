package pgmacdesign.kotlintests.kotlintesting

import java.util.*

fun sampleVars(){
    //Val is final
    val name : String = "bob";
    val age : Int = 2;

    //Var is not final
    var weight : Double = 2.2123123;
    var myFlt : Float = 2.1F;
    var lst : List<String>;

    //To make it nullable, use question mark
    var language : String? = "kotlin";
    //This line is not permissible without defining with question mark
    language = null;

    //String templates
    println("Hello, Pat and ${name}, good to meet you!");
    println("Hello, My Age is: ${10+10+10}.");

    //Arrays
    val arr = arrayOf("one", "two", "three");
    //Prints out "one"
    print(arr[0]);


//    val objArray : SitesResponseBody.SitesData = arrayOf(SiteUtilities.getSingleSite())

    //Standard if else logic
    print("Enter your age");
    //Commented out for now so I can run without breaking things
//    var num = readLine()?.toIntOrNull() ?: 0 //readLine() is like the Scanner() class in Java, pull from input console
    var ageFromConsole : String? = "1"; //readLine() is like the Scanner() class in Java, pull from input console
    if(ageFromConsole == null){
        ageFromConsole = "0"
    }
//    val x= readLine()?.toIntOrNull() ?: 0
//    val age2 = Integer.valueOf(ageFromConsole);
//    if(age2 > 21) {
//        println("you can legally drink in the USA");
//    } else {
//        println("You cannot legally drink in the USA");
//    }

    //Ternary Operator logic:
    val canDrinkStr : String = if(age > 21)
        "you can legally drink in the USA" else
        "You cannot legally drink in the USA"
    println(canDrinkStr);

    var cal : Calendar = Calendar.getInstance();
    var dayOfWeek : Int = cal.get(Calendar.DAY_OF_WEEK);
    //When Operator (switch)
    var toPrint1 : String?;
    when(dayOfWeek){
        Calendar.MONDAY -> {
            toPrint1 = "Monday"
            println("Looks like someone has a case of the Mondays!");
        };
        Calendar.TUESDAY -> toPrint1 = "Tuesday";
        Calendar.WEDNESDAY -> toPrint1 = "Wednesday";
        Calendar.THURSDAY -> toPrint1 = "Thursday";
        Calendar.FRIDAY -> toPrint1 = "Friday";
        Calendar.SATURDAY, Calendar.SUNDAY -> toPrint1 = "The weekend!"; //Combining 2, this is like adding a break after the second one
        //Else is the default
        else -> {
            println("Else hit, using default of unknown");
            toPrint1 = "Unknown!";
        }
    }

    //Can also use a when switch statement as a ternary operator:
    val dayOfWeek2 = when (dayOfWeek){
        Calendar.SUNDAY -> "Sunday";
        Calendar.MONDAY -> "Monday";
        Calendar.TUESDAY -> "Tuesday";
        Calendar.WEDNESDAY -> "Wednesday";
        Calendar.THURSDAY -> "Thursday";
        Calendar.FRIDAY -> "Friday";
        Calendar.SATURDAY -> "Saturday";
        //Else is the default
        else -> null;
    }

    //Can also use a when switch statement as a ternary operator (open style below):
    val dayOfWeek3 = when {
        dayOfWeek == Calendar.SUNDAY -> "Sunday";
        dayOfWeek == Calendar.MONDAY -> "Monday";
        dayOfWeek == Calendar.TUESDAY -> "Tuesday";
        dayOfWeek == Calendar.WEDNESDAY -> "Wednesday";
        dayOfWeek == Calendar.THURSDAY -> "Thursday";
        dayOfWeek == Calendar.FRIDAY -> "Friday";
        dayOfWeek == Calendar.SATURDAY -> "Saturday";
        //Else is the default
        else -> null;
    }
    //These should be the same
    println("The current day of the week is ${toPrint1}");
    println("The current day of the week is ${dayOfWeek2}");

    //Some for data models for use in for loops:
    val ia : IntArray = intArrayOf(1, 2, 3, 4, 5);   //Defined Integer array
    val lst1 = listOf<String>("Kotlin", "Java", "Python", "C#");
    val myMap = mapOf(1 to "Kotlin", 2 to "Java", 3 to "Python", 4 to "C#");

    //Loop through int list:
    for(a in ia){
        println("Value: $a");
    }

    //Loop through String list
    for(str in lst1){
        println("Language: $str");
    }

    //Loop through Map
    for((key, value) in myMap){
        println("Item: $key --> $value");
    }

    //Loop through integers of values 1-9
    for(i in 1..9){
        //Will print 1 through 9 (inclusive on 9)
        println(i)
    }
    for(i in 1 until 9){
        //Will print 1 through 8 (exclusive on 9)
        println(i)
    }
    for(i in 1 until 9 step 2){
        //Will print 1, 3, 5, 7 (skipping every other one with the step 2)
        println(i)
    }
    for(i in 9 downTo 1){
        //Will print 9 - 1 inclusive
        println(i);
    }

    //Extension function, not in Java! Note that most of the Kotlin extension functions are built on top of the Java data models
    val str2 = "How are You?"
    println(str2.getEmotion())
    val x10 = 1;
    println(x10.add10());

    //Object Instantiation
    val per: Person = Person();
    per.age = 2;
    per.firstName = "first";
    per.lastName = "last";
    println("Person: ${per.firstName} ${per.lastName} has attained an age of ${per.age}.");

//    val personJSONString : String = Gson().toJson(per, Person().javaClass);
    print("Using toJson() within Person class: ")
    println(per.toJson());
    print("Person using KotlinUtilities: ")
    var str: String = KotlinUtilities().toJson(per)
    println(str);
    var per2 = KotlinUtilities().fromJson(str, Person::class.java)
    if (per2 is Person){ //Same as instanceof from Java
//        per2 = per2 as Person;
        print("Cast worked. Printing person data: ");
        println("Full Name is ${per2.firstName} ${per2.lastName} and age is ${per.age}")
    } else {
        println("Per2 is not a Person")
    }

//    val finalString : String = "some final string here"
            //Not an option as of now
//    var usingCasting = KotlinUtilities().fromJson(finalString, String::class.java)
//    println("UsingCasting == ${usingCasting}")

    val p3 = PersonV3(lastName = "lastName");
    println("P3 info: First and Last Name is ${p3.firstName} ${p3.lastName} and someNewId == ${p3.someNewId}");

    val p33 = PersonV3(22);
    println("The above instantiation should have printed the 'first', 'second', and 'third', texts due to how the constructors work.");

    val emp: Employee =  Employee(company="XYZ Stuff");
    println("Employee's name and company is: ${emp.someNewId}")

    val e1 = EmployeeV2("Some Company")

    //Abstract classes and Interfaces (See PersonV4 class)
    val s1 = Student("Some School Elementary")

    println("e1 ID == ${e1.someNewId}")
    println("s1 ID == ${s1.someNewId}")

    s1.wearClothes()
    println("S1 age (Before calling method): ${s1.age}")
    s1.ageByOneYear()
    println("S1 age (After calling method): ${s1.age}")

    e1.wearClothes()
    println("e1 age (Before calling method): ${e1.age}")
    e1.ageByOneYear()
    println("e1 age (After calling method): ${e1.age}")

}

fun Int.add10() : Int{
    return (this + 10);
}

fun String.getEmotion() : String{
    return when {
        last() == '!' -> "Exciting"
        last() == '?' -> "Curious"
        last() == '.' -> "Calm"
        else -> "Unidentified"
    };
}