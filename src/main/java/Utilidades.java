import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
 
/**
 * Responsable de crear un objeto sesi�n (gestiona la conexi�n a BD de forma transparente
 * @author Laura
 *
 */
public class Utilidades {
	
	 
	    //Factoria de sesion para crear objeto sesin a partir de XML
	    private static SessionFactory sessionFactory;
	     
	    private static SessionFactory buildSessionFactory() {
	        try {
	            // Creamos una factoria de sesiones con los datos de hibernate.cfg.xml
	            Configuration configuration = new Configuration();
				configuration.configure();

	            //configuration.configure("hibernate.cfg.xml");
	            System.out.println("Configuracion de Hibernate Cargada");
	             
	            //ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	            //System.out.println("Servicio de registro de Hibernate Realizado");
	             
	            //SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				// local SessionFactory bean created
				SessionFactory sessionFactory = configuration.buildSessionFactory();

	            return sessionFactory;
	        }
	        catch (Throwable ex) {
	            // En un caso real se registra en un log
	            System.err.println("Fallo la creacion de la factoria de sesiones inicial." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    
	    /*
	     * M�todo estatico (Fachada) para crear la factor�a de sesiones
	     */
	    public static SessionFactory getSessionFactory() {
	        if(sessionFactory == null) sessionFactory = buildSessionFactory();
	        return sessionFactory;
	    }

}
