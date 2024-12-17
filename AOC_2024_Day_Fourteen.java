import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AOC_2024_Day_Fourteen {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Input.txt");
        int[] positionHorizontal = new int[fileData.size()];
        int[] positionVertical = new int[fileData.size()];
        int[] velocityHorizontal = new int[fileData.size()];
        int[] velocityVertical = new int[fileData.size()];
        int[][] map = new int[101][103];
        for (int i = 0; i < fileData.size(); i++) {
            String info = fileData.get(i);
            String positionHorizontalInfo = info.substring(info.indexOf("p=") + 2, info.indexOf(","));
            String positionVerticalInfo = info.substring(info.indexOf(",") + 1, info.indexOf(" "));
            info = info.substring(info.indexOf(" ") + 1);
            String velocityHorizontalInfo = info.substring(info.indexOf("v=") + 2, info.indexOf(","));
            String velocityVerticalInfo = info.substring(info.indexOf(",") + 1);

            positionHorizontal[i] = Integer.parseInt(positionHorizontalInfo);
            positionVertical[i] = Integer.parseInt(positionVerticalInfo);
            velocityHorizontal[i] = Integer.parseInt(velocityHorizontalInfo);
            velocityVertical[i] = Integer.parseInt(velocityVerticalInfo);
        }

        for (int i = 0; i < positionHorizontal.length; i++) {
            int horizontalPosition = positionHorizontal[i];
            int verticalPosition = positionVertical[i];
            int horizontalVelocity = velocityHorizontal[i];
            int verticalVelocity = velocityVertical[i];
            map[horizontalPosition][verticalPosition]++;
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < positionHorizontal.length; j++) {
                int horizontalPosition = positionHorizontal[j];
                int verticalPosition = positionVertical[j];
                int horizontalVelocity = velocityHorizontal[j];
                int verticalVelocity = velocityVertical[j];
                if (map[horizontalPosition][verticalPosition] > 0) {
                    map[horizontalPosition][verticalPosition]--;
                }
                int horizontalMovement = horizontalPosition + horizontalVelocity;
                int verticalMovement = verticalPosition + verticalVelocity;
                if (horizontalMovement >= map.length) {
                    horizontalMovement = horizontalMovement - map.length;
                }
                else if (horizontalMovement < 0) {
                    horizontalMovement = map.length + horizontalMovement;
                }
                if (verticalMovement >= map[0].length) {
                    verticalMovement = verticalMovement - map[0].length;
                }
                else if (verticalMovement < 0) {
                    verticalMovement = map[0].length + verticalMovement;
                }
               map[horizontalMovement][verticalMovement]++;
            }
        }

        int firstQuadrantTotal = 0;
        int secondQuadrantTotal = 0;
        int thirdQuadrantTotal = 0;
        int fourthQuadrantTotal = 0;
        for (int i = 0; i < map.length / 2; i++) {
            for (int j = 0; j < map[0].length / 2; j++) {
                firstQuadrantTotal += map[i][j];
            }
        }
        for (int i = map.length / 2; i < map.length; i++) {
            for (int j = map[0].length / 2; j < map[0].length; j++) {
                secondQuadrantTotal += map[i][j];
            }
        }
        for (int i = 0; i < map.length / 2; i++) {
            for (int j = 0; j < map[0].length / 2; j++) {
                thirdQuadrantTotal += map[i][j];
            }
        }
        for (int i = map.length / 2; i < map.length; i++) {
            for (int j = map[0].length / 2; j < map[0].length; j++) {
                fourthQuadrantTotal += map[i][j];
            }
        }
        System.out.println("Safety factor: " + firstQuadrantTotal * secondQuadrantTotal * thirdQuadrantTotal * fourthQuadrantTotal);
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
