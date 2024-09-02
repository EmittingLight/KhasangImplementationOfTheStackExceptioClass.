import java.util.ArrayList;

public class StackTest {
    public static void main(String[] args) {
        try {
            // Создаем стек с максимальным размером 5
            ArrayStack<Integer> stack = new ArrayStack<>(5);

            // Проверяем isEmpty() на пустом стеке
            System.out.println("Стек пустой? " + stack.isEmpty());

            // Добавляем элементы в стек
            stack.push(1);
            stack.push(2);
            stack.push(3);
            System.out.println("Верхний элемент: " + stack.peek()); // Должен быть 3

            // Проверяем getSize()
            System.out.println("Размер стека: " + stack.getSize()); // Должен быть 3

            // Удаляем элемент из стека
            System.out.println("Удаленный элемент: " + stack.pop()); // Должен быть 3
            System.out.println("Верхний элемент после удаления: " + stack.peek()); // Должен быть 2

            // Добавляем еще элементы до заполнения стека
            stack.push(4);
            stack.push(5);
            stack.push(6);

            // Проверяем isFull()
            System.out.println("Стек полный? " + stack.isFull());

            // Пробуем добавить элемент в полный стек (должно вызвать исключение)
            stack.push(7); // Здесь должно выбросить StackException

        } catch (StackException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            // Создаем новый пустой стек
            ArrayStack<Integer> stack = new ArrayStack<>(5);

            // Пробуем извлечь элемент из пустого стека (должно вызвать исключение)
            stack.pop(); // Здесь должно выбросить StackException

        } catch (StackException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Проверка методов pushAll и popAll
        try {
            ArrayStack<Integer> stack = new ArrayStack<>(5);
            ArrayList<Integer> srcList = new ArrayList<>();
            srcList.add(10);
            srcList.add(20);
            srcList.add(30);

            // Добавляем все элементы из списка в стек
            stack.pushAll(srcList);
            System.out.println("Размер стека после pushAll: " + stack.getSize()); // Должен быть 3

            ArrayList<Integer> dstList = new ArrayList<>();
            stack.popAll(dstList);
            System.out.println("Размер стека после popAll: " + stack.getSize()); // Должен быть 0
            System.out.println("Элементы в dstList: " + dstList); // Должен содержать [30, 20, 10]

        } catch (StackException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}


