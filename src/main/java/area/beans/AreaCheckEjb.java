package area.beans;


import area.data.AreaCheckRecordEntity;
import area.model.AreaCheckRecord;
import area.model.AreaDot;
import area.script.AreaCheckScript;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless
public class AreaCheckEjb {
    private final AreaCheckScript areaCheckScript;

    @PersistenceContext(unitName = "studsPU")
    private EntityManager entityManager;


    public AreaCheckEjb() {
        this.areaCheckScript = new AreaCheckScript();
    }


    public void executeAreaCheckScript(AreaDot areaDot) {
        AreaCheckRecord record = areaCheckScript.execute(areaDot);
        saveToDatabase(record);
    }

    private void saveToDatabase(AreaCheckRecord record) {
        AreaCheckRecordEntity entity = entity(record);
        entityManager.persist(entity);
    }

    private AreaCheckRecordEntity entity(AreaCheckRecord record) {
        AreaCheckRecordEntity entity = new AreaCheckRecordEntity();
        entity.setStartTime(record.getStartTime());
        entity.setExecutionTimeNano(record.getExecutionTimeNano());
        entity.setR(record.getR());
        entity.setX(record.getX());
        entity.setY(record.getY());
        entity.setHit(record.isHit());
        return entity;
    }
}
