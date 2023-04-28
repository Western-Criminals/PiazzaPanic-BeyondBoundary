package cs.eng1.piazzapanic.chef;

import junit.framework.TestCase;
import org.junit.Test;

public class FixedStackTest extends TestCase {

    @Test
    public void testPush() {
        FixedStack testStack = new FixedStack<>(5);
        testStack.push("testItem");
        assertSame(testStack.firstElement(), "testItem");

    }

    @Test
    public void testHasSpace() {
        FixedStack testStack = new FixedStack(1);
        testStack.push("testItem");
        assertFalse(testStack.hasSpace());
        testStack.pop();
        assertTrue(testStack.hasSpace());


    }
}