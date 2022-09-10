package exercise.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exercise.Table;
import exercise.exception.InvalidParameterException;
import exercise.handler.QueryHandler;
import exercise.parser.CSVFileParser;

public class CommandFactory {

	private Map<String, Command> commands;
	

	private CommandFactory() {
		commands = new HashMap<>();
	}

	public static CommandFactory init(QueryHandler queryHandler , List<String> files ) {
		final CommandFactory cf = new CommandFactory();
		cf.addCommand("Query", new QueryCommand(queryHandler));
		queryHandler.setTable(populateData(files));
		return cf;
	}

	private static Table populateData(List<String> filesList) {
		CSVFileParser csvparser = new CSVFileParser();
		Table table = new Table();
		for (String file :  filesList) {
			String fileName = file.substring(file.lastIndexOf("/")+1, file.lastIndexOf("."));
			BufferedReader reader = null;
	        try {
	            reader = Files.newBufferedReader(Paths.get(file));
	            String line ;
	            int count = 1;
	            while ((line = reader.readLine()) != null) {
	                if(count == 1) {
	                	csvparser.parser(fileName, line ,table, true );
	                }else {
	                	csvparser.parser(fileName, line ,table, false );
	                }
	                count++;
	                // add data 
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}
		return table;
	}
	public void addCommand(String name, Command command) {
		commands.put(name, command);
	}

	public void executeCommand(String name, String[] params)
			throws  InvalidParameterException {
		if (commands.containsKey(name)) {
			commands.get(name).execute(params);
		} 
	}

	public void listCommandHelp() {
		commands.keySet().stream().map(command -> commands.get(command).helpText()).forEach(System.out::println);
	}

	public Map<String, Command> getCommands() {
		return commands;
	}
}
