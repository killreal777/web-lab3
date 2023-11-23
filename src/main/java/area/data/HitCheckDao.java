package area.data;

import area.model.HitCheck;

import java.util.List;

public interface HitCheckDao {
    /**
     * Selects all HitCheck records form database.
     */
    List<HitCheck> getAll();

    /**
     * Inserts HitCheck record into database.
     */
    void add(HitCheck hitCheck);

    /**
     * Deletes all HitCheck records from database.
     */
    void clean();
}
