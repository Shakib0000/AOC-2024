import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AOC_2024_Day_Fifteen {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Input.txt");
        int robotX = 0;
        int robotY = 0;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < fileData.get(i).length(); j++) {
                if (fileData.get(i).substring(j, j+1).equals("@")) {
                    robotX = i;
                    robotY = j;
                }
            }
        }

        for (int i = 50; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(i).length(); j++) {
                String move = fileData.get(i).substring(j,j+1);
                if (move.equals("^")) {
                    if (fileData.get(robotX-1).substring(robotY, robotY+1).equals("O")) {

                    }
                    else if (fileData.get(robotX-1).substring(robotY, robotY+1).equals(".")) {

                    }
                    else {
                        
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