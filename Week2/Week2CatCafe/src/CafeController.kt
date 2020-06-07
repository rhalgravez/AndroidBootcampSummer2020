class CafeController {

    private lateinit var roberto: Person
    private lateinit var karen: Person
    private lateinit var manuel: Person
    private lateinit var carol: Person
    private lateinit var daniel: Person
    private lateinit var monica: Person
    private lateinit var arturo: Person
    private lateinit var mariela: Person
    private lateinit var andres: Person
    private lateinit var erika: Person

    private lateinit var cashier: Employee
    private lateinit var barista: Employee
    private lateinit var server: Employee

    private lateinit var petFinder: Shelter
    private lateinit var catsLair: Shelter

    private lateinit var garfield: Cat
    private lateinit var tom: Cat
    private lateinit var sylvester: Cat
    private lateinit var pinkPanther: Cat

    private lateinit var lionO: Cat
    private lateinit var panthro: Cat
    private lateinit var tygra: Cat
    private lateinit var cheetara: Cat
    private lateinit var wilyKit: Cat
    private lateinit var wilyKat: Cat

    init {
        createPersonsAndEmployees()
        createSheltersAndCats()


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


        garfield    = Cat("Garfield", "Exotic Shorthair", "m", petFinder.id)
        tom         = Cat("Tom", "Tuxedo cat", "m", petFinder.id)
        sylvester   = Cat("Sylvester","Tuxedo cat", "m", petFinder.id )
        pinkPanther = Cat("The Pink Panther", "Panther...pink", "m", petFinder.id)

        lionO       = Cat("Lion-O", "lion", "m", catsLair.id)
        panthro     = Cat("Panthro", "Panther", "m", catsLair.id)
        tygra       = Cat("Tygra", "tiger", "f", catsLair.id)
        cheetara    = Cat("Cheetara", "Cheetah", "m", catsLair.id)
        wilyKit     = Cat("WilyKit", "Wildcat", "f", catsLair.id)
        wilyKat     = Cat("WilyKat", "Wildcat", "m", catsLair.id)
    }
}