import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayStack<E> implements Stack<E> {
    private List<E> stack;
    private int maxSize;

    // Конструктор
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new ArrayList<>(maxSize);
    }

    // Метод push добавляет элемент в стек
    public void push(E element) throws StackException {
        if (isFull()) {
            throw new StackException("Стек полон! Невозможно добавить элемент.");
        }
        stack.add(element);
    }

    // Метод pop удаляет элемент из стека и возвращает его
    public E pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Стек пуст! Невозможно извлечь элемент.");
        }
        return stack.remove(stack.size() - 1);
    }

    // Метод peek возвращает верхний элемент стека без его удаления
    public E peek() {
        if (isEmpty()) {
            return null;  // Можно вернуть null, если стек пуст
        }
        return stack.get(stack.size() - 1);
    }

    // Метод getSize возвращает количество элементов в стеке
    public int getSize() {
        return stack.size();
    }

    // Метод isEmpty проверяет, пуст ли стек
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Метод isFull проверяет, заполнен ли стек
    public boolean isFull() {
        return stack.size() == maxSize;
    }

    // Метод pushAll добавляет в стек все элементы из коллекции
    public void pushAll(Collection<? extends E> src) throws StackException {
        for (E element : src) {
            push(element);
        }
    }

    // Метод popAll удаляет из стека все элементы и добавляет их в коллекцию
    public void popAll(Collection<? super E> dst) throws StackException {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }
}
