package br.com.matta.repository;

//import org.hibernate.envers.AuditReader;
//import org.hibernate.envers.AuditReaderFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import java.util.List;


public class JpaUtil<T> {

    private EntityManagerFactory emFactory;
    private EntityManager em;

    public JpaUtil() throws Exception{
        super();
        setUp();
    }

    /**
     * Configuracao com RESOURCE_LOCAL
     * @throws Exception
     */
    protected void setUp() throws Exception {
        emFactory = Persistence.createEntityManagerFactory("repositoryPU");
        em = emFactory.createEntityManager();
    }

    public void save(T entity)throws Exception{
        
        // auditoria
        //AuditReader reader = AuditReaderFactory.get(entityManager);
        //Person firstRevision = reader.find( Person.class, 2L, 1 );


        em.getTransaction().begin();
        em.persist(entity);
        em.flush();
        em.getTransaction().commit();

        //Person secondRevision = reader.find( Person.class, 2L, 2 );

        /*System.out.println(firstRevision.getName());
        System.out.println(secondRevision.getName());*/
    }

    public void listPerson(){
        /*EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Person> result = entityManager.createQuery( "from Person", Person.class ).getResultList();
        for ( Person person : result ) {
            System.out.println(person.toString());
        }
        entityManager.getTransaction().commit();
        entityManager.close();*/
    }

    public void close(){
        em.close();
    }
}
