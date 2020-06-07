import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Employee(
    name: String,
    lastName: String,
    phone: String,
    email: String,
    val socialSecurityNumber: String,
    var hireDate: String,
    var salary: Double
) : Person(name, lastName, phone, email) {

    constructor(
        person: Person,
        socialSecurityNumber: String,
        hireDate: String,
        salary: Double
    ) :
            this(
                person.name,
                person.lastName,
                person.phone,
                person.email,
                socialSecurityNumber,
                hireDate,
                salary
            )

    fun clockIn() {
        val stringDate = stringLocalDateTime()
        println("Employee ${fullName()} check-in was at: $stringDate")

    }

    fun clockOut(isTimeToGoHome: Boolean = false) {
        if (isTimeToGoHome) {
            val stringDate = stringLocalDateTime()
            println("Employee ${fullName()} check-out at: $stringDate")
        } else {
            println("Sorry but ${fullName()} still have work to do")
        }
    }

    override fun toString(): String {
        return "${this.javaClass.name}(id=$id, name=$name, lastName=$lastName, phone=$phone, email=$email, " +
                "socialSecurityNumber= $socialSecurityNumber, hireDate=$hireDate, salary=$salary)"
    }

    private fun stringLocalDateTime(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss a")

        return current.format(formatter)
    }
}