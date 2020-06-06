import java.util.*

open class Person(val name:String, val lastName: String, val phone: String, val email: String) {

    val id: String = UUID.randomUUID().toString()
//    val name:String
//    val lastName: String
//    val phone: String
//    val email: String
//
//    constructor(name:String, lastName: String, phone: String, email: String) {
//        this.name = name
//        this.lastName = lastName
//        this.phone = phone
//        this.email = email
//    }

    fun fullName(): String {
        return "$name $lastName"
    }

}