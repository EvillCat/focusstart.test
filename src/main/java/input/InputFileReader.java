package input;

public abstract class InputFileReader {

    public abstract String readLine();

    public abstract void close();

    public static InputFileReader createCurrentReader(String path, boolean sortOrder) {
        if (sortOrder)
            return new DirectOrderReader(path);
        else
            return new ReverseOrderReader(path);
    }
}
