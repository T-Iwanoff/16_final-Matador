import java.awt.Color;
import gui_fields.GUI_Car;
import gui_fields.GUI_Car.Pattern;
import gui_fields.GUI_Car.Type;
import gui_fields.GUI_Player;

/**
 * The Player class represents the player with their counterpart GUI_Player, field position,
 * player status (whether they are still playing/in the game and whether they are in jail or not)
 * and whether they have a jail card or not.
 */

public class Player {

    private boolean playing = true;
    private boolean inJail = false;
    private boolean jailCard = false;
    private int position = 0;
    private GUI_Player GUIPlayer;
    private String name;

    public Player(String name) {
        this.name = name;
        GUIPlayer = new GUI_Player(name, 0, getRandomCar());
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

    public GUI_Player getGUIPlayer() {
        return GUIPlayer;
    }

}
