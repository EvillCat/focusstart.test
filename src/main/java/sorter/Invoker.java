package sorter;

import input.InputFileReader;
import parser.Parser;
import pointer.IntegerPointer;
import pointer.Pointer;
import pointer.StringPointer;

import java.util.List;

public class Invoker {

    private Parser parser;
    private Sorter<?> sorter;
    private Pointer pointer;
    private String outputFilePath;
    private List<String> inputFiles;
    private boolean sortOrder;

    public Invoker(String[] args) throws Exception{
        parser = new Parser(args);
        outputFilePath = parser.outputFilePath();
        inputFiles = parser.inputFiles();
        sortOrder = parser.isSortOrderAscending();
        sorter = new Sorter<>(outputFilePath, sortOrder);
    }

    private void addPointersToBuffer() {
        for (String path : inputFiles) {
            pointer = parser.isSortTypeString()
                    ? new StringPointer(InputFileReader.createCurrentReader(path, sortOrder))
                    : new IntegerPointer(InputFileReader.createCurrentReader(path, sortOrder));
            sorter.addPointer(pointer);
        }
    }

    public void sort(){
        addPointersToBuffer();
        sorter.sortAndWrite();
    }
}
