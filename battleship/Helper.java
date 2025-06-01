package battleship;

public class Helper {
    public static int turnLetterToNumber(char letter) {
        return Character.toUpperCase(letter) - 'A';
    }

    public static boolean checkNoNeighbours(int x1, int x2, int y1, int y2, String sign, Grid grid) {
        for (int x = Math.min(x1, x2) - 1; x <= Math.max(x1, x2) + 1; x++) {
            for (int y = Math.min(y1, y2) - 1; y <= Math.max(y1, y2) + 1; y++) {
                if (isCorrectPosition(x, y, grid)) {
                    if (grid.getPosition(x, y) == sign) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isCorrectPosition(int x, int y, Grid grid) {
        boolean correctPosition = x >= 0 && x < grid.getSize() && y >= 0 && y < grid.getSize();
        if (!correctPosition) System.out.println("Error! Wrong ship location! Try again:");
        return correctPosition;
    }

    public static Ship queryShips(ShipType shipType, Grid currentGrid) {
        System.out.println("Enter the coordinates of the " + shipType.name + " (" + shipType.size + " cells):");

        Ship ship = promptCoordinateToMakeShip();

        boolean firstPosCorrect = isCorrectPosition(ship.getxMin(), ship.getyMin(), currentGrid);
        boolean secondPosCorrect = isCorrectPosition(ship.getxMax(), ship.getyMax(), currentGrid);
        boolean noNeighbours = checkNoNeighbours(ship.getxMin(), ship.getxMax(), ship.getyMin(), ship.getyMax(), Grid.SHIP, currentGrid);
        boolean isLengthCorrect = checkLengthOfShipMatchCoordinates(shipType, currentGrid, ship.getxMin(), ship.getxMax(), ship.getyMin(), ship.getyMax());
        ship.setType(shipType);

        return (firstPosCorrect && secondPosCorrect && noNeighbours && isLengthCorrect) ? ship : null;
    }
    
    public static boolean checkLengthOfShipMatchCoordinates(ShipType shipType, Grid grid, int xMin, int yMin, int xMax, int yMax) {
        boolean isCorrectLength = false;
        if (xMin == xMax) {
            //If number are the same get the length of Y axis (numbers)
            int minNum = Math.min(yMin, yMax);
            int maxNum = Math.max(yMin, yMax);
            int length = (maxNum - minNum);
            int number = 0;

            for (int i = minNum; i <= maxNum; i++) {
                if (grid.currentGrid[i][xMin].equals(Grid.EMPTY)) {
                    number++;
                }
            }

            isCorrectLength = number == length + 1 ? true : false;
        } else if (yMin == yMax) {
            //If letters are the same get the length of X axis (letters)
            int minNum = Math.min(xMin, xMax);
            int maxNum = Math.max(xMin, xMax);
            int length = (maxNum - minNum);
            int number = 0;

            for (int i = minNum; i <= maxNum; i++) {
                if (grid.currentGrid[yMin][i].equals(Grid.EMPTY)) {
                    number++;
                }
            }

            isCorrectLength = number == length + 1 ? true : false;
        }
        if (!isCorrectLength) System.out.println("Error! Wrong length of the " + shipType + "! Try again:");
        return isCorrectLength;
    }

    public static Ship promptCoordinateToMakeShip() {
        String coordinates = Main.scan.nextLine();
        String[] inputCoordinates = coordinates.split(" ");
        int letter1 = turnLetterToNumber(inputCoordinates[0].charAt(0));
        int letter2 = turnLetterToNumber(inputCoordinates[1].charAt(0));

        int number1 = Integer.parseInt(inputCoordinates[0].substring(1)) - 1;
        int number2  = Integer.parseInt(inputCoordinates[1].substring(1)) - 1;

        return new Ship(ShipType.UNREGISTERED, number1, letter1, number2, letter2);
    }

    public static boolean takeShot(Grid grid, String coordinate) {
        int letter = turnLetterToNumber(coordinate.charAt(0));
        int number = Integer.parseInt(coordinate.substring(1)) - 1;

        boolean coordinateValid = isCorrectPosition(number, letter, grid);

        if (coordinateValid) {
            if (grid.currentGrid[letter][number].equals(Grid.SHIP)) {
                grid.currentGrid[letter][number] = Grid.HIT;
                System.out.println("You hit a ship!");
            } else if (grid.currentGrid[letter][number].equals(Grid.EMPTY)) {
                grid.currentGrid[letter][number] = Grid.MISS;
                System.out.println("You missed!");
            } else if (grid.currentGrid[letter][number].equals(Grid.HIT) ||
                grid.currentGrid[letter][number].equals(Grid.MISS)) {
                System.out.println("Already Hit Coordinate");
                coordinateValid = false;
            }
        }
        return coordinateValid;
    }
}
