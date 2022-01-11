
public class Die {
    /** Number of faces on the die */
    private int faces;
    /** The face the dice is currently showing */
    private int showingFace = 1;

    /**
     * Initializes a new die.
     *
     * @param faces Number of faces on the die.
     */
    public Die(int faces)
    {
        this.faces = faces;
    }

    /**
     * Rolls the die.
     *
     * @return Face value of the die.
     */
    public int rollDie()
    {
        showingFace = (int) (Math.random() * faces) + 1;
        return showingFace;
    }

    public int getShowingFace()
    {
        return showingFace;
    }
}
