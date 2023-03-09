package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * this class is the main.
 * @author Mickael Hayé
 * @version 1.0
 */
public class Main {

  /**
   * main method.
   */
  public static void main(String[] args) {
    ISymptomReader symptomReader = new ReadSymptomDataFromFile("symptoms.txt");
    ISymptomWriter symptomWriter = new WriteSymptomDataToFile();
    AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomReader, symptomWriter);
    List<String> listSymptoms = analyticsCounter.getSymptoms();
    Map<String, Integer> mapSymptoms = analyticsCounter.countSymptoms(listSymptoms);
    Map<String, Integer> mapSortSymptoms = analyticsCounter.sortSymptoms(mapSymptoms);
    try {
      analyticsCounter.writeSymptoms(mapSortSymptoms);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}