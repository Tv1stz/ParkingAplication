data class Car(
    val brand: String,
    val color: String,
    val number: String,
    val owner: Owner
) {
    override fun toString(): String {
        return "$brand $color $number ${owner.name} ${owner.lastname}"
    }
}