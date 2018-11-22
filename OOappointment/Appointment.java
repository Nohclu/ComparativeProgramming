public class Appointment {
    private String name;
    private String startTime;
    private String finishTime;

    public Appointment(String name, String startTime, String finishTime){
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    private Boolean isValidTime(String time){
        String[] t = time.split(":");
        int t1 = (int) t[0];
        int t2 = (int) t[1];
        if (t1 > 23 || t2 > 59){
            return false;
        }
        return true;
    }

    public int timeToMinutes(int h, int m){
    }

    public String getName(){
        return name;
    }

    public String getStartTime(){
        return startTime;
    }
    
    public String getFinishTime(){
        return finishTime;
    }
}