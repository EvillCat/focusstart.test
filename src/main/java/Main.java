import sorter.Invoker;

public class Main {

    public static void main(String[] args) {

        try {
            Invoker invoker = new Invoker(args);
            invoker.sort();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
