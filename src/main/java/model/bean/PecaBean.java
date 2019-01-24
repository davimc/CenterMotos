package model.bean;

import model.Peca;
import model.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class PecaBean {
    private EntityManager manager;

    public PecaBean(){
        manager = JPAUtil.getEntityManager();
    }
    public void salva(Peca peca){
        try{
            manager.getTransaction().begin();
            manager.persist(peca);
            manager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            manager.getTransaction().rollback();
        }
    }
    public List<Peca> listaPecas(){
        return manager.createQuery("FROM Peca").getResultList();
    }
}
