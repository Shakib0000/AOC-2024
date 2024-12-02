import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        ArrayList<Integer> firstColumnData = new ArrayList<Integer>();
        ArrayList<Integer> secondColumnData = new ArrayList<Integer>();
        ArrayList<Integer> distances = new ArrayList<Integer>();

        for (int i = 0; i < fileData.size(); i++) {
            Integer firstHalf = Integer.parseInt(fileData.get(i).substring(0, 5));
            Integer secondHalf = Integer.parseInt(fileData.get(i).substring(8));
            firstColumnData.add(firstHalf);
            secondColumnData.add(secondHalf);
        }

        for (int i = 0; i < firstColumnData.size(); i++) {
            Integer smallestNum = secondColumnData.get(0);
            Integer smallestNumIndex = 0;
            for (int j = 0; j < secondColumnData.size(); j++) {
                if (secondColumnData.get(j) < smallestNum) {
                    smallestNum = secondColumnData.get(j);
                    smallestNumIndex = j;
                }
            }
            distances.add(Math.abs(firstColumnData.get(i)-smallestNum));
            secondColumnData.remove(smallestNumIndex);
        }

        Integer total = 0;
        for (int i = 0; i < distances.size(); i++) {
            total += distances.get(i);
        }

        System.out.println(total);

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