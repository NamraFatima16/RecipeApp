package ie.setu.recipeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        binding1 = ActivityAddingRecipesBinding.inflate(layoutInflater )
        setContentView(R.layout.activity_adding_recipes)

        app1 = application as MainApp
        i("adding recipe started..")

    }
}