package pointer;

import input.InputFileReader;

public class IntegerPointer extends Pointer<Integer> {

    public IntegerPointer(InputFileReader reader) {
        super(reader);
        next();
    }

    @Override
    public void next() {
        String str = getReader().readLine();
        if (str == null) {
            setPoint(null);
        } else {
            try {
                setPoint(Integer.valueOf(str));
            } catch (NumberFormatException ex) {
                next();
                ex.printStackTrace();
            }
        }
    }
}
