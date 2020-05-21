package gt.masterdevel.api.data.repo;

import gt.masterdevel.api.data.entities.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credential, Integer> {

    Credential findByKey(String key);

}
