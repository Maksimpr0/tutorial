package com.hospitalcrud.domain.services;

import com.hospitalcrud.dao.model.Credential;
import com.hospitalcrud.dao.repositories.staticDao.StaticCredentialRepository;
import org.springframework.stereotype.Service;

@Service
public class CredentialService {


    private StaticCredentialRepository staticCredentialRepository;

    public CredentialService(StaticCredentialRepository staticCredentialRepository) {
        this.staticCredentialRepository = staticCredentialRepository;
    }

    public boolean get(Credential credential){
        boolean aux;
       Credential credential1 =  staticCredentialRepository.get();
       if ((credential1.getUsername().equals(credential.getUsername()))&&credential1.getPassword().
               equals(credential.getPassword())){
           aux=true;
       }else aux=false;

        return aux;
    }
}
