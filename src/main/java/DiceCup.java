
public class DiceCup {
    /** The face value of the first die */
    private int faceVal1;
    /** The face value of the second die */
    private int faceVal2;
    /** The two die objects used in the class */
    private Die die1 = new Die(6);
    private Die die2 = new Die(6);

    /** Rolls two dice and returns the sum */
    public int rollDice() {
        faceVal1 = die1.rollDie();
        faceVal2 = die2.rollDie();
        return faceVal1+faceVal2;
    }

    /** Returns the face value of both die */
    public int[] getFaces() {
        int[] faces = {faceVal1,faceVal2};
        return faces;
    }

    /** Returns the sum of both die */
    public int getSum() {
        return faceVal1+faceVal2;
    }

    /** Returns whether the two die have the same face value */
    public boolean isPair() {
        return (faceVal1==faceVal2);
    }
}
