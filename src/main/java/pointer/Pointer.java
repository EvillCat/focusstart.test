package pointer;

import input.InputFileReader;

public abstract class Pointer<T> {

    private T point;

    private InputFileReader reader;

    public Pointer(InputFileReader reader) {
        this.reader = reader;
    }

    public InputFileReader getReader() {
        return reader;
    }

    public abstract void next();

    public T getPoint() {
        return point;
    }

    public void setPoint(T point) {
        this.point = point;
    }
}
