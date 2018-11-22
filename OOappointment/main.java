import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Day[] week = {new Day("mon"),
                        new Day("tue"),
                        new Day("wed"),
                        new Day("thu"),
                        new Day("fri"),
                        new Day("sat"),
                        new Day("sun")};
        
        for(Day day: week){
            System.out.println(day.getName());
            System.out.println(day.getAppointments());;
        };

        Appointment t = new Appointment("Doc","00:30","12:00");
        week[2].append(t);

        for(Day day: week){
            System.out.println(day.getName());
            for(Appointment app: day.appointments){
                System.out.println(app.getName());
                System.out.println(app.getStartTime());
                System.out.println(app.getFinishTime());
            };
        };

        Appointment z = new Appointment("Doc","00:35","12:00");
        week[2].append(z);

        for(Day day: week){
            System.out.println(day.getName());
            for(Appointment app: day.appointments){
                System.out.println(app.getName());
                System.out.println(app.getStartTime());
                System.out.println(app.getFinishTime());
            };
        };
    }
}