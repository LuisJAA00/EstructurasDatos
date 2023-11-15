import java.util.ArrayList;

public class Horarios {

    private ArrayList<Salon>[][] horarios = new ArrayList[29][4]; // 5 dias, 30 posibles hroas (dividir 7-22 en intervalos de 30m)
    public Horarios()
    {
        for(int i = 0; i< 4;i++)
        {
            for(int j = 0; j<29; j++)
            {
                horarios[j][i] = new ArrayList<>();
            }
        }
    }

    public boolean AssignHorario(Salon salon, int dia, double hora, int duracion)
    {
        int horaInt = HoraFromDouble2Int(hora);
        duracion = RoundUp(duracion); // las clases deben acabar a las en punto o y media
       if( Available(salon,dia,horaInt,duracion))
       {
           for ( int i = horaInt; i < hora + RoundUp(duracion); i++)
           {
               horarios[i][dia].add(salon);
           }
           System.out.println("agregando horario...");
           return true;
       }
        System.out.println("Horario ocupado...");
        return false;
    }

    public boolean Available(Salon salon,int dia, int hora, int duracion)
    {
        for ( int i = hora; i < hora + duracion; i++)
        {
            if(isInList(horarios[i][dia],salon.ID))
            {
                return false;
            }
        }


        return true;
    }

    // entrada "7.5 -> sal 1" (1 = 7:30, 2 = 8:00 ...)
    private int HoraFromDouble2Int(double num)
    {
        int result = (int)(2*num - 14);
        if(result<0)
        {
            return 9999;
        }
        else{
            return result;
        }

    }

    // entrada: duracion -> 0 = 50m, 1 -> 1:15, 2 -> 1:40
    private int RoundUp(int num)
    {
        int sal=0;
        switch (num)
        {
            case 0: // 50M
                sal = 2;
                break;
            case 1: // 1:15
                sal = 3;
                break;
            case 2: //1:40
                sal = 4;
                break;
            default:
                System.out.println("duracion out of range");
                break;
        }
        return sal;
    }

    private boolean isInList(ArrayList<Salon> salones, String ID)
    {
            for (Salon salon: salones) {
                if(salon.ID == ID)
                {
                    return true;
                }
            }
        return false;
    }
}
