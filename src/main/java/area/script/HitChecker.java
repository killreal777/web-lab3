package area.script;

import area.data.AreaDotData;


class HitChecker {
    protected boolean isHit(AreaDotData areaDotData) {
        final float r = areaDotData.getR();
        final float x = areaDotData.getX();
        final float y = areaDotData.getY();

        return isHitQuarterCircle(r, x, y) || isHitTriangle(r, x, y) || isHitRectangle(r, x, y);
    }

    private boolean isHitQuarterCircle(float r, float x, float y) {
        return (x <= 0) && (y >= 0) && (x*x + y*y <= r*r);
    }

    private boolean isHitTriangle(float r, float x, float y) {
        return (x >= 0) && (y <= 0) && (y >= x - r/2);
    }

    private boolean isHitRectangle(float r, float x, float y) {
        return (x <= 0) && (x >= -r) && (y <= 0) && (y >= -r/2);
    }
}
