import java.util.Date;

import entidades.Vuelo;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Prueba {

	/**
	 * Metodo para actualizar un vuelo
	 * 
	 * @param vuelo
	 */
	public void creaActualizaVuelo(Vuelo vuelo) {
		System.out.println("Crear o actualizar vuelo");
		// Conseguimos un objeto sesion para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transaccion
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesion
			session.saveOrUpdate(vuelo);
			System.out.println("id vuelo guardado "+vuelo.getId());
			// Commit de la transaccion
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrio un error:" + e.getMessage());
		} finally {
			/*
			 * Cuidado que al hacer close, los objetos pasan a estado detached,
			 * si hago close y luego fuera del try un return del objeto no
			 * tendr� acceso al valor de sus propiedades, �nicamente la clave
			 * primaria
			 */
			session.close();
		}

	}

	/**
	 * Metodo para recuperar un vuelo
	 * 
	 * @param id
	 * @return
	 */
	public Vuelo recuperaVuelo(int id) {
		// Conseguimos un objeto sesion para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Vuelo vue = new Vuelo();

		// abrimos una transaccion
		session.beginTransaction();
		// Recuperamos el empleado
		vue = (Vuelo) session.load(Vuelo.class, id);
		// Commit de la transaccion
		session.getTransaction().commit();
		
		return vue;
	}

	public void borrarVuelo(Vuelo vuelo) {
		// Conseguimos un objeto sesion para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Vuelo vue = new Vuelo();

		// abrimos una transaccion
		session.beginTransaction();
		// Recuperamos el empleado
		session.delete(vuelo);
		// Commit de la transaccion
		session.getTransaction().commit();


	}

	public static void main(String[] args) {
		Vuelo vue = new Vuelo();

		Vuelo vueR;

		vue.setHoraSalida(new Date());
		char[] codigo={'A','0','2','3',};
		vue.setCodigo(codigo);
		vue.setLongitud(5);
		vue.setNumero(333);
		vue.setTexto("Vuelo de prueba");
		vue.setTipo(Vuelo.TipoVuelo.ASIA);

		System.out.println("Vuelo almacenado:" + vue.toString());
		

		Prueba prueba = new Prueba();
		prueba.creaActualizaVuelo(vue);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Vuelo almacenado:" + vue.getId());

		vueR = prueba.recuperaVuelo(vue.getId());

		System.out.println("Vuelo recuperado:" + vueR.getId());

        // Cerramos la factoria de sesiones, sino el programa no finalizar
		System.out.println("borrar vuelo" );
		prueba.borrarVuelo(vue);

		Utilidades.getSessionFactory().close();
	}

}
