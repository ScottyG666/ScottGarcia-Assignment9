package com.recipesorting.main.recipedtoservices;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipesorting.main.recipedtopojo.RecipeDTO;

@Service
public class RecipeOrganizationService {

	@Autowired
	RecipeFileExtraction fileExtractor;
	
	public List<String> getGlutenFreeRecipes (String fileName) {
		return fileExtractor.listOfRecipeDTOFromFile(fileName).stream()
															  .filter(RecipeDTO::getGlutenFree)
															  .map(RecipeDTO::toString)
															  .collect(Collectors.toList());
	}
	
	public List<String> getVeganRecipes (String fileName) {
		return fileExtractor.listOfRecipeDTOFromFile(fileName).stream()
															  .filter(RecipeDTO::getVegan)
															  .map(RecipeDTO::toString)
															  .collect(Collectors.toList());
	}
	
	public List<String> getVeganAndGlutenFreeRecipes (String fileName) {
		return fileExtractor.listOfRecipeDTOFromFile(fileName).stream()
															  .filter(RecipeDTO::getGlutenFree)
															  .filter(RecipeDTO::getVegan)
															  .map(RecipeDTO::toString)
															  .collect(Collectors.toList());
	}
	
	public List<String> getVegetarianRecipes (String fileName) {
		return fileExtractor.listOfRecipeDTOFromFile(fileName).stream()
															  .filter(RecipeDTO::getVegetarian)
															  .map(RecipeDTO::toString)
															  .collect(Collectors.toList());
	}
	
	public List<String> getAllRecipes (String fileName) {
		return fileExtractor.listOfRecipeDTOFromFile(fileName).stream()
															  .map(RecipeDTO::toString)
															  .collect(Collectors.toList());
	}
	
}
