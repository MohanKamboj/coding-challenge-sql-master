package exercise.client;

import java.io.BufferedReader;

import exercise.command.CommandFactory;

public class CLIClient extends Client {

	public CLIClient(BufferedReader inputReader, CommandFactory commandFactory) {
		super(inputReader, commandFactory);
	}
}
