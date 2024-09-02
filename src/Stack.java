import java.util.Collection;

public interface Stack<E> {
    // добавляет новый элемент в начало стека
    void push(E element) throws StackException;

    // возвращаем и удаляем верхний элемент стека
    E pop() throws StackException;

    // возвращает верхний элемент, но не удаляет из стека
    E peek();

    // возвращает количество элементов в стеке
    int getSize();

    boolean isEmpty();

    boolean isFull();

    // добавляем все элементы из параметра src в стек
    void pushAll(Collection<? extends E> src) throws StackException;

    // помещаем все элементы из стека в параметр dst
    void popAll(Collection<? super E> dst) throws StackException;
}
