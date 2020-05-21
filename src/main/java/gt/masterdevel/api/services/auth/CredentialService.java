package gt.masterdevel.api.services.auth;

import gt.masterdevel.api.data.entities.Credential;

public interface CredentialService {
    Credential findByKey(String key);

    void saveKeyAndSharedSecret(String key, String sharedSecret);
}
