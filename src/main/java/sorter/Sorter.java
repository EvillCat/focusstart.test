package sorter;

import output.OutputWriter;
import pointer.Pointer;

import java.util.LinkedList;
import java.util.List;

public class Sorter<T extends Comparable<T>> {
    private List<Pointer<T>> pointers = new LinkedList<>();
    private OutputWriter writer;
    private boolean isSortOrderAsc;

    public Sorter(String path, boolean isSortOrderAsc) {
        writer = new OutputWriter(path);
        this.isSortOrderAsc = isSortOrderAsc;
    }

    public void addPointer(Pointer pointer) {
        pointers.add(pointer);
    }

//    private boolean isPointersBufferEmpty() {
//        for (int i = 0; i < pointers.size(); i++) {
//            if (pointers.get(i).getPoint() == null) {
//                pointers.remove(i);
//            }
//        }
//        return pointers.size() != 0;
//    }

    private Pointer<T> findMin() {
        Pointer<T> currentMin = pointers.get(0);
        Pointer<T> currentElement;
        for (int i = 1; i < pointers.size(); ++i) {
            currentElement = pointers.get(i);
            if (currentElement.getPoint().compareTo(currentMin.getPoint()) < 0) {
                currentMin = currentElement;
            }
        }
        return currentMin;
    }

    private Pointer<T> findMax() {
        Pointer<T> currentMax = pointers.get(0);
        Pointer<T> currentElement;
        for (int i = 1; i < pointers.size(); ++i) {
            currentElement = pointers.get(i);
            if (currentElement.getPoint().compareTo(currentMax.getPoint()) > 0) {
                currentMax = currentElement;
            }
        }
        return currentMax;
    }

    public void sortAndWrite() {

        if (isSortOrderAsc) {
            while (pointers.size() != 0) {
                Pointer<T> currentMin = findMin();
                writer.write(currentMin);
                currentMin.next();
                if (currentMin.getPoint() == null) {
                    pointers.remove(pointers.indexOf(currentMin));
                }
            }
        } else {
            while (pointers.size() != 0) {
                Pointer<T> currentMax = findMax();
                writer.write(currentMax);
                currentMax.next();
                if (currentMax.getPoint() == null) {
                    pointers.remove(pointers.indexOf(currentMax));
                }
            }
        }
        writer.close();
    }
}
