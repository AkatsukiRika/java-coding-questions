package leetcode.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class BigDataHelper {
    private static final String RESOURCE_ROOT = "app/src/main/resources";

    public static int[] readIntegersFromFile(String filePath) throws IOException {
        String realFilePath = System.getProperty("user.dir") + File.separator + RESOURCE_ROOT + File.separator + filePath;
        BufferedReader reader = new BufferedReader(new FileReader(realFilePath));
        String line = reader.readLine();
        String[] splitLine = line.split(",");
        int[] integers = new int[splitLine.length];
        for (int i = 0; i < splitLine.length; i++) {
            integers[i] = Integer.parseInt(splitLine[i]);
        }
        reader.close();
        return integers;
    }
}
