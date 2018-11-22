public class Appointment {
    private String name;
    private String startTime;
    private String finishTime;

    public Appointment(String name, String startTime, String finishTime){
        this.name = name;
        if (isValidTime(startTime) && isValidTime(finishTime)){
        this.startTime = startTime;
        this.finishTime = finishTime;
        }
        else {
        this.startTime = "00:00";
        this.finishTime = "00:00";
        }
    }

    private Boolean isValidTime(String time){
        String[] t = time.split(":");
        int t1 = Integer.parseInt(t[0]);
        int t2 = Integer.parseInt(t[1]);
        if (t1 > 23 || t2 > 59){
            return false;
        }
        return true;
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