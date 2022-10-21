package com.example.myapplication

class Product(
    val name: String,
    val brand: String,
    val bar_code: String,
    val quantity: String,
    val nutriscore: String,
    val img: String,
    val sold_locations: List<String>,
    val ingredients: List<String>,
    val allergens: List<String> = listOf(),
    val additives: List<String> = listOf(),
) {
    fun getNutriscoreDrawable(): Int {
        return when (nutriscore) {
            "a" -> R.drawable.nutriscore_a
            "b" -> R.drawable.nutriscore_b
            "c" -> R.drawable.nutriscore_c
            "d" -> R.drawable.nutriscore_d
            "e" -> R.drawable.nutriscore_e
            else -> throw Exception("Nutriscore not found")
        }
    }
}