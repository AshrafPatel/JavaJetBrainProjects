package battleship;

public class Ship {
    private ShipType type;
    private final int xMin;
    private final int yMin;
    private final int xMax;
    private final int yMax;

    public Ship(ShipType type, int xMin, int yMin, int xMax, int yMax) {
        this.type = type;
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public int getyMin() {
        return yMin;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public int getxMin() {
        return xMin;
    }

    public ShipType getType() {
        return type;
    }

    public void setType(ShipType type) {
        this.type = type;
    }
}
