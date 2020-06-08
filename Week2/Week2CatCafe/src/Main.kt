fun main() {
    val cafeController = CafeController()

    println("----------")
    cafeController.printNumberOfAdoptions()
    println("----------")
    cafeController.printUnsponsoredCats()
    println("----------")
    cafeController.printSponsoredCats()
    println("----------")
    cafeController.printTopTenSellingItems()
    println("----------")
    cafeController.printTopTenCats()

    cafeController.doSomeTransactions()
    println()
    println("----------")
    cafeController.printTotalCustomers()
    println("----------")
    cafeController.printTotalNumberOfTransactions()
    println("----------")
    cafeController.printTopTenCats()
    println()
    println("Receipt example:")
    println()
    val receipt = cafeController.transactionsList[1]
    receipt.printTicket()

}