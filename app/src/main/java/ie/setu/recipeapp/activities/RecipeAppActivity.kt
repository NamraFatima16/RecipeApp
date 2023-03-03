package ie.setu.recipeapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import ie.setu.recipeapp.R
import ie.setu.recipeapp.databinding.ActivityAddingRecipesBinding
import ie.setu.recipeapp.databinding.ActivityRecipeAppBinding

import ie.setu.recipeapp.main.MainApp
import ie.setu.recipeapp.models.RecipeModel
import timber.log.Timber
import timber.log.Timber.i

class RecipeAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeAppBinding
    lateinit var app: MainApp


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        app = application as MainApp
        i("Recipe Activity started...")
        binding.addrecipebtn.setOnClickListener() {

            val launcherAdd = Intent(this, AddingRecipesActivity::class.java)
            startActivity(launcherAdd)}

        binding.listrecipebtn.setOnClickListener(){
            val launcherList = Intent(this,ListRecipeActivity::class.java)
            startActivity(launcherList) }
    }

}