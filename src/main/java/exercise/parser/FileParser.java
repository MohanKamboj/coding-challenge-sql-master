package exercise.parser;

import exercise.Table;

public interface FileParser {
	
	Table parser(String fileName ,String row , Table table, boolean isHeader);

}
