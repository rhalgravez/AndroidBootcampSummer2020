data class Shelter(
    val name: String,
    val address: String,
    val phone:String,
    val cats: MutableSet<Cat> = mutableSetOf(),
    val catsAdopted: MutableSet<Cat> = mutableSetOf()
) {
    val id: String = java.util.UUID.randomUUID().toString()
}