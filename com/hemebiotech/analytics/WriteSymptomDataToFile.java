package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * this class is to write the output file result.out.
 * @author Mickael Hayé
 * @version 1.0
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
 
  /**
   * this method write symptoms and occurence in the result.out file.
   * @param symptoms Map with the symptom name and the occurence counter
   */
  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"));
      for (String entry:symptoms.keySet()) {      
        writer.write(entry + " : " + symptoms.get(entry));
        writer.newLine();
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
