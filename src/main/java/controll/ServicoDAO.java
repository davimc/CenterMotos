package controll;

import model.Servico;
import org.hibernate.persister.walking.spi.EntityIdentifierDefinition;

import javax.persistence.EntityManager;

public class ServicoDAO {
    private EntityManager manager;

    public ServicoDAO(EntityManager manager){
        this.manager = manager;
    }
    public void salva(Servico novoServico){
        try{
            this.manager.getTransaction().begin();
            this.manager.persist(novoServico);
            this.manager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            this.manager.getTransaction().rollback();
        }
    }
    public Servico buscaPor(long id){
        return manager.find(Servico.class, id);
    }

}
