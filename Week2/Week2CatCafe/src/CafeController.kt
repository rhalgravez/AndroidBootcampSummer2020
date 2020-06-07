class CafeController {

    init {
        createPersonsAndEmployees()


    }

    private fun createPersonsAndEmployees() {
        val roberto = Person("Roberto", "Halgravez", "662-122-3812",
                            "r.halgravez@gmail.com")
        val karen   = Person("Karen", "Acosta", "614-456-7893",
                            "karen.acosta@hotmail.com")
        val manuel  = Person("Manuel", "Gutierrez", "551-5568974",
                            "mgutierrez@gmail.com")
        val carol   = Person("Carol", "Villalobos", "627-214-4569",
                            "villalobosc@hotmail.com")
        val daniel  = Person("Daniel", "Acosta", "656-420-3663",
                            "daniel90@hotmail.com")
        val monica  = Person("Monica", "Solis", "627-123-7854",
                            "msmonica@gmail.com")
        val arturo  = Person("Arturo", "Coda", "662-122-8941",
                            "codaA@gmail.com")
        val mariela = Person("Mariela", "Licon", "14-941-7402",
                            "marylicon@hotmail.com")
        val andres  = Person("Andres", "Castro", "662-879-9630",
                            "andrcastro@gmail.com")
        val erika   = Person("Erika", "Proal", "551-552-9874",
                            "eproal@gmail.com")

        val cashier = Employee(erika, "123-456-789", "25-02-2015", 4000.0)
        val barista = Employee(andres, "987-456-123", "3-02-2015", 3000.0)
        val server  = Employee(mariela, "456-321-987", "04-04-2015", 3000.0)
    }
}