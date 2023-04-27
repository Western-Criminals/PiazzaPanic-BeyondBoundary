package cs.eng1.piazzapanic.stations;

import junit.framework.TestCase;
import org.junit.Test;

public class StationActionTest extends TestCase {

    @Test
    public void testGetActionDescription() {
        assertSame(StationAction.getActionDescription(StationAction.ActionType.CHOP_ACTION),"Chop");
        assertSame(StationAction.getActionDescription(StationAction.ActionType.MAKE_BURGER), "Make Burger");

    }
}