data class Cat(
    val name: String,
    val breed: String,
    val gender: String,
    val sponsorships: MutableSet<Person> = mutableSetOf()
) {
    val id: String = java.util.UUID.randomUUID().toString()

    var shelterID: String? = null

    fun wasAdopted() {
        sponsorships.clear()
    }
}