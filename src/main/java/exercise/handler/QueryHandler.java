package exercise.handler;

import java.util.Objects;

import exercise.Table;

public class QueryHandler {
	
	private static QueryHandler queryHandler;
	private static Table table;
	
	public static QueryHandler getInstance() {
		if(Objects.isNull(queryHandler)) {
			synchronized (QueryHandler.class) {
				if(Objects.isNull(queryHandler)) {
					queryHandler = new QueryHandler();
				}
			}
		}
		return queryHandler;
	}

	public Table getTable() {
		return table;
	}

	public static void setTable(Table table) {
		QueryHandler.table = table;
	}
	
	

}
