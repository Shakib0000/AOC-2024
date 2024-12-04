import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AOC_2024_Day_One {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        ArrayList<Integer> firstColumnData = new ArrayList<Integer>();
        ArrayList<Integer> secondColumnData = new ArrayList<Integer>();
        ArrayList<Integer> sortedFirstColumnData = new ArrayList<Integer>();
        ArrayList<Integer> sortedSecondColumnData = new ArrayList<Integer>();
        ArrayList<Integer> distances = new ArrayList<Integer>();

        for (int i = 0; i < fileData.size(); i++) {
            int firstHalf = Integer.parseInt(fileData.get(i).substring(0, 5));
            int secondHalf = Integer.parseInt(fileData.get(i).substring(8));
            firstColumnData.add(firstHalf);
            secondColumnData.add(secondHalf);
        }

        for (int i = 0; i < firstColumnData.size(); i++) {
            int smallestNumIndex = 0;
            for (int j = 0; j < firstColumnData.size(); j++) {
                if (firstColumnData.get(j) < firstColumnData.get(smallestNumIndex)) {
                    smallestNumIndex = j;
                }
            }
            sortedFirstColumnData.add(firstColumnData.get(smallestNumIndex));
            firstColumnData.remove(firstColumnData.get(smallestNumIndex));
            i--;
        }

        for (int i = 0; i < secondColumnData.size(); i++) {
            int smallestNumIndex = 0;
            for (int j = 0; j < secondColumnData.size(); j++) {
                if (secondColumnData.get(j) < secondColumnData.get(smallestNumIndex)) {
                    smallestNumIndex = j;
                }
            }
            sortedSecondColumnData.add(secondColumnData.get(smallestNumIndex));
            secondColumnData.remove(secondColumnData.get(smallestNumIndex));
            i--;
        }

        int total = 0;
        for (int i = 0; i < sortedFirstColumnData.size(); i++) {
            total += Math.abs(sortedFirstColumnData.get(i) - sortedSecondColumnData.get(i));
        }
        System.out.println("The total distance is " + total);

        int similarityScore = 0;
        for (int i = 0; i < sortedFirstColumnData.size(); i++) {
            int count = 0;
            for (int j = 0; j < sortedSecondColumnData.size(); j++) {
                if (sortedSecondColumnData.get(j).equals(sortedFirstColumnData.get(i))) {
                    count++;
                }
            }
            similarityScore += count*sortedFirstColumnData.get(i);
        }

        System.out.println("The similarity score is " + similarityScore);
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
