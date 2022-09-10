package exercise.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

import exercise.command.CommandFactory;

public class ClientFactory {

	public static Client buildClient(String[] args, CommandFactory commandFactory) throws FileNotFoundException {
		if (args.length == 0) {
			return new CLIClient(new BufferedReader(new InputStreamReader(System.in)), commandFactory);
		} else {
			return new FileClient(new BufferedReader(new FileReader(args[0])), commandFactory);
		}
	}
}
