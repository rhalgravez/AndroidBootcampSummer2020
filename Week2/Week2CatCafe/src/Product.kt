import java.util.*

data class Product(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val price: Double
) {
    constructor(name: String, price: Double): this(UUID.randomUUID().toString(), name, price)
}
