package com.example.myapplication

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
//edouard@marquez.cool

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product)

        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar_background))

        Toast.makeText(applicationContext,"Hello World",Toast.LENGTH_SHORT).show()

        if (BuildConfig.DEBUG) {
            Log.v("MainActivity","Hello World")
        }

        val product = Product(
            "Petits pois et carottes",
            "Cassegrain",
            "3083680085304",
            "400 g (280 g net égoutté)",
            "a",
            "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            listOf("France", "Japon", "Suisse"),
            listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"),
        )

        setItemText(R.id.product_name, R.string.product_name, product.name)
        setItemText(R.id.brand, R.string.brand, product.brand)
        setItemText(R.id.bar_code, R.string.bar_code, product.bar_code)
        setItemText(R.id.quantity, R.string.quantity, product.quantity)

        setItemText(R.id.ingredients, R.string.ingredients, product.ingredients.joinToString(", "))
        setItemText(R.id.allergen, R.string.allergens, product.allergens.joinToString(", "))
        setItemText(R.id.additives, R.string.additives, product.additives.joinToString(", "))
        setItemText(R.id.sold_locations, R.string.sold_locations, product.sold_locations.joinToString(", "))

    }

    fun setItemText(idView: Int, idString: Int,  text: String) {
        val string = getString(idString, if (text.isEmpty()) "Ø" else text)
        val spannable = SpannableString(string)

        if (string.indexOf(":") != -1) {
            spannable.setSpan(StyleSpan(Typeface.BOLD), 0, string.indexOf(":") + 1, 0)
        }

        findViewById<TextView>(idView).text = spannable
    }
}