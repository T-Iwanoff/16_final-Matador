import java.util.HashMap;

public class FieldController {

    private HashMap<String, Integer> neighbourhoods = new HashMap<>();
    private Field[] fields;

    public FieldController() {
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

    }


}
