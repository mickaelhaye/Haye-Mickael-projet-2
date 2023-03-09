package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * this class have the different methods to create the result.out file.
 * @author Mickael Hayé
 * @version 1.0
 */
public class AnalyticsCounter {
  private ISymptomReader reader;
  private ISymptomWriter writer;

  /**
   * constructor of this class.
   * @param reader object with the input file Symptoms.txt
   * @param writer object wiich create the ouput file result.out
   */
  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }

  /**
   * retrieves the list of entries.
   * @return List with all the symptoms
   */ 
  public List<String> getSymptoms() {
    return this.reader.getSymptoms();
  }

  /**
   * count the number of occurences for each symptom.
   * @param symptoms String list with the symptoms
   * @return Map with the symptom name and the occurence counter
   */
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

  /**
   * sort the list of symptoms and occurences alphabetically.
   * @param symptoms Map with the symptom name and the number occurence counter
   * @return Map alphabetically sorted
   */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
    Map<String, Integer> mapSort = new TreeMap<String, Integer>(symptoms);
    return mapSort;
  }

  /**
   * write the result to the output file.
   * @param symptoms Map with the symptom name and the number occurence counter
   */
  public void writeSymptoms(Map<String, Integer> symptoms) {
    try {
      this.writer.writeSymptoms(symptoms);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
