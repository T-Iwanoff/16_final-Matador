public class Cards {
    private int identification, action, value;

    /** Constructor for cards */
    public Cards(int ID,int act, int val) {
        this.identification = ID;
        this.action = act;
        this.value = val;
    }

    public int getID() {
        return identification;
    }
    public int getAction() {
        return action;
    }
    public int getValue() {
        return value;
    }
}
