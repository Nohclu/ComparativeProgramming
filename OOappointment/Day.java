import java.util.ArrayList;

public class Day {
    private String name;
    ArrayList<Appointment> appointments = new ArrayList<Appointment>();

    public Day(String name){
        this.name = name;
    }

    public void append(Appointment app){
        appointments.add(app);
    }
    
    private Boolean overlap(Appointment app){
        // split appointment
        // cnvrt start end to mins
        return true;
    }

    public String getName(){
        return name;
    }
    
    public ArrayList getAppointments(){
        return appointments;
    }
}