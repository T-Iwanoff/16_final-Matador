public class Field {
    private int position, owner, price, houses, houseprice;
    private int[] rent;
    private String type, neighbourhood;

    /** Constructor for streets */
    public Field(int pos, int price, int hprice,
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

    /** Constructor for breweries */
    public Field(int pos, String type) {
        position = pos;
        price = 3000;
        this.type = type;
        owner = 0;
        rent = new int[] {0, 100, 200};
        houses = 0;
    }

    /** Constructor for ferries */
    public Field(int pos, String type, int price) {
        position = pos;
        this.price = 4000;
        this.type = type;
        owner = 0;
        houses = 0;
        rent = new int[] {0, 500, 1000, 2000, 4000};
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

    public int getPosition() {
        return position;
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

    /** Returns the rent corresponding to the specified number of houses/ferries/breweries */
    public int getRent(int number) {
        return rent[number];
    }

    public int getHouses() {
        return houses;
    }

    public void setHouses(int houses) {
        this.houses = houses;
    }
}
