import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Campus {
    Map<String, ArrayList<AdjDataClass>> campus = new HashMap<>();


    // nodos...
    ArrayList<AdjDataClass> CN = new ArrayList<>();

    ArrayList<AdjDataClass> IA = new ArrayList<>();
    ArrayList<AdjDataClass> NE = new ArrayList<>();
    ArrayList<AdjDataClass> CS = new ArrayList<>();
    ArrayList<AdjDataClass> SL = new ArrayList<>();
    ArrayList<AdjDataClass> HU = new ArrayList<>();
    ArrayList<AdjDataClass> CL = new ArrayList<>();

    public Campus()
    {
        IA.add( new AdjDataClass("CN",42));
        IA.add( new AdjDataClass("CL",77));

        CL.add( new AdjDataClass("IA",77));
        CL.add( new AdjDataClass("HU",215));
        CL.add( new AdjDataClass("CN",130));

        CN.add( new AdjDataClass("IA",42));
        CN.add( new AdjDataClass("CL",130));
        CN.add( new AdjDataClass("HU",216));
        CN.add( new AdjDataClass("CS",210));
        CN.add( new AdjDataClass("SL",510));

        NE.add( new AdjDataClass("CS",45));

        SL.add( new AdjDataClass("CS",310));
        SL.add( new AdjDataClass("CN",510));
        SL.add( new AdjDataClass("HU",645));

        CS.add( new AdjDataClass("NE",45));
        CS.add( new AdjDataClass("SL",310));
        CS.add( new AdjDataClass("CS",345));
        CS.add( new AdjDataClass("CN",210));

        HU.add( new AdjDataClass("CL",215));
        HU.add( new AdjDataClass("CN",216));
        HU.add( new AdjDataClass("CS",345));
        HU.add( new AdjDataClass("SL",645));

        campus.put("IA",IA);
        campus.put("CL",CL);
        campus.put("CN",CN);
        campus.put("NE",NE);
        campus.put("SL",SL);
        campus.put("CS",CS);
        campus.put("HU",HU);

    }

    public void PrintAdj(String edificio)
    {
        ArrayList<AdjDataClass> vecinos = campus.get(edificio);
        for (AdjDataClass vecino : vecinos)
        {
            System.out.println("nodos vecinos " + vecino.node +" " + vecino.distancia);
        }

    }
}
