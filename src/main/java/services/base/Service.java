package services.base;

import entities.UserEntity;
import entities.base.EntityModel;
import repositories.base.Repository;

public abstract class Service< E extends EntityModel, R extends Repository<E>> implements ServiceApi<E>{

    protected R repository;

    public  Service(R repository){
        this.repository =repository;
    }



}
