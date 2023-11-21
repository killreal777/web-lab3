package area.data;


import area.model.AreaCheckRecord;
import area.model.AreaDot;
import area.script.AreaCheckScript;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless
public class AreaCheckRecordEjb {

    @PersistenceContext(unitName = "studsPU")
    private EntityManager entityManager;



}
