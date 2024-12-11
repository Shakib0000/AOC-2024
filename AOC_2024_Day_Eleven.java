import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AOC_2024_Day_Eleven {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Input.txt");
        ArrayList<Integer> stones = new ArrayList<Integer>();
        while (fileData.get(0).indexOf(" ") != -1) {
            stones.add(Integer.parseInt(fileData.get(0).substring(0, fileData.get(0).indexOf(" "))));
            fileData.set(0, fileData.get(0).substring(fileData.get(0).indexOf(" ") + 1));
        }
        stones.add(Integer.parseInt(fileData.get(0)));
        for (int j = 0; j < 25; j++) {
            for (int i = 0; i < stones.size(); i++) {
                int stone = stones.get(i);
                if (stone == 0) {
                    stones.set(i, 1);
                } else if (String.valueOf(stone).length() % 2 == 0) {
                    String firstHalf = String.valueOf(stone).substring(0, String.valueOf(stone).length() / 2);
                    String secondHalf = String.valueOf(stone).substring(String.valueOf(stone).length() / 2);
                    System.out.println(stone);
//                    System.out.println(firstHalf);
//                    System.out.println(secondHalf);
                    stones.set(i, Integer.parseInt(firstHalf));
                    stones.add(i + 1, Integer.parseInt(secondHalf));
                } else {
                    stones.set(i, stone * 2024);
                }
            }
        }
        System.out.println(stones.size());
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