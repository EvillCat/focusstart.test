package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    private List<String> argsList;

    public Parser(String[] args) {
        argsList = Arrays.asList(args);
    }

    public boolean isSortOrderAscending() {
        return argsList.contains("-a") | !argsList.contains("-d");
    }

    public boolean isSortTypeString() {
        return argsList.contains("-s");
    }

    public String outputFilePath() throws Exception {

        String result = null;

        for (String outputFile : argsList) {
            if (outputFile.contains("out")) {
                result = outputFile;
                break;
            }
        }
        if (result == null) {
            throw new Exception("Не указан файл для записи данных. Имя файла должно содержать \"out\"");
        }
        return result;
    }

    public List<String> inputFiles() throws Exception {

        List<String> inputFiles = new ArrayList<>();

        for (String inputFile : argsList) {
            if (inputFile.contains("in"))
                inputFiles.add(inputFile);
        }
        if (inputFiles.size() == 0) {
            throw new Exception("Не указан(ы) входной(ые) файл(ы). Имя(на) файла(ов) должно(ы) содержать \"in\"");
        }
        return inputFiles;
    }
}
