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

            i("Add Button Pressed....")


             var isError = false



            if(binding1.recipeTitle.text.toString().isNotEmpty()){
                recipe.title = binding1.recipeTitle.text.toString()
            }
            else{
                isError = true
                Snackbar.make(it, "Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()

            }

            if(binding1.recipeDescription.text.toString().isNotEmpty()){
                recipe.description = binding1.recipeDescription.text.toString()
            }
            else{
                isError = true
                Snackbar.make(it, "Please Enter a Description", Snackbar.LENGTH_LONG)
                    .show()

            }
            if(binding1.recipe.text.toString().isNotEmpty()){
                recipe.recipe = binding1.recipe.text.toString()
            }
            else{
                isError = true
                Snackbar.make(it, "Please Enter a Recipe", Snackbar.LENGTH_LONG)
                    .show()

            }
            if(binding1.serving.text.toString().isNotEmpty()  ){
                try {
                    recipe.servings = binding1.serving.text.toString().toInt()
                }
                catch (e: NumberFormatException ){
                    isError = true
                    Snackbar.make(it,"Not a Number",Snackbar.LENGTH_LONG)
                        .show()
                }

            }
            else{
                isError = true
                Snackbar.make(it, "Please Enter a Serving number", Snackbar.LENGTH_LONG)
                    .show()

            }


            if(binding1.cookingTime.text.toString().isNotEmpty()  ){
                try {
                    recipe.cookingTime = binding1.cookingTime.text.toString().toInt()
                }
                catch (e: NumberFormatException ){
                    isError = true
                    Snackbar.make(it,"Not a Number",Snackbar.LENGTH_LONG)
                        .show()
                }

            }
            else{
                isError = true
                Snackbar.make(it, "Please Enter a Cooking Time", Snackbar.LENGTH_LONG)
                    .show()

            }

            if(binding1.numOfIng.text.toString().isNotEmpty()  ){
                try {
                    recipe.numberOfIngeredients = binding1.numOfIng.text.toString().toInt()
                }
                catch (e: NumberFormatException ){
                    isError = true
                    Snackbar.make(it,"Not a Number",Snackbar.LENGTH_LONG)
                        .show()
                }

            }
            else{
                isError = true
                Snackbar.make(it, "Please Enter Number Of Ingredients", Snackbar.LENGTH_LONG)
                    .show()

            }

            if(binding1.cost.text.toString().isNotEmpty()  ){
                try {
                    recipe.estimatedCost = binding1.cost.text.toString().toDouble()
                }
                catch (e: NumberFormatException ){
                    isError = true
                    Snackbar.make(it,"Not a Number",Snackbar.LENGTH_LONG)
                        .show()
                }

            }
            else{
                isError = true
                Snackbar.make(it, "Please Enter the Cost", Snackbar.LENGTH_LONG)
                    .show()

            }

            if (!isError ) {

                app1.recipes.add(recipe.copy())
                i("Recipe Added: ${recipe}")

                for (i in app1.recipes.indices) {
                    i("Recipe[$i]:${this.app1.recipes[i]}")
                }
                setResult(RESULT_OK)
                finish()
            }

        }

        binding1.cancelRecipe.setOnClickListener(){

            val launcherCancel =  Intent(this,RecipeAppActivity::class.java)
            startActivity(launcherCancel)
        }



    }
}