package battleship;

public class Grid {
    public static final String EMPTY = "~";
    public static final String SHIP = "O";
    public static final String MISS = "M";
    public static final String HIT = "X";

    public static String[] gridLetters = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    public static int[] gridNumbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
     String[][] currentGrid = new String[][]{
             {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
             {"A", EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
             {"B", EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
             {"C", EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
             {"D", EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
             {"E", EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
             {"F", EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
             {"G", EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
             {"H", EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
             {"I", EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
             {"J", EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
     };

    public String drawGrid() {
        //First Row
        String grid = "";
        for (int i = 0; i < currentGrid.length; i++) {
            for (int  j = 0; j < currentGrid[i].length; j++) {
                grid += currentGrid[i][j] + " ";
            }
            grid += "\n";
        }
        return grid;
    }

    public int getSize() {
        return currentGrid.length;
    }

    public void setPosition(int x, int y, String sign) {
        currentGrid[y][x] = sign;
    }

    public String getPosition(int x, int y) {
        return currentGrid[y][x];
    }

    public Ship placeShips(int xMin, int yMin, int xMax, int yMax, ShipType shipType)  {
        if (xMin == xMax) {
            int minNum = Math.min(yMin, yMax);
            int maxNum = Math.max(yMin, yMax);

            for (int i = minNum; i <= maxNum; i++) {
                currentGrid[i][xMin] = SHIP;
            }
        } else {
            int minNum = Math.min(xMin, xMax);
            int maxNum = Math.max(xMin, xMax);

            for (int i = minNum; i <= maxNum; i++) {
                currentGrid[yMin][i] = SHIP;
            }
        }

        Ship ship = new Ship(shipType, xMin, yMin, xMax, yMax);
        return ship;
    }
}
