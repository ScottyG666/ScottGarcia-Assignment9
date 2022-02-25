package com.recipesorting.main.recipedtoservices;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipesorting.main.recipedtopojo.RecipeDTO;

//This class is taking in the RecipeDTO list from the RecipeFileExtraction method
//And sorting the resulting List<String> based on the parameters of the methods name
@Service
public class RecipeOrganizationService {
	
	
	@Autowired
	RecipeFileExtraction fileExtractor;
	
	public List<String> getAllRecipes (String fileName) {
		
		//The listOfRecipeDTOFromFile returns a List<RecipeDTO> that is being streamed in order
			//to enact the *toString()* method, before collecting ALL RECIPES to a list
		return fileExtractor.listOfRecipeDTOFromFile(fileName).stream()
													   		  .map(RecipeDTO::toString)
															  .collect(Collectors.toList());
	}
	
	//performs the same function as *getAllRecipes but filters for recipes where the variable
		//GLUTEN FREE is set to true before enacting the *toString()* method
	public List<String> getGlutenFreeRecipes (String fileName) {
		return fileExtractor.listOfRecipeDTOFromFile(fileName).stream()
															  .filter(RecipeDTO::getGlutenFree)
															  .map(RecipeDTO::toString)
															  .collect(Collectors.toList());
	}
	
	//performs the same function as *getAllRecipes but filters for recipes where the variable
		//VEGAN is set to true before enacting the *toString()* method
	public List<String> getVeganRecipes (String fileName) {
		return fileExtractor.listOfRecipeDTOFromFile(fileName).stream()
															  .filter(RecipeDTO::getVegan)
															  .map(RecipeDTO::toString)
															  .collect(Collectors.toList());
	}
	
	//performs the same function as *getAllRecipes but filters for recipes where the variable
		//VEGAN AND GLUTEN FREE is set to true before enacting the *toString()* method
	public List<String> getVeganAndGlutenFreeRecipes (String fileName) {
		return fileExtractor.listOfRecipeDTOFromFile(fileName).stream()
															  .filter(RecipeDTO::getGlutenFree)
															  .filter(RecipeDTO::getVegan)
															  .map(RecipeDTO::toString)
															  .collect(Collectors.toList());
	}
	
	//performs the same function as *getAllRecipes but filters for recipes where the variable
		//VEGETARIAN is set to true before enacting the *toString()* method
	public List<String> getVegetarianRecipes (String fileName) {
		return fileExtractor.listOfRecipeDTOFromFile(fileName).stream()
															  .filter(RecipeDTO::getVegetarian)
															  .map(RecipeDTO::toString)
															  .collect(Collectors.toList());
	}
	
	
}
