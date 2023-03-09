package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
	private ISymptomReader reader;
  private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }
	public List<String> getSymptoms() {
    return this.reader.getSymptoms();
  }
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i < symptoms.size(); i++) {
      if (map.containsKey(symptoms.get(i))) {
        String keyMap = symptoms.get(i);
        int valMap = map.get(keyMap);
        valMap++;
        map.put(keyMap, valMap);
      } else {
        map.put(symptoms.get(i), 1);
      }
    }
    return map;
  }
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
    Map<String, Integer> mapSort = new TreeMap<String, Integer>(symptoms);
    return mapSort;
  }
	public void writeSymptoms(Map<String, Integer> symptoms) {
    try {
      this.writer.writeSymptoms(symptoms);
    } catch (Exception e) {
      e.printStackTrace();
    }
	}
}