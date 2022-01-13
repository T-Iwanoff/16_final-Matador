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
        fields[i++] = new GUI_Start(Language.getLine("f1_title"), Language.getLine("f1_subtext"), Language.getLine("f1_desc"), Color.RED, Color.BLACK);
        fields[i++] = new GUI_Street(Language.getLine("f2_title"), Language.getLine("f2_subtext"), Language.getLine("f2_desc"), "", new Color(75, 155, 225), Color.BLACK);
        fields[i++] = new GUI_Chance(Language.getLine("fC_title"), Language.getLine("fC_subtext"), Language.getLine("fC_desc"), Color.BLACK, Color.YELLOW);
        fields[i++] = new GUI_Street(Language.getLine("f4_title"), Language.getLine("f4_subtext"), Language.getLine("f4_desc"), "", new Color(75, 155, 225), Color.BLACK);
        fields[i++] = new GUI_Tax(Language.getLine("f5_title"), Language.getLine("f5_subtext"), Language.getLine("f5_desc"), new Color(244,164,96), Color.BLACK);
        fields[i++] = new GUI_Shipping("default", Language.getLine("f6_title"), Language.getLine("f6_subtext"), Language.getLine("f6_desc"), "", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street(Language.getLine("f7_title"), Language.getLine("f7_subtext"), Language.getLine("f7_desc"), "", new Color(255,165,0), Color.BLACK);
        fields[i++] = new GUI_Chance(Language.getLine("fC_title"), Language.getLine("fC_subtext"), Language.getLine("fC_desc"), Color.BLACK, Color.YELLOW);
        fields[i++] = new GUI_Street(Language.getLine("f9_title"), Language.getLine("f9_subtext"), Language.getLine("f9_desc"), "", new Color(255,165,0), Color.BLACK);
        fields[i++] = new GUI_Street(Language.getLine("f10_title"), Language.getLine("f10_subtext"), Language.getLine("f10_desc"), "", new Color(255,165,0), Color.BLACK);
        fields[i++] = new GUI_Jail("default", Language.getLine("f11_title"), Language.getLine("f11_subtext"), Language.getLine("f11_desc"), new Color(125, 125, 125), Color.BLACK);
        fields[i++] = new GUI_Street(Language.getLine("f12_title"), Language.getLine("f12_subtext"), Language.getLine("f12_desc"), "", new Color(102, 204, 0), Color.BLACK);
        fields[i++] = new GUI_Brewery("default", Language.getLine("f13_title"), Language.getLine("f13_subtext"), Language.getLine("f13_desc"), "", Color.BLACK, Color.WHITE);
        fields[i++] = new GUI_Street(Language.getLine("f14_title"), Language.getLine("f14_subtext"), Language.getLine("f14_desc"), "", new Color(102, 204, 0), Color.BLACK);
        fields[i++] = new GUI_Street(Language.getLine("f15_title"), Language.getLine("f15_subtext"), Language.getLine("f15_desc"), "", new Color(102, 204, 0), Color.BLACK);
        fields[i++] = new GUI_Shipping("default", Language.getLine("f16_title"), Language.getLine("f16_subtext"), Language.getLine("f16_desc"), "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street(Language.getLine("f17_title"), Language.getLine("f17_subtext"), Language.getLine("f17_desc"), "", new Color(153, 153, 153), Color.BLACK);
        fields[i++] = new GUI_Chance(Language.getLine("fC_title"), Language.getLine("fC_subtext"), Language.getLine("fC_desc"), Color.BLACK, Color.YELLOW);
        fields[i++] = new GUI_Street(Language.getLine("f19_title"), Language.getLine("f19_subtext"), Language.getLine("f19_desc"), "", new Color(153, 153, 153), Color.BLACK);
        fields[i++] = new GUI_Street(Language.getLine("f20_title"), Language.getLine("f20_subtext"), Language.getLine("f20_desc"), "", new Color(153, 153, 153), Color.BLACK);
        fields[i++] = new GUI_Refuge("default", Language.getLine("f21_title"), Language.getLine("f21_subtext"), Language.getLine("f21_desc"), Color.PINK, Color.BLACK);
        fields[i++] = new GUI_Street(Language.getLine("f22_title"), Language.getLine("f22_subtext"), Language.getLine("f22_desc"), "", Color.RED, Color.BLACK);
        fields[i++] = new GUI_Chance(Language.getLine("fC_title"), Language.getLine("fC_subtext"), Language.getLine("fC_desc"), Color.BLACK, Color.YELLOW);
        fields[i++] = new GUI_Street(Language.getLine("f24_title"), Language.getLine("f24_subtext"), Language.getLine("f24_desc"), "", Color.RED, Color.BLACK);
        fields[i++] = new GUI_Street(Language.getLine("f25_title"), Language.getLine("f25_subtext"), Language.getLine("f25_desc"), "", Color.RED, Color.BLACK);
        fields[i++] = new GUI_Shipping("default", Language.getLine("f26_title"), Language.getLine("f26_subtext"), Language.getLine("f26_desc"), "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street(Language.getLine("f27_title"), Language.getLine("f27_subtext"), Language.getLine("f27_desc"), "", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street(Language.getLine("f28_title"), Language.getLine("f28_subtext"), Language.getLine("f28_desc"), "", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Brewery("default", Language.getLine("f29_title"), Language.getLine("f29_subtext"), Language.getLine("f29_desc"), "", Color.BLACK, Color.WHITE);
        fields[i++] = new GUI_Street(Language.getLine("f30_title"), Language.getLine("f30_subtext"), Language.getLine("f30_desc"), "", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Jail("default", Language.getLine("f31_title"), Language.getLine("f31_subtext"), Language.getLine("f31_desc"), new Color(125, 125, 125), Color.BLACK);
        fields[i++] = new GUI_Street(Language.getLine("f32_title"), Language.getLine("f32_subtext"), Language.getLine("f32_desc"), "", new Color(255, 255, 50), Color.BLACK);
        fields[i++] = new GUI_Street(Language.getLine("f33_title"), Language.getLine("f33_subtext"), Language.getLine("f33_desc"), "", new Color(255, 255, 50), Color.BLACK);
        fields[i++] = new GUI_Chance(Language.getLine("fC_title"), Language.getLine("fC_subtext"), Language.getLine("fC_desc"), Color.BLACK, Color.YELLOW);
        fields[i++] = new GUI_Street(Language.getLine("f35_title"), Language.getLine("f35_subtext"), Language.getLine("f35_desc"), "", new Color(255, 255, 50), Color.BLACK);
        fields[i++] = new GUI_Shipping("default", Language.getLine("f36_title"), Language.getLine("f36_subtext"), Language.getLine("f36_desc"), "", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Chance(Language.getLine("fC_title"), Language.getLine("fC_subtext"), Language.getLine("fC_desc"), Color.BLACK, Color.YELLOW);
        fields[i++] = new GUI_Street(Language.getLine("f38_title"), Language.getLine("f38_subtext"), Language.getLine("f38_desc"), "", new Color(150, 60, 150), Color.WHITE);
        fields[i++] = new GUI_Tax(Language.getLine("f39_title"), Language.getLine("f39_subtext"), Language.getLine("f39_desc"), new Color(244,164,96), Color.BLACK);
        fields[i] = new GUI_Street(Language.getLine("f40_title"), Language.getLine("f40_subtext"), Language.getLine("f40_desc"), "", new Color(150, 60, 150), Color.WHITE);

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
