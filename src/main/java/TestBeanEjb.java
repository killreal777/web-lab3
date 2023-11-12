import jakarta.ejb.Stateless;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;

@Stateless
public class TestBeanEjb {

    @PersistenceContext(unitName = "testPU")
    private EntityManager entityManager;

    public void createTestEntity(String message) {
        TestEntity testEntity = entityManager.find(TestEntity.class, message);

        if (testEntity != null)
            return;

        testEntity = new TestEntity();
        testEntity.setMessage(message);
        entityManager.persist(testEntity);
    }
}
