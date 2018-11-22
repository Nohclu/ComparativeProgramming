import java.util.ArrayList;

public class Day {
    private String name;
    public ArrayList<Appointment> appointments = new ArrayList<>();

    public Day(String name){
        this.name = name;
    }

    public void append(Appointment app){
        if (overlap(app)){
            System.out.println("Appointment Overlap");
        }
        else{
            System.out.println("Appointment added");
            this.appointments.add(app);
        }
    }

    public int timeToMinutes(String time){
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]);
        int min = Integer.parseInt(t[1]);
        int total = (hour * 60) + min;
        return total;
    }
    
    private Boolean overlap(Appointment app){
        int newStart = timeToMinutes(app.getStartTime());
        int newFinish = timeToMinutes(app.getFinishTime());
        for(Appointment appointment: appointments ){
            if (timeToMinutes(appointment.getStartTime()) < newStart
                && timeToMinutes(appointment.getFinishTime()) > newStart
                || timeToMinutes(appointment.getStartTime()) < newFinish
                && timeToMinutes(appointment.getFinishTime()) > newFinish){
                    return true;
                }
        }
        return false;
    }

    public String getName(){
        return name;
    }
    
    public ArrayList getAppointments(){
        return appointments;
    }
}