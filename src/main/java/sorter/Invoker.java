package sorter;

import input.DirectOrderReader;
import input.InputFileReader;
import input.ReverseOrderReader;
import parser.Parser;
import pointer.IntegerPointer;
import pointer.Pointer;
import pointer.StringPointer;

import java.util.List;

public class Invoker {

    private Parser parser;
    private Sorter<?> sorter;
    private List<String> inputFiles;
    private boolean sortOrder;

    public Invoker(String[] args) throws Exception {
        parser = new Parser(args);
        inputFiles = parser.inputFiles();
        sortOrder = parser.isSortOrderAscending();
        sorter = new Sorter<>(parser.outputFilePath(), sortOrder);
    }

    private InputFileReader createReader(String path) {
        if (parser.isSortOrderAscending()) {
            return new DirectOrderReader(path);
        } else {
            return new ReverseOrderReader(path);
        }
    }

    private void addPointersToBuffer() {
        Pointer pointer;
        for (String path : inputFiles) {
            pointer = parser.isSortTypeString()
                    ? new StringPointer(createReader(path))
                    : new IntegerPointer(createReader(path));
            sorter.addPointer(pointer);
        }
    }

    public void sort() {
        addPointersToBuffer();
        sorter.sortAndWrite();
    }
}
