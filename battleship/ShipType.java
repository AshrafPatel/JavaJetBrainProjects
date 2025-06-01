package battleship;

public enum ShipType {

    CARRIER("the Aircraft Carrier", 5),
    BATTLESHIP("the Battleship", 4),
    SUBMARINE("the Submarine", 3),
    CRUISER("the Cruiser", 3),
    DESTROYER("the Destroyer", 2),
    UNREGISTERED("Unregistered", 0);

    final int size;
    final String name;

    ShipType(String name, int size) {
        this.name = name;
        this.size = size;
    }
}
