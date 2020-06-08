import java.time.LocalDateTime

data class Receipt(
    val customer: Person, // Patron or Employee
    val items: Set<Pair<Product, Int>>, //product, its quantity
    val catsAdopted: List<Cat>
) {

    private val id: String = java.util.UUID.randomUUID().toString()
    private val date: LocalDateTime = LocalDateTime.now()

    private val itemDescriptionList: List<String>
        get() {
            val descriptions = mutableListOf<String>()
            for ((item, quantity) in items) {
                var description = "*\tId: ${item.id}"
                description += "\n*\tDescription: ${item.name}"
                description += "\n*\tQuantity: ${quantity}"
                description += "\n*\tPrice: ${item.price}"
                descriptions.add(description)
            }
            return descriptions
        }

    private val discount  = .15

    private val subTotal: Double
        get() {
            var sum= 0.0
            for ((item, quantity) in items) {
                sum += item.price * quantity
            }
            if ((catsAdopted.size > 0) && (customer is Employee)) { // NOTE: The type casting is not working
                return sum - (sum * discount)
            }
            return sum
        }

    private val tax: Double
        get() {
            val taxValue = 0.08
            return subTotal * taxValue
        }

    private var tip = 0.0

    private  val total: Double
        get() {
            return subTotal + tax + tip
        }

    private  val totalFormat: String
        get() {
            return "%.2f".format(total)
        }

    private val catDescriptionList: List<String>
        get() {
            val descriptions = mutableListOf<String>()
            for (cat in catsAdopted) {
                var description = "*\tId: ${cat.id}"
                description += "\n*\tName: ${cat.name}"
                description += "\n*\tBreed: ${cat.breed}"
                description += "\n*\tSex: ${cat.gender}"
                descriptions.add(description)
            }
            return descriptions
        }

    fun printTicket() {
        println("********************Cat Cafe*****************************")
        println("* Receipt Id: $id")
        println("* Client Name: ${customer.fullName()}")
        println("* Client email: ${customer.email}")
        println("* created at: $date")
        println("*")
        println("* Items:")
        for (description in itemDescriptionList) {
            println("$description")
            println("*")
        }
        println("* Sub total: $subTotal")
        println("* Tax: $tax")
        println("* Tip: $tip")
        println("* Total: $totalFormat")
        if(catsAdopted.size >0 ) {
            println("* Cats:")
            for (description in catDescriptionList) {
                println("$description")
            }
        }
        println("*********************************************************")
    }
}
