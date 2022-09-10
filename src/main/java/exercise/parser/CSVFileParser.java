package exercise.parser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import exercise.Table;

public class CSVFileParser implements FileParser{

	@Override
	public Table parser(String fileName , String row , Table table, boolean isHeader) {
		if(isHeader) {
			populateHeader( fileName ,  row,  table) ;
		}else {
			populateData( fileName  , row,  table);
		}
		
		return table;
	}
	
	private void populateData(String fileName  ,String row, Table table) {
		String[] arr = row.split(",");
		Set<Map<String ,String>> dataMapSet = new HashSet();
		Map<String ,String> dataMap = new HashMap<>();
		for (int i = 0 ; i< arr.length ; i++) {
			String columnName = table.getMetaDataMap().get(fileName).get(i);
			dataMap.put(columnName, arr[i]);
		}
		dataMapSet.add(dataMap);
		table.getDataMap().computeIfAbsent(fileName, k-> new HashSet<>()).add(dataMap);
	}
	
	private void populateHeader(String fileName , String header, Table table) {
		String[] arr = header.split(",");
		List<String> set = Arrays.stream(arr).map(str -> str.trim().toUpperCase()).collect(Collectors.toList());
		table.getMetaDataMap().put(fileName, set);
	}

}
