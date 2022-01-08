package intensive.project.collections;


public interface List<E> {
    void add(E element);
    void add(E element, int index);
    int getSize();
    E get(int index);
    E[] getAll();
    void set(E element, int index);
    void remove(int index);
}
