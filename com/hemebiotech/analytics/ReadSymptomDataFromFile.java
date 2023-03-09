package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * this class is to read the input file symptoms.txt.
 * @author Mickael Hayé
 * @version 1.0
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
  private String filepath;
  
  /**
   * constructor for this class.
   * @param filepath path for the input file Symptoms.txt
   */
  public ReadSymptomDataFromFile(String filepath) {
    this.filepath = filepath;
  }

  /**
   * retrieves the list of entries.
   * @return List with all the symptoms
   */
  @Override
  public List<String> getSymptoms() {
    ArrayList<String> result = new ArrayList<String>();
    if (filepath != null) {
      try {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = reader.readLine();
        while (line != null) {
          result.add(line);
          line = reader.readLine();
        }
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return result;
  }
}