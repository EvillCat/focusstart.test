package input;

import org.apache.commons.io.input.ReversedLinesFileReader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class ReverseOrderReader extends InputFileReader {

    private ReversedLinesFileReader reverseReader;

    public ReverseOrderReader(String path) {
        File file = new File(path);
        try {
            reverseReader = new ReversedLinesFileReader(file, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readLine() {
        try {
            return reverseReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void close() {
        try {
            reverseReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
