import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayStackTest {

    private ArrayStack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new ArrayStack<>(3);  // Инициализация стека перед каждым тестом
    }

    @AfterEach
    public void tearDown() {
        stack = null;  // Очистка стека после каждого теста
    }

    @Test
    public void testPush() throws StackException {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        //stack.push(4);
        assertEquals(3, stack.getSize());
        assertEquals(3, stack.peek());
    }

    @Test
    public void testPushOverCapacity() {
        stack = new ArrayStack<>(2);
        assertThrows(StackException.class, () -> {
            stack.push(1);
            stack.push(2);
            stack.push(3); // Это должно вызвать исключение
        });
    }

    @Test
    public void testPop() throws StackException {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.getSize());
        assertEquals(2, stack.peek());
    }

    @Test
    public void testPopEmptyStack() {
        assertThrows(StackException.class, stack::pop);
    }

    @Test
    public void testPeek() throws StackException {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
        assertEquals(2, stack.getSize()); // Проверка, что размер не изменился после вызова peek
    }

    @Test
    public void testIsEmpty() throws StackException {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testIsFull() throws StackException {
        stack = new ArrayStack<>(2);
        assertFalse(stack.isFull());
        stack.push(1);
        stack.push(2);
        assertTrue(stack.isFull());
    }

    @Test
    public void testPushAll() throws StackException {
        List<Integer> list = Arrays.asList(1, 2, 3);
        stack.pushAll(list);
        assertEquals(3, stack.getSize());
        assertEquals(3, stack.peek());
    }

    @Test
    public void testPopAll() throws StackException {
        List<Integer> list = Arrays.asList(1, 2, 3);
        stack.pushAll(list);
        List<Integer> result = new ArrayList<>();
        stack.popAll(result);
        assertEquals(0, stack.getSize());
        assertEquals(Arrays.asList(3, 2, 1), result);
    }
}
