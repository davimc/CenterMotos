package model.bean;

import model.Moto;
import model.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class MotoBean {
    private EntityManager manager;

    public MotoBean(){
        manager = JPAUtil.getEntityManager();
    }
    public void salva(Moto moto){
        try {
            manager.getTransaction().begin();
            manager.persist(moto);
            manager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            manager.getTransaction().rollback();
        }
    }
    public Moto buscaPor(long id){
        return manager.find(Moto.class, id);
    }
    public List<Moto> listaMotos(){
        return manager.createQuery("FROM moto").getResultList();
    }

}
