public class Clase {

    //ESTA CLASE REPRESENTA UNA CLASE QUE SE DEBE ASIGNAR, CUYA INFO VIENE DEL DB

    public String edificio; // a travez de edificio podriamos saber nodo inicial...
    public int IDnum;
    public int dias;
    public int capacidadNecesaria;
    public int horaInicio;
    public int duracion; // 0 -> 50m, 1 -> 1:15...

    public Clase(String edificio,int IDnum,int dias, int capacidadNecesaria,int horaInicio, int duracion)
    {
        this.edificio = edificio;
        this.capacidadNecesaria = capacidadNecesaria;
        this.duracion = duracion;
        this.IDnum = IDnum;
        this.horaInicio = horaInicio;
        this.dias = dias;
    }

}
