package gt.masterdevel.api.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String key;
    private String sharedSecret;

    public Credential(String key, String sharedSecret) {
        this.key = key;
        this.sharedSecret = sharedSecret;
    }
}
