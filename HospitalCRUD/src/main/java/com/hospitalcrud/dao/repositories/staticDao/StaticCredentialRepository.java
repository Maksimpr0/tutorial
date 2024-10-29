package com.hospitalcrud.dao.repositories.staticDao;

import com.hospitalcrud.dao.model.Credential;
import com.hospitalcrud.dao.repositories.CredetialRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


@Repository
@Profile("enDesarrollo")
public class StaticCredentialRepository implements CredetialRepository {



    public Credential get(){
        Credential credentials = new Credential("maksim","maksim",1);
        return credentials;
    }

}
