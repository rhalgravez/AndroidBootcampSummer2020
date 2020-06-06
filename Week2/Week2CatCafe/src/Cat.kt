data class Cat(
    val name: String,
    val breed: String,
    val gender: String,
    val shelterID: String,
    val sponsorships: MutableSet<Person> = mutableSetOf()
) {
    val id: String = java.util.UUID.randomUUID().toString()

    fun wasAdopted() {
        sponsorships.clear()
    }
}