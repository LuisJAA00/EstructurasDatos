public class Main {
    public static void main(String[] args) {

        Horarios horarios = new Horarios(); // matriz con horarios de toda la uni xd
        Salon IA202 = new Salon("IA202",15);


        horarios.AssignHorario(IA202,0,7.5,0); // lunes 7:30 -> 8:20, 50m
        horarios.AssignHorario(IA202,0,8,0); // lunes 8:00 -> 8:50, 50m






    }
}