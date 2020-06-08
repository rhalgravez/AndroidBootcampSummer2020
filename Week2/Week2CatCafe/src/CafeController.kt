class CafeController {

    private lateinit var roberto:   Person
    private lateinit var karen:     Person
    private lateinit var manuel:    Person
    private lateinit var carol:     Person
    private lateinit var daniel:    Person
    private lateinit var monica:    Person
    private lateinit var arturo:    Person
    private lateinit var mariela:   Person
    private lateinit var andres:    Person
    private lateinit var erika:     Person

    private lateinit var cashier:   Employee
    private lateinit var barista:   Employee
    private lateinit var server:    Employee

     lateinit var petFinder: Shelter
     lateinit var catsLair:  Shelter

    private lateinit var garfield:      Cat
    private lateinit var tom:           Cat
    private lateinit var sylvester:     Cat
    private lateinit var pinkPanther:   Cat

    private lateinit var lionO:     Cat
    private lateinit var panthro:   Cat
    private lateinit var tygra:     Cat
    private lateinit var cheetara:  Cat
    private lateinit var wilyKit:   Cat
    private lateinit var wilyKat:   Cat
    private lateinit var snarf:   Cat

    private lateinit var cafeAmericano:     Product
    private lateinit var cafeLatte:         Product
    private lateinit var expressoMachiato:  Product
    private lateinit var blondeRoast:       Product
    private lateinit var plainBagel:        Product
    private lateinit var butterCroissant:   Product
    private lateinit var water:             Product

    private lateinit var productsList: List<Product>

     var productsOnSale  = mutableMapOf<String, Product>()
     var productsSold    = mutableMapOf<String, Int>()

    init {
        createPersonsAndEmployees()
        createSheltersAndCats()
        createProducts()
        sponsorCats()

    }

    fun sale(item: String, quantity: Int): Boolean {
        val product = productsOnSale[findProductId(item)] ?: return false

        var inventory = product.quantity

        if ((inventory - quantity) < 0 ) {
            return false
        }
        var sales = productsSold[product.id] ?: return false
        sales += quantity
        productsSold[product.id] =  sales

        product.quantity -= quantity
        productsOnSale[product.id] = product
        return true
    }

    fun transaction(items: List<Pair<String, Int>>, customer:Person, cats: List<Cat>): Receipt {
        val itemsSold = mutableSetOf<Pair<Product,Int>>()

        for ((item, quantity) in items) {
            if (sale(item, quantity)) {
                val product = productsList.find { it.name == item }!!
                itemsSold.add(Pair(product, quantity))
            }
        }

        return Receipt(customer, itemsSold, cats)
    }

    fun doSomeTransactions() {
        val receipt1 = transaction(listOf(Pair("Cafe Americano", 3), Pair("Water", 1)), roberto, listOf())
        val receipt2 = transaction(listOf(Pair("Espresso Macchiato", 1)), karen, listOf(wilyKat))
        val receipt3 = transaction(listOf(Pair("Water", 1)), andres, listOf())
        transactions.add(receipt1)
//        receipt1.printTicket()
        transactions.add(receipt2)
        receipt3.printTicket()
        transactions.add(receipt3)
    }

    fun findProductId(name: String): String {
        return productsList.find { it.name == name }?.id ?: ""
    }

    private fun createPersonsAndEmployees() {
        roberto = Person("Roberto", "Halgravez", "662-122-3812",
                        "r.halgravez@gmail.com")
        karen   = Person("Karen", "Acosta", "614-456-7893",
                        "karen.acosta@hotmail.com")
        manuel  = Person("Manuel", "Gutierrez", "551-5568974",
                        "mgutierrez@gmail.com")
        carol   = Person("Carol", "Villalobos", "627-214-4569",
                        "villalobosc@hotmail.com")
        daniel  = Person("Daniel", "Acosta", "656-420-3663",
                        "daniel90@hotmail.com")
        monica  = Person("Monica", "Solis", "627-123-7854",
                        "msmonica@gmail.com")
        arturo  = Person("Arturo", "Coda", "662-122-8941",
                        "codaA@gmail.com")
        mariela = Person("Mariela", "Licon", "14-941-7402",
                        "marylicon@hotmail.com")
        andres  = Person("Andres", "Castro", "662-879-9630",
                        "andrcastro@gmail.com")
        erika   = Person("Erika", "Proal", "551-552-9874",
                            "eproal@gmail.com")

        cashier = Employee(erika, "123-456-789", "25-02-2015", 4000.0)
        barista = Employee(andres, "987-456-123", "3-02-2015", 3000.0)
        server  = Employee(mariela, "456-321-987", "04-04-2015", 3000.0)
    }

    private fun createSheltersAndCats() {
        petFinder   = Shelter("Pet Finder", "P. Sherman, 42 Wallaby", "999-987-6321")
        catsLair    = Shelter("Cats Lair", "742 Evergreen Terrace", "654-852-9630")


        garfield    = Cat("Garfield", "Exotic Shorthair", "m")
        tom         = Cat("Tom", "Tuxedo cat", "m")
        sylvester   = Cat("Sylvester","Tuxedo cat", "m")
        pinkPanther = Cat("The Pink Panther", "Panther...pink", "m")

        lionO       = Cat("Lion-O", "lion", "m")
        panthro     = Cat("Panthro", "Panther", "m")
        tygra       = Cat("Tygra", "tiger", "f")
        cheetara    = Cat("Cheetara", "Cheetah", "m")
        wilyKit     = Cat("WilyKit", "Wildcat", "f")
        wilyKat     = Cat("WilyKat", "Wildcat", "m")
        snarf       = Cat("Snarf", "Snarf", "m")

        petFinder.takeCareOf(listOf(garfield, tom, sylvester, pinkPanther))
        catsLair.takeCareOf(listOf(lionO, panthro, tygra, cheetara, wilyKit, wilyKat, snarf, garfield, tom, sylvester, pinkPanther))
    }

    private fun createProducts() {
        cafeAmericano       = Product("Cafe Americano", 7.0, 25)
        cafeLatte           = Product("Cafe Latte", 5.50, 25)
        expressoMachiato    = Product("Espresso Macchiato", 7.50, 23)
        blondeRoast         = Product("Blonde Roast", 8.00, 20)
        plainBagel          = Product("Plain Bagel", 2.00, 15)
        butterCroissant     = Product("Butter Croissant", 2.00, 20)
        water               = Product("Water", 5.50, 17)

        productsList = listOf(cafeAmericano.copy(), cafeLatte.copy(), expressoMachiato.copy(),
            blondeRoast.copy(), plainBagel.copy(), butterCroissant.copy(), water.copy()
        )

        productsSold[cafeAmericano.id]      = 0
        productsSold[cafeLatte.id]          = 0
        productsSold[expressoMachiato.id]   = 0
        productsSold[blondeRoast.id]        = 0
        productsSold[plainBagel.id]         = 0
        productsSold[butterCroissant.id]    = 0
        productsSold[water.id]              = 0

        productsOnSale[cafeAmericano.id]    = cafeAmericano
        productsOnSale[cafeLatte.id]        = cafeLatte
        productsOnSale[expressoMachiato.id] = expressoMachiato
        productsOnSale[blondeRoast.id]      = blondeRoast
        productsOnSale[plainBagel.id]       = plainBagel
        productsOnSale[butterCroissant.id]  = butterCroissant
        productsOnSale[water.id]            = water
    }

    private fun sponsorCats() {
        snarf.sponsorships.add(roberto)
        snarf.sponsorships.add(manuel)
        snarf.sponsorships.add(mariela)
        snarf.sponsorships.add(erika)
        panthro.sponsorships.add(roberto)
    }

    fun topTenProducts(): List<Triple<Product, Int, Double>> {
        val reverseOrder = productsSold.toList().sortedBy { (_, value) -> value}.reversed()
        val descendngList = mutableListOf<Triple<Product, Int, Double>>()
        for ((id, quantity) in reverseOrder) {
            val product = productsOnSale.getValue(id)
            val grossSale = product.price * quantity
            descendngList.add(Triple(product, quantity, grossSale))
        }
        return descendngList.take(10)
    }
}