package area.script;

import area.data.AreaDotData;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class HitCheckerTest {
    private final HitChecker hitChecker = new HitChecker();

    private boolean checkHit(float r, float x, float y) {
        return hitChecker.isHit(new AreaDotData(r, x, y));
    }

    @Test
    public void testHitQuarterCircle() {
        // corners
        assertTrue(checkHit(1, 0, 0));
        assertTrue(checkHit(1, -1, 0));
        assertTrue(checkHit(1, 0, 1));
        // edges
        assertTrue(checkHit(1, -0.5f, (float) Math.sqrt(3) / 2));
        assertTrue(checkHit(1, 0, 0.73f));
        // close to edges
        assertFalse(checkHit(1, -0.5f, (float) Math.sqrt(3) / 2 + 0.0000001f));
        assertFalse(checkHit(1, 0.0000001f, 0.73f));
        // inside
        assertTrue(checkHit(1, -0.567f, 0.234f));
        // outside
        assertFalse(checkHit(1, -1, 1));
    }

    @Test
    public void testHitTriangle() {
        // corners
        assertTrue(checkHit(1, 0, 0));
        assertTrue(checkHit(1, 0.5f, 0));
        assertTrue(checkHit(1, 0, -0.5f));
        // edges
        assertTrue(checkHit(1, 0.3f, 0));
        assertTrue(checkHit(1, 0.25f, -0.25f));
        // close to edges
        assertFalse(checkHit(1, 0.3f, 0.0000001f));
        assertFalse(checkHit(1, 0.2500001f, -0.25f));
        // inside
        assertTrue(checkHit(1, 0.2f, -0.15f));
        // outside
        assertFalse(checkHit(1, 1, -1));
    }

    @Test
    public void testHitRectangle() {
        // corners
        assertTrue(checkHit(1, 0, 0));
        assertTrue(checkHit(1, -1, 0));
        assertTrue(checkHit(1, -1, -0.5f));
        assertTrue(checkHit(1, 0, -0.5f));
        // edges
        assertTrue(checkHit(1, -1, -0.3f));
        assertTrue(checkHit(1, -0.853f, -0.5f));
        // close to edges
        assertFalse(checkHit(1, -1.0000001f, -0.3f));
        assertFalse(checkHit(1, -0.853f, -0.5000001f));
        // inside
        assertTrue(checkHit(1, -0.2f, -0.11f));
        // outside
        assertFalse(checkHit(1, -0.853f, -1));
    }

    @Test
    public void testRadiusSwitch() {
        assertTrue(checkHit(3, 0, 0));
        assertTrue(checkHit(2, -1, (float) Math.sqrt(3)));
        assertTrue(checkHit(4, 2, 0));
        assertFalse(checkHit(3, 0.7500001f, -0.75f));
    }
}
