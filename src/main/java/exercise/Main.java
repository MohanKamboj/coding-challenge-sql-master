package exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import exercise.client.Client;
import exercise.client.ClientFactory;
import exercise.command.CommandFactory;
import exercise.handler.QueryHandler;
import exercise.parser.CSVFileParser;

public class Main {
	
	public static void main(String[] args) {
		List<String> filesList = List.of("src/main/resources/purchases.csv","src/main/resources/users.csv");
			QueryHandler queryHandler = new QueryHandler();
	        CommandFactory commandFactory = CommandFactory.init( queryHandler,filesList );
	        try {
	            Client client = ClientFactory.buildClient(args, commandFactory);
	            client.handleInput();
	        } catch (FileNotFoundException ex) {
	            System.out.println("Sorry! the supplied input file was not found!");
	        } catch (IOException ex) {
	            System.out.println("Something went wrong. Please try again!");
	        }
			
			
		
	}

}
