data class Shelter(
    val name: String,
    val address: String,
    val phone:String
) {
    val id: String = java.util.UUID.randomUUID().toString()
}