package demo;

import org.junit.*;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testPushAndPop() {
        Stack stack = new Stack();
        stack.push("first");
        stack.push("second");
        
        assertEquals("second", stack.pop());
        assertEquals("first", stack.pop());
    }

    @Test
    public void testPeek() {
        Stack stack = new Stack();
        stack.push("onlyElement");
        
        assertEquals("onlyElement", stack.peek());
        assertEquals("onlyElement", stack.pop());
    }

    @Test(expected = IllegalStateException.class)
    public void testPopOnEmptyStack() {
        Stack stack = new Stack();
        stack.pop();
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekOnEmptyStack() {
        Stack stack = new Stack();
        stack.peek();
    }

    @Test
    public void testResize() {
        Stack stack = new Stack();
        for (int i = 1; i <= 20; i++) {
            stack.push("element" + i);
        }
        
        for (int i = 20; i >= 1; i--) {
            assertEquals("element" + i, stack.pop());
        }
    }

    @Test
    public void testIsEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
        
        stack.push("test");
        assertFalse(stack.isEmpty());
        
        stack.pop();
        assertTrue(stack.isEmpty());
    }
	@Test
	public void testRPN() {
		RPNCalculator calculator = new RPNCalculator();
		assertEquals(9, calculator.evaluate("4 5 +"));
		assertEquals(20, calculator.evaluate("4 5 *"));
		assertEquals(1, calculator.evaluate("5 4 -"));
		assertEquals(2, calculator.evaluate("8 4 /"));
	}
}


//no print usage, no main method