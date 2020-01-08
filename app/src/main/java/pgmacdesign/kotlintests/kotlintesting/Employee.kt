package pgmacdesign.kotlintests.kotlintesting

/**
 * This employee class inherits from the PersonV3 class
 */
class Employee(company: String) : PersonV3() {
//    override val someNewId: String
//        get() = super.someNewId

    override val someNewId = (firstName + " " + lastName + ", " + company)
}