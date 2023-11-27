package area.data;

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
     * Selects all HitCheckData records form database.
     */
    public List<HitCheckData> getAll() {
        Query query = entityManager.createQuery("select entity from HitCheckEntity entity");
        List<HitCheckEntity> resultList = query.getResultList();
        return resultList.stream()
                .map(HitCheckEntity::getHitCheckData)
                .collect(Collectors.toList());
    }

    /**
     * Inserts HitCheckData record into database.
     */
    public void add(HitCheckData hitCheckData) {
        HitCheckEntity entity = new HitCheckEntity(hitCheckData);
        entityManager.persist(entity);
    }

    /**
     * Deletes all HitCheckData records from database.
     */
    public void clean() {
        entityManager.createQuery("delete (select entity from HitCheckEntity entity)").executeUpdate();
    }
}
