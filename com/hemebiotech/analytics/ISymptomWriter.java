package com.hemebiotech.analytics;

import java.util.Map;

/**
 * this interface is for the class WriteSymptomDataFromFile.
 * @author Mickael Hayé
 * @version 1.0
 */
public interface ISymptomWriter {
  
  /**
   * this method write symptoms and occurence in the result.out file.
   * @param symptoms Map with the symptom name and the occurence counter
   */
  public void writeSymptoms(Map<String, Integer> symptoms);
}
