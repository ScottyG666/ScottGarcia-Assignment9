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

@Service
public class RecipeFileExtraction {

	public List<RecipeDTO> listOfRecipeDTOFromFile (String fileName) {
		List<RecipeDTO> listOfRecipesToReturn = new ArrayList<>();
		try (Reader fileIn = new FileReader(fileName)){
			
			CSVFormat format = CSVFormat.Builder.create()
												 .setHeader()
												 .setSkipHeaderRecord(true)
												 .setIgnoreSurroundingSpaces(true)
												 .setEscape('\\')
												 .build();
			
			Iterable<CSVRecord> parsedCSVRecords = CSVParser.parse(fileIn, format);
			
			for (CSVRecord record : parsedCSVRecords) {
				listOfRecipesToReturn.add(new RecipeDTO(record));
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Whoops, that file is not available at this time.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was a problem with the Input/Output!");
			e.printStackTrace();
		}
		
		
		return listOfRecipesToReturn;
	}
	
}
