package com.example.myapplication

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

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

        findViewById<TextView>(R.id.product_name).text = product.name
        findViewById<TextView>(R.id.brand).text = product.brand
        findViewById<TextView>(R.id.bar_code).text = product.bar_code
        findViewById<TextView>(R.id.quantity).text = product.quantity

        findViewById<TextView>(R.id.ingredients).text = product.ingredients.joinToString(", ")
        findViewById<TextView>(R.id.sold_locations).text = product.sold_locations.joinToString(", ")
        findViewById<TextView>(R.id.allergen).text = product.allergens.joinToString(", ")
        findViewById<TextView>(R.id.additives).text = product.additives.joinToString(", ")

        /*val string = getString(R.string.barcode, "234567865432456789")
        val spannable = SpannableString(string)
        spannable.setSpan(StyleSpan(Typeface.BOLD), 0, string.indexOf(":"), 0)
        setText(spannable)*/

        //edouard@marquez.cool
    }
}