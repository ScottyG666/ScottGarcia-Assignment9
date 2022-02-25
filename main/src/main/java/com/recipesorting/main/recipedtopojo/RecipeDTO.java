package com.recipesorting.main.recipedtopojo;

import org.apache.commons.csv.CSVRecord;

public class RecipeDTO {

	private Integer cookingMinutes;
	private Boolean dairyFree;
	private Boolean glutenFree;
	private String instructions;
	private Double preparationMinutes;
	private Double pricePerServing;
	private Integer readyInMinutes;
	private Integer servings;
	private Double spoonacularScore;
	private String title;
	private Boolean vegan;
	private Boolean vegetarian;
	
	public RecipeDTO (CSVRecord incomingRecipeRecord) {
		this.cookingMinutes = Integer.parseInt(incomingRecipeRecord.get(0));
		this.dairyFree = Boolean.valueOf(incomingRecipeRecord.get(1));
		this.glutenFree = Boolean.valueOf(incomingRecipeRecord.get(2));
		this.instructions = incomingRecipeRecord.get(3);
		this.preparationMinutes = Double.valueOf(incomingRecipeRecord.get(4));
		this.pricePerServing = Double.valueOf(incomingRecipeRecord.get(5));
		this.readyInMinutes = Integer.valueOf(incomingRecipeRecord.get(6));
		this.servings = Integer.valueOf(incomingRecipeRecord.get(7));
		this.spoonacularScore = Double.valueOf(incomingRecipeRecord.get(8));
		this.title = incomingRecipeRecord.get(9);
		this.vegan = Boolean.valueOf(incomingRecipeRecord.get(10));
		this.vegetarian = Boolean.valueOf(incomingRecipeRecord.get(11));
	}
	
	public Integer getCookingMinutes() {
		return cookingMinutes;
	}
	public void setCookingMinutes(Integer cookingMinutes) {
		this.cookingMinutes = cookingMinutes;
	}
	public Boolean getDairyFree() {
		return dairyFree;
	}
	public void setDairyFree(Boolean dairyFree) {
		this.dairyFree = dairyFree;
	}
	public Boolean getGlutenFree() {
		return glutenFree;
	}
	public void setGlutenFree(Boolean glutenFree) {
		this.glutenFree = glutenFree;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public Double getPreparationMinutes() {
		return preparationMinutes;
	}
	public void setPreparationMinutes(Double preparationMinutes) {
		this.preparationMinutes = preparationMinutes;
	}
	public Double getPricePerServing() {
		return pricePerServing;
	}
	public void setPricePerServing(Double pricePerServing) {
		this.pricePerServing = pricePerServing;
	}
	public Integer getReadyInMinutes() {
		return readyInMinutes;
	}
	public void setReadyInMinutes(Integer readyInMinutes) {
		this.readyInMinutes = readyInMinutes;
	}
	public Integer getServings() {
		return servings;
	}
	public void setServings(Integer servings) {
		this.servings = servings;
	}
	public Double getSpoonacularScore() {
		return spoonacularScore;
	}
	public void setSpoonacularScore(Double spoonacularScore) {
		this.spoonacularScore = spoonacularScore;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getVegan() {
		return vegan;
	}
	public void setVegan(Boolean vegan) {
		this.vegan = vegan;
	}
	public Boolean getVegetarian() {
		return vegetarian;
	}
	public void setVegetarian(Boolean vegetarian) {
		this.vegetarian = vegetarian;
	}
	
	
	@Override
	public String toString() {
		return "RecipeDTO [cookingMinutes=" + cookingMinutes + ", dairyFree=" + dairyFree + ", glutenFree=" + glutenFree
				+ ", instructions=" + instructions + ", preparationMinutes=" + preparationMinutes + ", pricePerServing="
				+ pricePerServing + ", readyInMinutes=" + readyInMinutes + ", servings=" + servings
				+ ", spoonacularScore=" + spoonacularScore + ", title=" + title + ", vegan=" + vegan + ", vegetarian="
				+ vegetarian + "]";
	}
	
}
