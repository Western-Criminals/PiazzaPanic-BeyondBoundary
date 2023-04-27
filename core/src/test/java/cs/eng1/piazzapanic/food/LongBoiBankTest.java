package cs.eng1.piazzapanic.food;

import junit.framework.TestCase;
import org.junit.Test;

public class LongBoiBankTest extends TestCase {


    @Test
    public void testSetBalance() {
        LongBoiBank testBank = new LongBoiBank();
        testBank.setBalance(5);
        assertTrue(testBank.getBalance() == 5);
        testBank.setBalance(15);
        assertFalse(testBank.getBalance() ==5);

    }

    @Test
    public void testGetBalance() {
        LongBoiBank testBank = new LongBoiBank();
        testBank.setBalance(0);
        assertTrue(testBank.getBalance()==0);
        testBank.setBalance(5);
        assertTrue(testBank.getBalance()==5);
        testBank.setBalance(10);
        assertFalse(testBank.getBalance()==5);
    }

    @Test
    public void testEarn() {
        LongBoiBank testBank = new LongBoiBank();
        testBank.setBalance(0);
        testBank.earn("salad");
        assertTrue(testBank.getBalance() == 30);
        testBank.earn("pizza");
        assertTrue(testBank.getBalance() == 55);
        testBank.earn("typo");
        assertTrue(testBank.getBalance() == 55);

    }

    @Test
    public void testSpend() {
        LongBoiBank testBank = new LongBoiBank();
        testBank.setBalance(100);
        testBank.spend("normal");
        assertTrue(testBank.getBalance() == 80);
        testBank.spend("lunatic");
        assertTrue(testBank.getBalance() == 30);
        testBank.spend("lunatic");
        assertTrue(testBank.getBalance() == 30);
        testBank.spend("typo");
        assertTrue(testBank.getBalance() == 30);

    }
}