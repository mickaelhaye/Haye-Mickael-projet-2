package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
 @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {
    try {
      FileWriter fileWriter = new FileWriter("result.out");
      BufferedWriter writer = new BufferedWriter(fileWriter);
      for (Map.Entry<String, Integer> entry:symptoms.entrySet()) {      
        writer.write(entry.getKey() + " : " + entry.getValue());
        writer.newLine();
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}