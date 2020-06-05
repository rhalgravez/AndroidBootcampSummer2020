data class Person (var name:String, var lastName: String, var phone: String, var email: String) {

    private companion object {
         var personID = 0
         fun generateID(): Int {
            personID += 1
            return personID
        }
    }

    val id: Int

    init {
        this.id = generateID()
    }

}