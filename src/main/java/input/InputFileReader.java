package input;

import java.io.Closeable;

public abstract class InputFileReader implements Closeable {

    public abstract String readLine();

    public abstract void close();

}
