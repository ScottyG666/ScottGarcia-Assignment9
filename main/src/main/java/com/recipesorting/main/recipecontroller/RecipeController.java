package com.recipesorting.main.recipecontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipesorting.main.recipedtoservices.RecipeOrganizationService;

@RestController
public class RecipeController {
	//here i am hardcoding the file that we are pulling the CSV's from, where is would otherwise
	//be pulled from  a request
	private static final String FILE_NAME = "recipe.txt";
	
	//this method filters the requested list of recipes based on the parameters as described in the
	//names of this Class's methods
	@Autowired
	RecipeOrganizationService recipeOrganizer;

	@GetMapping("/gluten-free")
	public List<String> returnGlutenFreeRecipes () {
		return recipeOrganizer.getGlutenFreeRecipes(FILE_NAME);
	}

	@GetMapping("/vegan")
	public List<String> returnVeganRecipes () {
		return recipeOrganizer.getVeganRecipes(FILE_NAME);
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<String> returnVeganAndGlutenFreeRecipes () {
		return recipeOrganizer.getVeganAndGlutenFreeRecipes(FILE_NAME);
	}

	@GetMapping("/vegetarian")
	public List<String> returnVegetarianRecipes () {
		return recipeOrganizer.getVegetarianRecipes(FILE_NAME);
	}

	@GetMapping("/all-recipes")
	public List<String> returnAllRecipes () {
		return recipeOrganizer.getAllRecipes(FILE_NAME);
	}
	
}
