package pgmacdesign.kotlintests.kotlintesting

class EmployeeV2 (company: String) : PersonV4(), PersonActions {
//    override val someNewId: String
//        get() = super.someNewId

    override val someNewId = (firstName + " " + lastName + ", " + company)

    override fun wearClothes() {
        println("Employees must Wear clothes yo!")
    }

    override fun ageByOneYear() {
        this.age++;
    }
}

class Student(school : String) : PersonV4(), PersonActions {
    override val someNewId: String = (firstName) + " " + lastName + ", " + school


    override fun wearClothes() {
        println("Students must Wear clothes yo!")
    }

    override fun ageByOneYear() {
        this.age++;
    }

}