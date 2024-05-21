package area.script;

import area.data.AreaDotData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HitCheckerTest {
    private HitChecker hitChecker;

    @Before
    public void setup() {
        this.hitChecker = new HitChecker();
    }

    @Test
    public void testCenter() {
        float r = 2f;
        float x = 0f;
        float y = 0f;
        boolean isHit = hitChecker.isHit(new AreaDotData(r, x, y));
        Assert.assertTrue(isHit);
    }

    @Test
    public void testQuarterCircle() {
        float r = 2f;
        float x = -1f;
        float y = 1f;
        boolean isHit = hitChecker.isHit(new AreaDotData(r, x, y));
        Assert.assertTrue(isHit);
    }

    @Test
    public void testTriangle() {
        float r = 3f;
        float x = 0.5f;
        float y = -0.5f;
        boolean isHit = hitChecker.isHit(new AreaDotData(r, x, y));
        Assert.assertTrue(isHit);
    }

    @Test
    public void testRectangle() {
        float r = 4f;
        float x = -2f;
        float y = -1f;
        boolean isHit = hitChecker.isHit(new AreaDotData(r, x, y));
        Assert.assertTrue(isHit);
    }

    @Test
    public void testMiss() {
        float r = 1f;
        float x = 1f;
        float y = 1f;
        boolean isHit = hitChecker.isHit(new AreaDotData(r, x, y));
        Assert.assertFalse(isHit);
    }
}
