import java.util.*

data class Product(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val price: Double,
    var quantity: Int
) {
    constructor(
        name: String,
        price: Double,
        quantity: Int
    ) : this(UUID.randomUUID().toString(), name, price, quantity)
}
