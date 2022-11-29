package com.example.myapplication

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

//edouard@marquez.cool

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        this.changeActivity()

        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar_background))

        /*Toast.makeText(applicationContext,"Hello World",Toast.LENGTH_SHORT).show()

        if (BuildConfig.DEBUG) {
            Log.v("ProductActivity","Hello World")
        }*/

        val product = Product(
            "Petits pois et carottes",
            "Cassegrain",
            "3083680085304",
            "400 g (280 g net égoutté)",
            "A",
            "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            listOf("France", "Japon", "Suisse"),
            listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"),
            emptyList(),
            emptyList()
        )

        this.setProductInformations(product)
    }

    private fun setProductInformations(product: Product) {
        findViewById<TextView>(R.id.name).applyBoldText(product.name, R.string.product_name)
        findViewById<TextView>(R.id.brand).applyBoldText(product.brand, R.string.brand)
        findViewById<TextView>(R.id.bar_code).applyBoldText(product.bar_code, R.string.bar_code)
        findViewById<TextView>(R.id.quantity).applyBoldText(product.quantity, R.string.quantity)
        findViewById<TextView>(R.id.sold_locations).applyBoldText(product.sold_locations.joinToString(", "), R.string.sold_locations)
        findViewById<TextView>(R.id.ingredients).applyBoldText(product.ingredients.joinToString(", "), R.string.ingredients)
        findViewById<TextView>(R.id.allergens).applyBoldText(product.allergens.joinToString(", "), R.string.allergens)
        findViewById<TextView>(R.id.additives).applyBoldText(product.additives.joinToString(", "), R.string.additives)

        findViewById<ImageView>(R.id.nutriscore).setImageResource(product.getNutriscoreDrawable())

        Glide.with(this).load(product.cover_url).into(findViewById(R.id.cover))
    }

    private fun TextView.applyBoldText(text: String, idString: Int) {
        val string = getString(idString, text.ifEmpty { "Ø" })
        val spannable = SpannableString(string)
        if (string.indexOf(":") != -1) {
            spannable.setSpan(StyleSpan(Typeface.BOLD), 0, string.indexOf(":") + 1, 0)
        }
        this.text = spannable
    }

    private fun changeActivity() {
        val intent = Intent(this, ProductListActivity::class.java)
        startActivity(intent)
    }

}