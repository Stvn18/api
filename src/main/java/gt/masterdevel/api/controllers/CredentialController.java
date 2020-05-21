package gt.masterdevel.api.controllers;

import gt.masterdevel.api.services.auth.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CredentialController {

    @Autowired
    private CredentialService credentialService;

    @PutMapping("/credential")
    public ResponseEntity doUpdateCredential(
            @RequestParam(value = "key") String key,
            @RequestBody String sharedSecret
    ) {

        if (credentialService.findByKey(key) != null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        credentialService.saveKeyAndSharedSecret(key, sharedSecret);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
