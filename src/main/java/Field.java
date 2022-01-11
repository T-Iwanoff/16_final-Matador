public class Field {
    private int position, owner, price, houses, houseprice;
    private int[] rent;
    private String type, neighbourhood;

    public Field(int pos, int price, int hprice, //For streets
                 int rent0, int rent1, int rent2,
                 int rent3, int rent4, int rent5,
                 String type, String nbh) {
        position = pos;
        owner = 0;
        this.price = price;
        houses = 0;
        this.houseprice = hprice;
        rent = new int[] {rent0, rent1, rent2, rent3, rent4, rent5};
        this.type = type;
        neighbourhood = nbh;
    }

    public Field(int pos, int price, String type) { //For breweries
        position = pos;
        this.price = price;
        this.type = type;
        owner = 0;
    }

    public Field(int pos, int price, String type, //For ferries
                 int rent1, int rent2, int rent3, int rent4) {
        position = pos;
        this.price = price;
        this.type = type;
        owner = 0;
        rent = new int[] {0, rent1, rent2, rent3, rent4};
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getHouseprice() {
        return houseprice;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    /** Returns the rent corresponding to the current number of houses */
    public int getRent() {
        return rent[houses];
    }

    /** Returns the rent corresponding to the specified number of houses/ferries */
    public int getRent(int ferries) {
        return rent[ferries];
    }

    public int getHouses() {
        return houses;
    }

    public void setHouses(int houses) {
        this.houses = houses;
    }
}
