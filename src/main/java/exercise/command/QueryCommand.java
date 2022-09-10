package exercise.command;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.Map.Entry;

import exercise.Table;
import exercise.exception.InvalidColumnNameException;
import exercise.exception.InvalidParameterException;
import exercise.handler.QueryHandler;

public class QueryCommand implements Command {
	
	private QueryHandler queryHandler;
	public QueryCommand(QueryHandler queryHandler) {
		this.queryHandler=queryHandler;
	}

	@Override
	public String helpText() {
		// TODO Auto-generated method stub
		return "Query <pararmert>";
	}

	@Override
	public void execute(String[] params)  throws InvalidParameterException,InvalidColumnNameException{
		if(params.length == 0) {
			throw new InvalidParameterException("Query command need at least one parameter");
		}else if(params.length > 2) {
			throw new InvalidParameterException("Query command need max 2 parameter");
		}else if(params.length == 1) {
			Table table = queryHandler.getTable();
			boolean isContain = false;
			String key = null;
			for(Entry<String, List<String>> entry : table.getMetaDataMap().entrySet()) {
				 isContain  = entry.getValue().contains(params[0].trim().toUpperCase());
				 if(isContain) {
					 key = entry.getKey();
					 break;
				 }
				
			}
			if(isContain) {
				//
				
				Set<Map<String, String>> setMap = table.getDataMap().get(key);
				Set<Map<String, String>> sortedMap = new TreeSet<>();
				
				System.out.println(sortedMap);
			}else {
				throw new InvalidColumnNameException("Column name "+params[0]+" is Invalid ");
			}
		}else if(params.length == 2) {
			//apply join logic here
		}
		
		
		
		
		System.out.println();
		// add logic for query 
	}

}
