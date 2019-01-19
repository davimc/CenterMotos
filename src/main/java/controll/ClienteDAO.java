package controll;

import model.Cliente;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClienteDAO {
    private EntityManager manager;

    //public ClienteDAO(EntityManager manager){
      //  this.manager = manager;
    //}
    public void salva(Cliente novoCliente){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja");
            manager = emf.createEntityManager();
            this.manager.getTransaction().begin();
            this.manager.persist(novoCliente);
            this.manager.getTransaction().commit();
        }catch(HibernateException hex){
            hex.printStackTrace();
            this.manager.getTransaction().rollback();
        }
    }
    public Cliente buscaPor(long id){
        return this.manager.find(Cliente.class, id);
    }
}
