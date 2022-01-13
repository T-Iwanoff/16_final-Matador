import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public final class GUICreator {
    // Static variable reference of single_instance
    // of type Singleton
    private static GUI single_instance = null;


    // Constructor
    private GUICreator() {}

    private static GUI createGUI() {

        // Creates an array for the fields
        GUI_Field[] fields = new GUI_Field[40];

        // Creates the fields
        int i = 0;
        fields[i++] = new GUI_Start("Start", "Modtag: 200", "Modtag kr. 200,-\nnår de passerer start", Color.RED, Color.BLACK);
        fields[i++] = new GUI_Street("Rødovrevej", "Pris:  60", "Rødovrevej", "Leje:  20", new Color(75, 155, 225), Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", Color.BLACK, Color.YELLOW);
        fields[i++] = new GUI_Street("Hvidovrevej", "Pris:  60", "Hvidovrevej", "Leje:  20", new Color(75, 155, 225), Color.BLACK);
        fields[i++] = new GUI_Tax("Betal\nindkomst-\nskat", "10% el. 200", "Betal indkomstskat\n10% eller kr. 200,-", new Color(244,164,96), Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "Øresund", "Pris:  200", "Øresundsredderiet", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("Roskildevej", "Pris:  100", "Roskildevej", "Leje:  40", new Color(255,165,0), Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", Color.BLACK, Color.YELLOW);
        fields[i++] = new GUI_Street("Valby\nLanggade", "Pris:  100", "Valby Langgade", "Leje:  40", new Color(255,165,0), Color.BLACK);
        fields[i++] = new GUI_Street("Allégade", "Pris:  120", "Allégade", "Leje:  45", new Color(255,165,0), Color.BLACK);
        fields[i++] = new GUI_Jail("default", "Fængsel", "Fængsel", "På besøg i fængslet", new Color(125, 125, 125), Color.BLACK);
        fields[i++] = new GUI_Street("Frederiks-\nberg Allé", "Pris:  140", "Frederiksberg Allé", "Leje:  50", new Color(102, 204, 0), Color.BLACK);
        fields[i++] = new GUI_Brewery("default", "Tuborg", "Pris:  150", "Tuborg bryggeri", "10 x [Terningslag]", Color.BLACK, Color.WHITE);
        fields[i++] = new GUI_Street("Bülowsvej", "Pris:  140", "Bülowsvej", "Leje:  50", new Color(102, 204, 0), Color.BLACK);
        fields[i++] = new GUI_Street("Gammel Kongevej", "Pris:  140", "Gammel Kongevej", "Leje:  50", new Color(102, 204, 0), Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("Bernstorffsvej", "Pris:  180", "Bernstorffsvej", "Leje:  60", new Color(153, 153, 153), Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", Color.BLACK, Color.YELLOW);
        fields[i++] = new GUI_Street("Hellerupvej", "Pris:  180", "Hellerupvej", "Leje:  60", new Color(153, 153, 153), Color.BLACK);
        fields[i++] = new GUI_Street("Strandvejen", "Pris:  180", "Strandvejen", "Leje:  60", new Color(153, 153, 153), Color.BLACK);
        fields[i++] = new GUI_Refuge("default", "Helle", "Helle", "Ta' en pause", Color.PINK, Color.BLACK);
        fields[i++] = new GUI_Street("Trianglen", "Pris:  220", "Trianglen", "Leje:  70", Color.RED, Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", Color.BLACK, Color.YELLOW);
        fields[i++] = new GUI_Street("Østerbro-\ngade", "Pris:  220", "Østerbrogade", "Leje:  70", Color.RED, Color.BLACK);
        fields[i++] = new GUI_Street("Grønningen", "Pris:  240", "Grønningen", "Leje:  80", Color.RED, Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "Ø.S.", "Pris:  200", "Ø.S. redderiet", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("Bredgade", "Pris:  260", "Bredgade", "Leje:  80", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("Kgs. Nytorv", "Pris:  260", "Kongens Nytorv", "Leje:  80", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Brewery("default", "Carlsberg", "Pris:  150", "Carlsberg bryggeri", "10 x [Terningslag]", Color.BLACK, Color.WHITE);
        fields[i++] = new GUI_Street("Østergade", "Pris:  280", "Østergade", "Leje:  85", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Jail("default", "Gå i fængsel", "Gå i fængsel", "De fængsles\nSlå to ens for at komme ud", new Color(125, 125, 125), Color.BLACK);
        fields[i++] = new GUI_Street("Amagertorv", "Pris:  300", "Amagertorv", "Leje:  95", new Color(255, 255, 50), Color.BLACK);
        fields[i++] = new GUI_Street("Vimmel-\nskaftet", "Pris:  300", "Vimmelskaftet", "Leje:  95", new Color(255, 255, 50), Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", Color.BLACK, Color.YELLOW);
        fields[i++] = new GUI_Street("Nygade", "Pris:  320", "Nygade", "Leje:  100", new Color(255, 255, 50), Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "Bornholm", "Pris:  200", "Bornholms redderi", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", Color.BLACK, Color.YELLOW);
        fields[i++] = new GUI_Street("Frederiks-\nberggade", "Pris:  350", "Frederiksberggade", "Leje:  120", new Color(150, 60, 150), Color.WHITE);
        fields[i++] = new GUI_Tax("Ekstra-\nordinær\nstatsskat", "Betal 100", "Betal ekstraordinær\nstatsskat: kr. 100,-", new Color(244,164,96), Color.BLACK);
        fields[i] = new GUI_Street("Rådhuspladsen", "Pris:  400", "Rådhuspladsen", "Leje:  150", new Color(150, 60, 150), Color.WHITE);

        //Creates the board based on the specified array
        GUI GUI = new GUI(fields);
        GUI.setChanceCard(Language.getLine("card_none"));
        return GUI;
    }

    // Static method to create instance of GUI
    public static GUI getInstance()
    {
        if (single_instance == null)
            single_instance = createGUI();

        return single_instance;
    }
}
