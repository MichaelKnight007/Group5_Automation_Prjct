package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1. Create object from Properties class
    private static final Properties properties = new Properties();

    static {

        try {
            // 2. Create object from FileInputStream class, so we open the file in java memory.
            FileInputStream file = new FileInputStream("configuration.properties");

            // 3. Load the properties object using FileInputStream object
            properties.load(file); // We'll have IOException, we have to handle it by usin try&catch block.

            // 4. close the file
            file.close();


        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader class.");
            e.printStackTrace();
        }

    }

    public static String getProperty(String keyword){// We use public access modifier to reach from every package,
        // static specifier to call it by the class name, and return type String to get the value.
        return  properties.getProperty(keyword);
    }
}
