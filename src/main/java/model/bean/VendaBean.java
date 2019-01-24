package model.bean;

import model.Venda;
import model.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Calendar;
import java.util.List;

public class VendaBean {
    private EntityManager manager;

    public VendaBean(){
        manager = JPAUtil.getEntityManager();
    }
    public void salva(Venda venda){
        try {
            manager.getTransaction().begin();
            manager.persist(venda);
            manager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            this.manager.getTransaction().rollback();
        }
    }

    public Venda buscaPor(long id){
        return manager.find(Venda.class, id);
    }
    public List<Venda> listaVendas(){
        return manager.createQuery("FROM Venda").getResultList();
    }
    public List<Venda> listaVendasDatasPrazo(int dias ){
        Query q = manager.createQuery("From venda v WHERE v.dtPrevisao<:args2 AND v.status=:args1");
        Calendar umaSemana = Calendar.getInstance();
        umaSemana.set(Calendar.DATE,umaSemana.DAY_OF_MONTH+dias);
        q.setParameter("args1", "FIADO");
        q.setParameter("args2", umaSemana);
        return q.getResultList();
    }
}
