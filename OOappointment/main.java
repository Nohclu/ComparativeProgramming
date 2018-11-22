public class main {
    public static void main(String[] args) {
        Day[] test = {new Day("mon"),
                        new Day("tue"),
                        new Day("wed"),
                        new Day("thu"),
                        new Day("fri"),
                        new Day("sat"),
                        new Day("sun")};
        System.out.print(test[2].getName());
    }
}