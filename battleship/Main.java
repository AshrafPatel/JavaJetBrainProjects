package battleship;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Grid grid = new Grid();
        Grid fogGrid = new Grid();
        System.out.println(grid.drawGrid());

        Ship carrier = Helper.queryShips(ShipType.CARRIER,grid);
        if (carrier != null) grid.placeShips(carrier.getxMin(), carrier.getyMin(), carrier.getxMax(), carrier.getyMax(), carrier.getType());
        System.out.println(grid.drawGrid());

        Ship battleShip = Helper.queryShips(ShipType.BATTLESHIP,grid);
        if (battleShip != null) grid.placeShips(battleShip.getxMin(), battleShip.getyMin(), battleShip.getxMax(), battleShip.getyMax(), battleShip.getType());
        System.out.println(grid.drawGrid());

        Ship submarine = Helper.queryShips(ShipType.SUBMARINE,grid);
        if (submarine != null) grid.placeShips(submarine.getxMin(), submarine.getyMin(), submarine.getxMax(), submarine.getyMax(), submarine.getType());
        System.out.println(grid.drawGrid());

        Ship cruiser = Helper.queryShips(ShipType.CRUISER,grid);
        if (cruiser != null) grid.placeShips(cruiser.getxMin(), cruiser.getyMin(), cruiser.getxMax(), cruiser.getyMax(), cruiser.getType());
        System.out.println(grid.drawGrid());

        Ship destroyer = Helper.queryShips(ShipType.DESTROYER,grid);
        if (destroyer != null) grid.placeShips(destroyer.getxMin(), destroyer.getyMin(), destroyer.getxMax(), destroyer.getyMax(), destroyer.getType());
        System.out.println(grid.drawGrid());

        System.out.println("The game starts!");
        System.out.println(grid.drawGrid());
        System.out.println("Take a shot!");
        String coordinate = scan.nextLine();
        boolean isShotValid = Helper.takeShot(grid, coordinate);
        Helper.takeShot(fogGrid, coordinate);
    }
}
