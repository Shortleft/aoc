import java.util.*;

public class Six {

    public Six() {

    }
    private int size = 1000;

    public String partOne() {
        List<String> input = Arrays.asList(INPUT.split("\n"));
        int[][] areas = new int[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                int closest = Integer.MAX_VALUE;
                int id = 0;
                for (String line : input) {
                    id++;


                    String[] split = line.split(", ");
                    int currentX = Integer.parseInt(split[0]);
                    int currentY = Integer.parseInt(split[1]);

                    int distance = manhattan(currentX, x, currentY, y);

                    if(distance == closest) {
                        areas[x][y] = 0;
                    }
                    if (distance < closest) {
                        closest = distance;
                        areas[x][y] = id;
                    }
                }

            }
        }

        List<Integer> edges = new ArrayList<>();


        for (int i = 0; i < size -1; i++) {
            int edge = areas[size -1][i];
            edges.add(edge);

            edge = areas[i][size -1];
            edges.add(edge);

            edge = areas[i][0];
            edges.add(edge);

            edge = areas[0][i];
            edges.add(edge);
        }

        int[] count = new int[input.size()];
        for (int[] area : areas) {
            for (int area1 : area) {
                if(!edges.contains(area1)) {
                    count[area1 - 1]++;
                }
            }
        }

        int max = 0;

        for (int c : count) {
            if (c > max) {
                max = c;
            }
        }


        return String.valueOf(max);
    }

    public String partTwo() {
        List<String> input = Arrays.asList(INPUT.split("\n"));
        int[][] areas = new int[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                for (String line : input) {
                    String[] split = line.split(", ");
                    int currentX = Integer.parseInt(split[0]);
                    int currentY = Integer.parseInt(split[1]);

                    int distance = manhattan(currentX, x, currentY, y);
                    areas[x][y] = areas[x][y] + distance;
                }
            }
        }

        int result = 0;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(areas[i][j] < 10000) {
                    result++;
                }
            }
        }

        return "" + result;
    }

    private int manhattan(int x0, int x1, int y0, int y1) {
        return Math.abs(x1 - x0) + Math.abs(y1 - y0);
    }

    private static String INPUT = "67, 191\n" +
            "215, 237\n" +
            "130, 233\n" +
            "244, 61\n" +
            "93, 93\n" +
            "145, 351\n" +
            "254, 146\n" +
            "260, 278\n" +
            "177, 117\n" +
            "89, 291\n" +
            "313, 108\n" +
            "145, 161\n" +
            "143, 304\n" +
            "329, 139\n" +
            "153, 357\n" +
            "217, 156\n" +
            "139, 247\n" +
            "304, 63\n" +
            "202, 344\n" +
            "140, 302\n" +
            "233, 127\n" +
            "260, 251\n" +
            "235, 46\n" +
            "357, 336\n" +
            "302, 284\n" +
            "313, 260\n" +
            "135, 40\n" +
            "95, 57\n" +
            "227, 202\n" +
            "277, 126\n" +
            "163, 99\n" +
            "232, 271\n" +
            "130, 158\n" +
            "72, 289\n" +
            "89, 66\n" +
            "94, 111\n" +
            "210, 184\n" +
            "139, 58\n" +
            "99, 272\n" +
            "322, 148\n" +
            "209, 111\n" +
            "170, 244\n" +
            "230, 348\n" +
            "112, 200\n" +
            "287, 55\n" +
            "320, 270\n" +
            "53, 219\n" +
            "42, 52\n" +
            "313, 205\n" +
            "166, 259";
}
