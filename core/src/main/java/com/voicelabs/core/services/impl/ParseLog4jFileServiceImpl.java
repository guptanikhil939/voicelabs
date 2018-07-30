package com.voicelabs.core.services.impl;

import com.voicelabs.core.services.ParseLog4jFileService;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@Component
public class ParseLog4jFileServiceImpl implements ParseLog4jFileService {

    public String parseFiles(){

        // The name of the file to open.
        String fileName = "";
        String patternString = "ERROR";
        StringBuilder errorString = new StringBuilder();

        try {
            List<File> filesForFolder = listFilesForFolder();

            for (File file : filesForFolder) {

                fileName = file.getAbsolutePath();
                // This will reference one line at a time
                String line = null;

                // FileReader reads text files in the default encoding.
                FileReader fileReader =
                        new FileReader(fileName);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader =
                        new BufferedReader(fileReader);

                line = bufferedReader.readLine();

                while (line != null) {
                    if (line.indexOf(patternString) > 0) {
                        errorString = errorString.append(line);
                        errorString = errorString.append("<br><br>");
                    }

                    line = bufferedReader.readLine();
                }

                // Always close files.
                bufferedReader.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

        return errorString.toString();

    }

    public List<File> listFilesForFolder() throws IOException {

        File dir = new File("C:\\var\\log\\glassfish");
        return Arrays.asList(dir.listFiles((d, name) -> name.endsWith(".log")));
    }
}
