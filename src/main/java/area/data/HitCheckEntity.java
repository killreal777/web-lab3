package area.data;

import area.model.HitCheck;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "hit_checks")
class HitCheckEntity {

    @Id
    @GeneratedValue
    private int id;

    @Embedded
    private HitCheck hitCheck;


    protected HitCheckEntity(HitCheck hitCheck) {
        setHitCheck(hitCheck);
    }

    protected HitCheckEntity() {

    }
}
