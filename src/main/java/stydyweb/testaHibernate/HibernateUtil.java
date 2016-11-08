package stydyweb.testaHibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder registradorservico = new StandardServiceRegistryBuilder();
			registradorservico.applySettings(cfg.getProperties());

			StandardServiceRegistry servico = registradorservico.build();

			return cfg.buildSessionFactory(servico);
		} catch (Throwable e) {

			System.out.println("Cria��o do objeto SessionFactory falhou. Erro: " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}

}
