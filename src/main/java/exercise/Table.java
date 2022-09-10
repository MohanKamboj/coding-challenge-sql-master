package exercise;

import java.util.*;

/**
 * TODO implement
 */
public class Table {
	
	Map<String, List<String>> metaDataMap = new HashMap<>();
	
	Map<String , Set<Map<String ,String>>> dataMap = new HashMap<>();

	public Map<String, List<String>> getMetaDataMap() {
		return metaDataMap;
	}

	public void setMetaDataMap(Map<String, List<String>> metaDataMap) {
		this.metaDataMap = metaDataMap;
	}

	public Map<String, Set<Map<String, String>>> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Set<Map<String, String>>> dataMap) {
		this.dataMap = dataMap;
	}
	
	
}
