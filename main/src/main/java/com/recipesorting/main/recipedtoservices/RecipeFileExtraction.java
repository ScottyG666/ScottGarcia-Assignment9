package com.recipesorting.main.recipedtoservices;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.recipesorting.main.recipedtopojo.RecipeDTO;

//this class is solely for intaking the Recipe file name, parsing through it, and returning a list
//of the RecipeDTOs for easy access to filter.
@Service
public class RecipeFileExtraction {
	
	public List<RecipeDTO> listOfRecipeDTOFromFile (String fileName) {
		//Eventual list to be returned containing the individual CSVRecords turned into 
		//RecipeDTOs
		List<RecipeDTO> listOfRecipesToReturn = new ArrayList<>();
		
		//This code is surrounded in a try catch so that implementations of this code do NOT
		//have to throw exceptions, all exception handling is done within the method
		try (Reader fileIn = new FileReader(fileName)){
			
			//the Format is predefined(for use with multiple files that have the same 
			//structure), to be passed into the CSVParser.
			//This is the Apache Commons CSV 1.9 recommended syntax
			CSVFormat recipeCSVRecordFormat = CSVFormat.Builder.create()
												 .setHeader()
												 .setSkipHeaderRecord(true)
												 .setIgnoreSurroundingSpaces(true)
												 .setEscape('\\')
												 .build();
			//The predefined Format is passed into the parser with the Instantiation of the
			//Reader containing the fileName
			Iterable<CSVRecord> parsedCSVRecords = CSVParser.parse(fileIn, recipeCSVRecordFormat);
			
			//Iterating through the Iterable CSVRecords returned from the parser, and adding them to the
			//RecipeDTO list
			for (CSVRecord record : parsedCSVRecords) {
				//The CSVRecord is added to the RecipeDTO list after instantiating a new RecipeDTO
				//using the RecipeDTO's constructor Method that accepts a CSVRecord
				listOfRecipesToReturn.add(new RecipeDTO(record));
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Whoops, that file is not available at this time.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was a problem with the Input/Output!");
			e.printStackTrace();
		}
		
		//returning the List od RecipeDTO's that were added when iterating through the CSVRecords
		return listOfRecipesToReturn;
	}
	
}
