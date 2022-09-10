package exercise.client;

import java.io.BufferedReader;

import exercise.command.CommandFactory;

public class FileClient extends Client {

	public FileClient(BufferedReader inputReader, CommandFactory commandFactory) {
		super(inputReader, commandFactory);
	}
}
