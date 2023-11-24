package area.data;

import area.model.HitCheck;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "hit_checks")
class HitCheckEntity {

    @Id
    @GeneratedValue
    @Getter(value=AccessLevel.PROTECTED)
    @Setter(value=AccessLevel.PROTECTED)
    private int id;

    @Embedded
    private HitCheck hitCheck;


    protected HitCheckEntity(HitCheck hitCheck) {
        setHitCheck(hitCheck);
    }
}
