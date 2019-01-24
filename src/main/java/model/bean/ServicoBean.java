package model.bean;

import model.Servico;
import model.util.JPAUtil;
import org.hibernate.persister.walking.spi.EntityIdentifierDefinition;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Calendar;
import java.util.List;

public class ServicoBean {
    private EntityManager manager;

    public ServicoBean() {
        this.manager = JPAUtil.getEntityManager();
    }

    public void salva(Servico novoServico) {
        try {
            this.manager.getTransaction().begin();
            this.manager.persist(novoServico);
            this.manager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            this.manager.getTransaction().rollback();
        }
    }

    public Servico buscaPor(long id) {
        return manager.find(Servico.class, id);
    }
    public List<Servico> listaServico(){
        return manager.createQuery("FROM servico").getResultList();
    }
    public List<Servico> listaServicoPrazo(int dias){
        Query q = manager.createQuery("SELECT s FROM servico s WHERE s.dataPrecisao<=:umaSemana");
        q.setParameter("umaSemana", Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+dias);
        return q.getResultList();
    }
}
