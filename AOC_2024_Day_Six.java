import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AOC_2024_Day_Six {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Input.txt");
        String[][] map = new String[fileData.getFirst().length()][fileData.size()];
        for (int i = 0; i < fileData.size(); i++) {
            map[i] = fileData.get(i).split("");
        }

        int moveCount = 0;
        boolean onMap = true;
        while (onMap) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j].equals("v")) {
                        if (i + 1 < map.length && map[i + 1][j].equals(".")) {
                            map[i + 1][j] = "v";
                            map[i][j] = "X";
                            moveCount++;
                        } else if (i + 1 < map.length && map[i + 1][j].equals("#")) {
                            map[i][j] = "<";
                        }
                        else {
                            moveCount++;
                            onMap = false;
                        }
                    }
                    if (map[i][j].equals(">")) {
                        if (j + 1 < map[0].length && map[i][j + 1].equals(".")) {
                            map[i][j + 1] = ">";
                            map[i][j] = "X";
                            moveCount++;
                        } else if (j + 1 < map[0].length && map[i][j + 1].equals("#")) {
                            map[i][j] = "v";
                        }
                        else {
                            moveCount++;
                            onMap = false;
                        }
                    }
                    if (map[i][j].equals("^")) {
                        if (i - 1 >= 0 && map[i - 1][j].equals(".")) {
                            map[i - 1][j] = "^";
                            map[i][j] = "X";
                            moveCount++;
                        } else if (i - 1 >= 0 && map[i - 1][j].equals("#")) {
                            map[i][j] = ">";
                        }
                        else {
                            moveCount++;
                            onMap = false;
                        }
                    }
                    if (map[i][j].equals("<")) {
                        if (j - 1 >= 0 && map[i][j - 1].equals(".")) {
                            map[i][j - 1] = "<";
                            map[i][j] = "X";
                            moveCount++;
                        } else if (j - 1 >= 0 && map[i][j - 1].equals("#")) {
                            map[i][j] = "^";
                        }
                        else {
                            moveCount++;
                            onMap = false;
                        }
                    }
                }
            }
            System.out.println(moveCount);
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