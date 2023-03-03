package ie.setu.recipeapp.models

data class RecipeModel(var title: String = "",
                        var description: String = "",
                       var servings: Int = 0,
                       var cookingTime: Int = 0,
                       var estimatedCost: Double = 0.0,
                       var numberOfIngeredients: Int = 0,
                       var recipe: String = ""
)
//var title: String = "",
//var description: String = "",
//val numberOfIngeredients: Int ,
//val servings: Int,
//val cookingTime: Int,
//var recipe: String = "",
//val estimatedCost: Double,
//var Ingredients: Array<String>