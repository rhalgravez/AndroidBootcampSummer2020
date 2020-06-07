data class Shelter(
    val name: String,
    val address: String,
    val phone:String

) {

    val id: String = java.util.UUID.randomUUID().toString()

    private val cats: MutableSet<Cat> = mutableSetOf()

    private val catsAdopted: MutableSet<Cat> = mutableSetOf()

    fun takeCareOf(cats: Collection<Cat>) {
        for (cat in cats) {
            if (cat.shelterID == null) {
                cat.shelterID = id
               this.cats.add(cat)
            }
        }
    }

    fun numberOfAdoptions(): Int {
        return catsAdopted.size
    }

    fun numberOfCats(): Int {
        return cats.size
    }

    fun unsponsoredCats(): Set<Cat> {
        val unsponsored = cats.filter { it.sponsorships.size == 0 }
        return unsponsored.toSet()
    }

    fun sponsoredCats(): Set<Cat> {
        val sponsored = cats.filter { it.sponsorships.size != 0 }
        return sponsored.toSet()
    }
}