package com.hemebiotech.analytics;

import java.util.List;

/**
 * this interface is for the class ReadSymptomDataFromFile.
 * @author Mickael Hayé
 * @version 1.0
 */
public interface ISymptomReader {

  /**
   * retrieves the list of entries from the symptoms.txt file.
   * @return List with all the symptoms
   */ 
  List<String> getSymptoms();
}
