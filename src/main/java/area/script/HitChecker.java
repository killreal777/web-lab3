package area.script;

import area.model.AreaDot;


class HitChecker {
    protected boolean isHit(AreaDot areaDot) {
        final float r = areaDot.getR();
        final float x = areaDot.getX();
        final float y = areaDot.getY();

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
