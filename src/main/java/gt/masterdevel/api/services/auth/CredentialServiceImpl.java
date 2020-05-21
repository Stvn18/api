package gt.masterdevel.api.services.auth;

import gt.masterdevel.api.data.entities.Credential;
import gt.masterdevel.api.data.repo.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialServiceImpl implements CredentialService {

    @Autowired
    private CredentialRepository credentialRepository;

    @Override
    public Credential findByKey(String key) {
        return credentialRepository.findByKey(key);
    }

    @Override
    public void saveKeyAndSharedSecret(String key, String sharedSecret) {
        credentialRepository.save(new Credential(key, sharedSecret));
    }
}
