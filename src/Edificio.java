import java.util.ArrayList;
import java.util.Random;

public class Edificio {

    public String nombre =""; // CN, IA...
    public int salonesTotales = 0; // CN tiene x salones...
    private int salonesActuales = 100; // CN TIENE X salones actualmente (en este momento)

    private ArrayList<Salon> edificioSalones = new ArrayList<>(); // hold edificio salones
    private static Random random = new Random(); // random to initialize edificios...
    private Horarios horarios;

    public Edificio(String nombre, int numSalones,Horarios horarios)
    {
        this.nombre = nombre;
        this.salonesTotales = numSalones;
        this.horarios = horarios;
    }


    public void SetEdificio() // agrega "numSalones" salones. inicializar capacidad 15 a 25 de los salones
    {
        for(int i = 0; i<=salonesTotales; i++)
        {
            String salonID = this.nombre + salonesActuales;
            edificioSalones.add(new Salon(salonID,random.nextInt(15,25))); //15 a 25 random (creo xd)
            salonesActuales++;
        }
    }


    // ESTA FUNCION RECIBE UNA INSTANCIA DE LA CLASE "CLASE" QUE DEBERIA SER OBTENIDA DEL DB

    public boolean addClass(Clase clase) // esta funcion se llama si este es el edificio mas cercano...
    {
        sortListByCapacity();

        int index = getClosestCapClass(clase.capacidadNecesaria);

        for(int i = index; i < edificioSalones.size(); i++ )
        {
            Salon salon2Add = new Salon(clase.edificio+ clase.IDnum,clase.capacidadNecesaria);

            if(horarios.AssignHorario(salon2Add,clase.dias,clase.horaInicio,clase.duracion))
            {
                // si el salon esta disponible en el horario...
                return true;
            }
        }


     return false;
    }

    private void sortListByCapacity()
    {
        // to do...
        // primer elemento es capacidad mas pequeña...
    }

    private int getClosestCapClass(int capacidad) //return index where capacity is = or mmore
    {
        int sal = 0;
        for(int i = 0; i<edificioSalones.size(); i++)
        {
            if(edificioSalones.get(i).capacidad >= capacidad)
            {
                sal = i;
                break;
            }
        }
        return sal;
    }







}
