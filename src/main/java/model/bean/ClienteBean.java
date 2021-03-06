package model.bean;

import model.Cliente;
import model.util.JPAUtil;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ClienteBean {
    private EntityManager manager;

    public ClienteBean(){
      this.manager = JPAUtil.getEntityManager();
    }
    public void salva(Cliente novoCliente) {
        try {
            this.manager.getTransaction().begin();
            this.manager.persist(novoCliente);
            this.manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.manager.getTransaction().rollback();
        }
    }

    public Cliente buscaPor(long id) {
        return this.manager.find(Cliente.class, id);
    }
    public List<Cliente> listaClientes(){
        return this.manager.createQuery("FROM Cliente").getResultList();
    }
    public List<Cliente> ListaClientesNome(String nome) {
        Query q = this.manager.createQuery("SELECT c FROM Cliente c WHERE c.nome=:nome");
        q.setParameter("nome","%"+nome+"%");
        return q.getResultList();
    }

}
