import java.awt.Color;
import gui_fields.GUI_Car;
import gui_fields.GUI_Car.Pattern;
import gui_fields.GUI_Car.Type;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

/**
 * The Player class represents the player with their counterpart GUI_Player, field position,
 * player status (whether they are still playing/in the game and whether they are in jail or not)
 * and whether they have a jail card or not.
 */

public class Player {
    private boolean inJail = false;
    private boolean jailCard = false;
    private int position = 0;
    private GUI_Player GUIPlayer;
    private String name;

    /** Constructor */
    public Player(String name) {
        this.name = name;
        GUIPlayer = new GUI_Player(name, 30000, getRandomCar());
        GUICreator.getInstance().addPlayer(GUIPlayer);
        GUICreator.getInstance().getFields()[position].setCar(GUIPlayer,true);
    }

    /** Creates a randomized game piece */
    private GUI_Car getRandomCar()
    {
        Type[] types = new Type[4];
        types[0] = Type.CAR;
        types[1] = Type.RACECAR;
        types[2] = Type.TRACTOR;
        types[3] = Type.UFO;
        return new GUI_Car(
                new Color((int) (Math.random() * 249) + 1, (int) (Math.random() * 249) + 1,
                        (int) (Math.random() * 249) + 1),
                Color.white, types[(int) (Math.random() * 4)], Pattern.FILL);
    }

    /** Moves the player a given distance */
    public void movePlayer(int fields) {
        GUI_Field[] guiFields = GUICreator.getInstance().getFields();
        for (int i = 0; i < fields; i++) {
            guiFields[position].setCar(GUIPlayer, false);
            position++;
            if (position == guiFields.length) {
                position = 0;
            }
            guiFields[position].setCar(GUIPlayer, true);
            try {
                Thread.sleep(250L);
            }
            catch (Exception e) {}
        }
    }

    /** Returns the GUI_Player */
    public GUI_Player getGUIPlayer() {return GUIPlayer;}

    /** Returns whether the player is jailed */
    public boolean getJailStatus() {return inJail;}

    /** Sets whether the player is jailed */
    public void setJailStatus(boolean inJail) {this.inJail = inJail;}

    /** Returns whether the player has a 'get out of jail' card */
    public boolean getJailCard() {return jailCard;}

    /** Sets whether the player has a 'get out of jail' card */
    public void setJailCard(boolean jailCard) {this.jailCard = jailCard;}

    /** Returns the player's position */
    public int getPosition() {return position;}

    /** Sets the player's position */
    public void setPosition(int position) {this.position = position;}

    /** Returns the player's name */
    public String getName() {return name;}
}
