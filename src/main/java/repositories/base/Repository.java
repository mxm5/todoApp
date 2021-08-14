package repositories.base;

import entities.base.EntityModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Repository <E extends EntityModel> implements RepositoryApi<E> {

    protected final EntityManagerFactory entityManagerFactory;
    protected final EntityManager entityManager;
    public Repository(){
         entityManagerFactory = Persistence.createEntityManagerFactory("todo_app");
         entityManager = entityManagerFactory.createEntityManager();
    }



}
