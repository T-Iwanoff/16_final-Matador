public class Cards {
    private int identification, value;
    private String action;
    /** Constructor for cards */
    public Cards(int ID, String act, int val) {
        this.identification = ID;
        this.action = act;
        this.value = val;
    }

    public int getID() {
        return identification;
    }
    public String getAction() {
        return action;
    }
    public int getValue() {
        return value;
    }
}
