import java.util.*

open class Person(val name: String, val lastName: String, val phone: String, val email: String) {

    val id: String = UUID.randomUUID().toString()

    fun fullName(): String {
        return "$name $lastName"
    }

    override fun toString(): String {
        return "${this.javaClass.name}(id=$id, name=$name, lastName=$lastName, phone=$phone, email=$email)"
    }

}