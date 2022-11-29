package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val products = mutableListOf<Product>()

        val product = Product(
            "Petits pois et carottes",
            "Cassegrain",
            "3083680085304",
            "400 g (280 g net égoutté)",
            "a",
            "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            listOf("France", "Japon", "Suisse"),
            listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"),
            emptyList(),
            emptyList()
        )

        for (i in 0..5) {
            products.add(product)
        }

        findViewById<RecyclerView>(R.id.list).apply {
            layoutManager = LinearLayoutManager(this@ProductListActivity,)
            adapter = ListAdapter(products)
        }
    }

    class ListAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductViewHolder>() {

        override fun getItemCount(): Int = products.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            return ProductViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.product_list_item, parent, false
                )
            )
        }

        override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
            holder.updateProduct(
                products[position]
            )
        }
    }

    class ProductViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private val productNameTextView = v.findViewById<TextView>(R.id.name)
        private val productBrandTextView = v.findViewById<TextView>(R.id.brand)
        private val productCoverImageView = v.findViewById<ImageView>(R.id.cover)
        private val currentActivity = v.context

        fun updateProduct(product: Product) {
            productNameTextView.text = product.name
            productBrandTextView.text = product.brand

            Glide.with(currentActivity)
                .load(product.cover_url)
                .into(productCoverImageView)
        }
    }
}