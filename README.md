Домашнее задание 1
Дан интерфейс Stack

public interface Stack<E> {
       // add new element to the top of the stack
       public void push(E element) throws StackException;
       // return and remove an element from the top
       public E pop() throws StackException;
       // return the top element but doesn’t remove
       public E peek();
       // returns the number of elements on the stack
       public int getSize();
       public boolean isEmpty();
       public boolean isFull();
       // add all elements from @src to the stack
       public void pushAll(Collection<? extends E> src) throws
           StackException;
       // pop all elements from stack to @dst
       public void popAll(Collection<? super E> dst) throws
           StackException;
}
Реализуйте класс GenericStack<E> implements Stack<E>

Реализуйте класс StackException extends Exception – исключение должно выбрасываться, если стек полон и кто-то вызывает метод push() или если стек пуст и вызывается метод pop().

