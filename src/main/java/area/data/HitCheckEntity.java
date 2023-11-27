package area.data;

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
    private HitCheckData hitCheckData;


    protected HitCheckEntity(HitCheckData hitCheckData) {
        setHitCheckData(hitCheckData);
    }
}
