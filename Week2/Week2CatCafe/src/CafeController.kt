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

    init {
        createPersonsAndEmployees()
        createSheltersAndCats()
        createProducts()
        sponsorCats()

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

//        petFinder.takeCareOf(listOf(garfield, tom, sylvester, pinkPanther))
        catsLair.takeCareOf(listOf(lionO, panthro, tygra, cheetara, wilyKit, wilyKat, snarf, garfield, tom, sylvester, pinkPanther))
    }

    private fun createProducts() {
        cafeAmericano       = Product("Cafe Americano", 7.0)
        cafeLatte           = Product("Cafe Latte", 5.50)
        expressoMachiato    = Product("Espresso Macchiato", 7.50)
        blondeRoast         = Product("Blonde Roast", 8.00)
        plainBagel          = Product("Plain Bagel", 2.00)
        butterCroissant     = Product("Butter Croissant", 2.00)
        water               = Product("Water", 5.50)
    }

    private fun sponsorCats() {
        snarf.sponsorships.add(roberto)
        snarf.sponsorships.add(manuel)
        snarf.sponsorships.add(mariela)
        snarf.sponsorships.add(erika)
        panthro.sponsorships.add(roberto)
    }
}