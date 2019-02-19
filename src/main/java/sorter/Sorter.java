package sorter;

import output.OutputWriter;
import pointer.Pointer;

import java.util.LinkedList;
import java.util.List;

class Sorter<T extends Comparable<T>> {
    private List<Pointer<T>> pointers = new LinkedList<>();
    private OutputWriter writer;
    private boolean isSortOrderAsc;

    Sorter(String path, boolean isSortOrderAsc) {
        writer = new OutputWriter(path);
        this.isSortOrderAsc = isSortOrderAsc;
    }

    void addPointer(Pointer<T> pointer) {
        pointers.add(pointer);
    }

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

    //Метод проверяет не нарушает ли последующий элемент последовательности порядка сортировки
    //в сравнении с предыдущим элементом. Если нарушает, то метод просто читает следующий элемент
    private void checkNextValueOnSortOrder(Pointer<T> current) {
        T previousValue = current.getPoint();
        current.next();
        T nextValue = current.getPoint();
        if (nextValue == null)
            return;
        if (isSortOrderAsc && previousValue.compareTo(nextValue) > 0) {
            checkNextValueOnSortOrder(current);
        }
        if (!isSortOrderAsc && previousValue.compareTo(nextValue) < 0) {
            checkNextValueOnSortOrder(current);
        }
    }

    private void writeCurrentAndDoNext(Pointer<T> current) {
        writer.write(current);
        checkNextValueOnSortOrder(current);
        if (current.getPoint() == null) {
            current.getReader().close();
            pointers.remove(current);
        }
    }

    void sortAndWrite() {
        if (isSortOrderAsc) {
            while (pointers.size() != 0) {
                writeCurrentAndDoNext(findMin());
            }
        } else {
            while (pointers.size() != 0) {
                writeCurrentAndDoNext(findMax());
            }
        }
        writer.close();
    }
}
