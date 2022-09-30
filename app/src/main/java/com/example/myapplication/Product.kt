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

}