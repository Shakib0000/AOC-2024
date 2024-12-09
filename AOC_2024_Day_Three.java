import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AOC_2024_Day_Three {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Input.txt");

        String finalStr = "";
        for (int i = 0; i < fileData.size(); i++) {
            String tempStr = fileData.get(i);
            while (tempStr.indexOf("mul") != -1) {

                int mulIndex = tempStr.indexOf("mul");
                if (tempStr.substring(mulIndex + 3, mulIndex + 4).equals("(")) {
                    tempStr = tempStr.substring(mulIndex + 3, mulIndex + 12);
                    if (tempStr.indexOf(")") <= 16) {
                        if (tempStr.indexOf(",") > tempStr.indexOf("(") && tempStr.indexOf(",") < tempStr.indexOf(")")) {
                            System.out.println(tempStr);
                        }
                    }
                }
            }
        }
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
