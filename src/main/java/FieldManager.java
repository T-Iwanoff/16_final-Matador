import java.util.HashMap;

public class FieldManager {

    private HashMap<String, Integer> neighbourhoods = new HashMap<>();
    private Field[] fields;

    /** Constructor. Sets up the fields array and the neighbourhoods HashMap */
    public FieldManager() {
        //Creates a field object corresponding to each ownable field in the game
        fields = new Field[28];
        fields[0] = new Field(1,1200,1000,50,250,750,2250,4000,6000,"street","blue"); //Rødovrevej
        fields[1] = new Field(3,1200,1000,50,250,750,2250,4000,6000,"street","blue"); //Hvidovrevej
        fields[2] = new Field(6,2000,1000,100,600,1800,5400,8000,11000,"street","orange"); //Roskildevej
        fields[3] = new Field(8,2000,1000,100,600,1800,5400,8000,11000,"street","orange"); //Valby Langgade
        fields[4] = new Field(9,2400,1000,150,800,2000,6000,9000,12000,"street","orange"); //Allégade
        fields[5] = new Field(11,2800,2000,200,1000,3000,9000,12500,15000,"street","green"); //Frederiksberg Allé
        fields[6] = new Field(13,2800,2000,200,1000,3000,9000,12500,15000,"street","green"); //Bülowsvej
        fields[7] = new Field(14,3200,2000,250,1250,3750,10000,14000,18000,"street","green"); //Gl. Kongevej
        fields[8] = new Field(16,3600,2000,300,1400,4000,11000,15000,19000,"street","grey"); //Bernstorfffsvej
        fields[9] = new Field(18,3600,2000,300,1400,4000,11000,15000,19000,"street","grey"); //Hellerupvej
        fields[10] = new Field(19,4000,2000,350,1600,4400,12000,16000,20000,"street","grey"); //Strandvejen
        fields[11] = new Field(21,4400,3000,350,1800,5000,14000,17500,21000,"street","red"); //Trianglen
        fields[12] = new Field(23,4400,3000,350,1800,5000,14000,17500,21000,"street","red"); //Østerbrogade
        fields[13] = new Field(24,4800,3000,400,2000,6000,15000,18500,22000,"street","red"); //Grønningen
        fields[14] = new Field(26,5200,3000,450,2200,6600,16000,19500,23000,"street","white"); //Bredgade
        fields[15] = new Field(27,5200,3000,450,2200,6600,16000,19500,23000,"street","white"); //Kgs. Nytorv
        fields[16] = new Field(29,5600,3000,500,2400,7200,17000,20500,24000,"street","white"); //Østergade
        fields[17] = new Field(31,6000,4000,550,2600,7800,18000,22000,25000,"street","yellow"); //Amagertorv
        fields[18] = new Field(32,6000,4000,550,2600,7800,18000,22000,25000,"street","yellow"); //Vimmelskaftet
        fields[19] = new Field(34,6400,4000,600,3000,9000,20000,24000,28000,"street","yellow"); //Nygade
        fields[20] = new Field(37,7000,4000,700,3500,10000,22000,26000,30000,"street","purple"); //Frederiksberggade
        fields[21] = new Field(39,8000,4000,1000,4000,12000,28000,34000,40000,"street","purple"); //Rådhuspladsen
        fields[22] = new Field(5,"ferry",4000); //Helsingør - Helsingborg
        fields[23] = new Field(15,"ferry",4000); //Mols-Linien
        fields[24] = new Field(25,"ferry",4000); //Gedser - Rostock
        fields[25] = new Field(35,"ferry",4000); //Rødby - Puttgarden
        fields[26] = new Field(12,"brewery"); //Tuborg Squash
        fields[27] = new Field(28,"brewery"); //Coca Cola
        //Creates a HashMap Item for each neighbourhood and sets all owner IDs to 0
        neighbourhoods.put("blue",0);
        neighbourhoods.put("orange",0);
        neighbourhoods.put("green",0);
        neighbourhoods.put("grey",0);
        neighbourhoods.put("red",0);
        neighbourhoods.put("white",0);
        neighbourhoods.put("yellow",0);
        neighbourhoods.put("purple",0);
    }

    /** Returns the field ID in the field array that corresponds to a position */
    private int posToNum(int field) {
        int temp = 0;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getPosition() == field) {
                temp = i;
            }
        }
        return temp;
    }

    /** Returns a list of all the fields owned by the player */
    public int[] getOwnedFields(int player) {
        int owned = 0;
        for (Field i : fields) {
            if (i.getOwner() == player) {owned++;}
        }
        int[] ownedFields = new int[owned];
        int temp = 0;
        for (Field i : fields) {
            if (i.getOwner() == player) {
                ownedFields[temp++] = i.getPosition();
            }
        }
        return ownedFields;
    }

    /** Returns whether a field is owned by a player */
    public boolean isOwned(int field) {
        return (fields[posToNum(field)].getOwner() == 0);
    }

    /** Returns whether a neighbourhood is owned by a player */
    public boolean isOwned(String nbh) {
        return (neighbourhoods.get(nbh) == 0);
    }

    /** Returns the ID of the player that owns the field. Returns 0 if unowned */
    public int getOwner(int field) {
        return fields[posToNum(field)].getOwner();
    }

    /** Returns the ID of the player that owns the neighbourhood. Returns 0 if unowned */
    public int getOwner(String nbh) {
        return neighbourhoods.get(nbh);
    }

    /** Marks the player as the owner of the field */
    public void claimField(int field, int player) {
        fields[posToNum(field)].setOwner(player);
    }

    /** Marks the player as the owner of the neighbourhood */
    public void claimNeighbourhood(String nbh, int player) {
        neighbourhoods.put(nbh,player);
    }

    /** Sets the number of houses present on the field */
    public void setHouses(int field, int houses) {
        fields[posToNum(field)].setHouses(houses);
    }

    /** Returns the number of houses present on the field */
    public int getHouses(int field) {
        return fields[posToNum(field)].getHouses();
    }

    /** Returns the current rent of the field */
    public int getRent(int field) {
        return fields[posToNum(field)].getRent();
    }

    /** Returns the rent of the field, given a number of houses/ferries/breweries owned */
    public int getRent(int field, int number) {
        return fields[posToNum(field)].getRent(number);
    }

    /** Returns the price of the field */
    public int getPrice(int field) {
        return fields[posToNum(field)].getPrice();
    }

    /** Returns the price of a house on the field */
    public int getHousePrice(int field) {
        return fields[posToNum(field)].getHouseprice();
    }

    /** Returns the amount of fields the player owns of a given type */
    public int getOwnedByType(String type, int player) {
        int temp = 0;
        for (Field i : fields) {
            if (i.getType() == type && i.getOwner() == player) {
                temp++;
            }
        }
        return temp;
    }

    /** Returns whether all fields in a neighbourhood is owned by the same player */
    public boolean checkNeighbourhood(String nbh, int player) {
        boolean temp = true;
        for (Field i : fields) {
            if (i.getNeighbourhood() == nbh) {
                if (i.getOwner() != player) {
                    temp = false;
                }
            }
        }
        return temp;
    }

    /** Returns the field type */
    public String getType(int field) {return fields[posToNum(field)].getType();}
}
