package ie.setu.recipeapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import ie.setu.recipeapp.R
import ie.setu.recipeapp.databinding.ActivityAddingRecipesBinding
import ie.setu.recipeapp.databinding.ActivityRecipeAppBinding
import ie.setu.recipeapp.main.MainApp
import ie.setu.recipeapp.models.RecipeModel
import timber.log.Timber.i

class AddingRecipesActivity : AppCompatActivity() {

    private lateinit var binding1: ActivityAddingRecipesBinding
    var recipe = RecipeModel()
    lateinit var app1: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityAddingRecipesBinding.inflate(layoutInflater)
        setContentView(binding1.root)

        app1 = application as MainApp

        i("adding recipe started..")
        binding1.addrecipetoarray.setOnClickListener() {



            recipe.title = binding1.recipeTitle.text.toString()
            recipe.description = binding1.recipeDescription.text.toString()
            recipe.servings = binding1.serving.text.toString().toInt()
            recipe.cookingTime = binding1.cookingTime.text.toString().toInt()
            recipe.estimatedCost = binding1.cost.text.toString().toDouble()
            recipe.numberOfIngeredients = binding1.numOfIng.text.toString().toInt()
            recipe.recipe = binding1.recipe.text.toString()




            //need more checks
            if (recipe.title.isNotEmpty()) {
                app1.recipes.add(recipe.copy())
                i("Add button pressed: ${recipe}")

                for (i in app1.recipes.indices) {
                    i("Recipe[$i]:${this.app1.recipes[i]}")
                }
            } else {
                Snackbar.make(it, "Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
            val launchHome = Intent(this, RecipeAppActivity::class.java)
            startActivity(launchHome)


        }
    }
}