package area.script;

import area.data.AreaDotData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class HitCheckerTest {
    private static HitChecker hitChecker;

    @BeforeAll
    static void setup() {
        hitChecker = new HitChecker();
    }

    private boolean checkHit(float r, float x, float y) {
        return hitChecker.isHit(new AreaDotData(r, x, y));
    }

    private static Stream<Float> radii() {
        return Stream.of(1f, 2f, 3f, 4f, 5f);
    }

    @ParameterizedTest
    @MethodSource("radii")
    public void testHitQuarterCircleWithDifferentRadii(float r) {
        // corners
        assertThat(checkHit(r, -1 * r, 0)).isTrue();
        assertThat(checkHit(r, 0, r)).isTrue();
        // edges
        assertThat(checkHit(r, -0.5f * r, (float) Math.sqrt(3) / 2 * r)).isTrue();
        assertThat(checkHit(r, 0, 0.73f * r)).isTrue();
        // close to edges
        assertThat(checkHit(r, -0.5f * r, (float) Math.sqrt(3) / 2 * r + 0.0001f)).isFalse();
        assertThat(checkHit(r, 0.0001f * r, 0.73f * r)).isFalse();
        // inside
        assertThat(checkHit(r, -0.567f * r, 0.234f * r)).isTrue();
        // outside
        assertThat(checkHit(r, -1 * r, 1 * r)).isFalse();
    }

    @ParameterizedTest
    @MethodSource("radii")
    public void testHitTriangleWithDifferentRadii(float r) {
        // corners
        assertThat(checkHit(r, 0, 0)).isTrue();
        assertThat(checkHit(r, 0.5f * r, 0)).isTrue();
        assertThat(checkHit(r, 0, -0.5f * r)).isTrue();
        // edges
        assertThat(checkHit(r, 0.3f * r, 0)).isTrue();
        assertThat(checkHit(r, 0.25f * r, -0.25f * r)).isTrue();
        // close to edges
        assertThat(checkHit(r, 0.3f * r, 0.0001f * r)).isFalse();
        assertThat(checkHit(r, 0.2501f * r, -0.25f * r)).isFalse();
        // inside
        assertThat(checkHit(r, 0.2f * r, -0.15f * r)).isTrue();
        // outside
        assertThat(checkHit(r, 1 * r, -1 * r)).isFalse();
    }

    @ParameterizedTest
    @MethodSource("radii")
    public void testHitRectangleWithDifferentRadii(float r) {
        // corners
        assertThat(checkHit(r, -1 * r, 0)).isTrue();
        assertThat(checkHit(r, -1 * r, -0.5f * r)).isTrue();
        assertThat(checkHit(r, 0, -0.5f * r)).isTrue();
        // edges
        assertThat(checkHit(r, -1 * r, -0.3f * r)).isTrue();
        assertThat(checkHit(r, -0.853f * r, -0.5f * r)).isTrue();
        // close to edges
        assertThat(checkHit(r, -1.0001f * r, -0.3f * r)).isFalse();
        assertThat(checkHit(r, -0.853f * r, -0.5001f * r)).isFalse();
        // inside
        assertThat(checkHit(r, -0.2f * r, -0.11f * r)).isTrue();
        // outside
        assertThat(checkHit(r, -0.853f * r, -1 * r)).isFalse();
    }
}
