import java.util.HashMap;

public class Fields {

    private HashMap<String, Integer> neighbourhoods = new HashMap<>();
    private Field[] fields;

    public Fields() {
        fields = new Field[28];
        fields[0] = new Field(1, 1200, 1000, 50, 250, 750, 2250, 4000, 6000, "Street", "Blue");
    }


}
