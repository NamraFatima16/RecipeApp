package ie.setu.recipeapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ie.setu.recipeapp.R
import ie.setu.recipeapp.adapters.RecipeAdapter
import ie.setu.recipeapp.databinding.ActivityListRecipeBinding
import ie.setu.recipeapp.main.MainApp
import timber.log.Timber.i

class ListRecipeActivity : AppCompatActivity(){

 lateinit var app: MainApp
 private lateinit var binding: ActivityListRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        app = application as MainApp


        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = RecipeAdapter(app.recipes)

    }
}

