import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Map<String, Day> week = new HashMap<String, Day>();
        week.put("mon", new Day("mon"));
        week.put("tue", new Day("tue"));
        week.put("wed", new Day("wed"));
        week.put("thu", new Day("thu"));
        week.put("fri", new Day("fri"));
        week.put("sat", new Day("sat"));
        week.put("sun", new Day("sun"));

        Scanner scan = new Scanner(System.in);
        System.out.println("Loop Start");
        while (true){
            String input = scan.nextLine();
           
            if (input.equals("add")){
                System.out.println("Enter: day name start finish ex. mon dentist 08:43 14:30");
                String newAppDet = scan.nextLine();
                String[] userInput = newAppDet.split(" ");
                for ( String key : week.keySet()) {
                    if (key.equals(userInput[0])){
                        Day day = week.get(key);
                        day.append(new Appointment(userInput[1],userInput[2],userInput[3]));
                        break;
                    }
                }
            }
            if (input.equals("show")){
                System.out.println("Enter: day ex. tue");
                String userInput = scan.nextLine();
                for ( String key : week.keySet()) {
                    if (key.equals(userInput)){
                        Day day = week.get(key);
                        System.out.println(day.getAppointments());
                        for (Appointment app: day.appointments){
                            System.out.println(app.getName() +" "+app.getStartTime()+" "+app.getFinishTime());
                        }
                        break;
                    }
                }
            }

            if (input.equals("quit")){
                break;
            }

        }
    }
}