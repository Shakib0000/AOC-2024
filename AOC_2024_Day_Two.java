import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AOC_2024_Day_Two {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Input.txt");

        int safeReports = 0;
        int problemDampenerSafeReports = 0;
        for (int i = 0; i < fileData.size(); i++) {
            boolean safe = true;
            int problemCount = 0;
            String[] array = fileData.get(i).split(" ");
            String direction = "";
            if (Integer.parseInt(array[0]) < Integer.parseInt(array[1])) {
                direction = "increasing";
            }
            else if (Integer.parseInt(array[0]) > Integer.parseInt(array[1])) {
                direction = "decreasing";
            }
            for (int j = 0; j < array.length - 1; j++) {
                if (direction.equals("decreasing") && ((Integer.parseInt(array[j]) - Integer.parseInt(array[j+1]) > 3) || Integer.parseInt(array[j]) - Integer.parseInt(array[j+1]) < 0)) {
                    safe = false;
                    problemCount++;
                }
                if (direction.equals("increasing") && ((Integer.parseInt(array[j+1]) - Integer.parseInt(array[j]) > 3) || Integer.parseInt(array[j+1]) - Integer.parseInt(array[j]) < 0)) {
                    safe = false;
                    problemCount++;
                }
                if ((Integer.parseInt(array[j]) == Integer.parseInt(array[j+1]))) {
                    safe = false;
                    problemCount++;
                }
            }
            if (safe) {
                safeReports++;
                problemDampenerSafeReports++;
            }
            else {
                if (problemCount == 1) {
                    problemDampenerSafeReports++;
                }
            }
        }

        System.out.println("There are " + safeReports + " safe reports.");
        System.out.println("Using the problem dampener, there are " + problemDampenerSafeReports + " safe reports.");
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
