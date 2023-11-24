package area.data;

import area.model.HitCheck;

import jakarta.ejb.Stateless;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.stream.Collectors;

/**
 * EJB bean. Implements hit check service logic.
 */
@Stateless
public class HitCheckServiceBean {

    @PersistenceContext(unitName = "studsPU")
    private EntityManager entityManager;

    /**
     * Selects all HitCheck records form database.
     */
    public List<HitCheck> getAll() {
        Query query = entityManager.createQuery("select entity from HitCheckEntity entity");
        List<HitCheckEntity> resultList = query.getResultList();
        return resultList.stream()
                .map(HitCheckEntity::getHitCheck)
                .collect(Collectors.toList());
    }

    /**
     * Inserts HitCheck record into database.
     */
    public void add(HitCheck hitCheck) {
        HitCheckEntity entity = new HitCheckEntity(hitCheck);
        entityManager.persist(entity);
    }

    /**
     * Deletes all HitCheck records from database.
     */
    public void clean() {
        entityManager.createQuery("delete (select entity from HitCheckEntity entity)").executeUpdate();
    }
}
