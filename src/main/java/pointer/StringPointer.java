package pointer;

import input.InputFileReader;

public class StringPointer extends Pointer<String> {

    public StringPointer(InputFileReader reader) {
        super(reader);
        next();
    }

    @Override
    public void next() {
        setPoint(getReader().readLine());
    }
}
