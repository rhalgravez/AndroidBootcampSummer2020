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
    cafeController.printTotalCustomers()
    println("**************")
    cafeController.printTopTenCats()

    val receipt = cafeController.transactionsList[1]
    receipt.printTicket()

}