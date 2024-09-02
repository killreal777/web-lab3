package area.data;

import jakarta.persistence.*;

@Entity
@Table(name = "hit_checks")
class HitCheckEntity {

    @Id
    @GeneratedValue
    private int id;

    @Embedded
    private HitCheckData hitCheckData;


    protected HitCheckEntity(HitCheckData hitCheckData) {
        setHitCheckData(hitCheckData);
    }

    public HitCheckEntity() {
    }

    public HitCheckData getHitCheckData() {
        return this.hitCheckData;
    }

    public void setHitCheckData(HitCheckData hitCheckData) {
        this.hitCheckData = hitCheckData;
    }

    protected int getId() {
        return this.id;
    }

    protected void setId(int id) {
        this.id = id;
    }
}
