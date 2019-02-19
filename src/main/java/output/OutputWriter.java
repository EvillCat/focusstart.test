package output;

import pointer.Pointer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter {
    private BufferedWriter bufferedWriter;

    public OutputWriter(String path) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(Pointer pointer) {
        try {
            bufferedWriter.write((pointer.getPoint().toString()) + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
