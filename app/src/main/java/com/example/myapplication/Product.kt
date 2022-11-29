package com.example.myapplication

class Product(
    val name: String,
    val brand: String,
    val bar_code: String,
    val quantity: String,
    val nutriscore: String,
    val cover_url: String,
    val sold_locations: List<String>,
    val ingredients: List<String>,
    val allergens: List<String>,
    val additives: List<String>,
) {
    fun getNutriscoreDrawable(): Int {
        return when (nutriscore) {
            "A" -> R.drawable.nutriscore_a
            "B" -> R.drawable.nutriscore_b
            "C" -> R.drawable.nutriscore_c
            "D" -> R.drawable.nutriscore_d
            "E" -> R.drawable.nutriscore_e
            else -> throw Exception("Nutriscore not found")
        }
    }
}