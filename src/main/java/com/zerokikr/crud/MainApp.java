package com.zerokikr.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainApp {
	
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		
		// CRUD session
		Session session = null;
		
		//create(factory);
		
		//read(factory);
		
		//update(factory);
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		Racer racer = session.get(Racer.class, 2);
		Auto auto = session.get(Auto.class, 12);
		racer.getAutos().clear();
		
		session.getTransaction().commit();
		
		
		
	}
	

	// CREATE
	private static void create(SessionFactory factory) {
		Session session = factory.getCurrentSession();
		try {
			Auto auto1 = new Auto ("Porsche 911", "Blue");
			Auto auto2 = new Auto ("Ferrari F40", "Red");
			Auto auto3 = new Auto ("Batmobile", "Black");
			Auto auto4 = new Auto ("Aston Martin DB9", "Gray");
			session.beginTransaction();
			session.save(auto1);
			session.save(auto2);
			session.save(auto3);
			session.save(auto4);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			factory.close();
			session.close();
		}
	}
	
	//READ
	private static void read(SessionFactory factory) {
		Session session = factory.getCurrentSession();
		try {
			 
			session.beginTransaction();
			
			User user1 = session.get(User.class, 1);
			
			//List<Auto> allAutos = session.createQuery("from Auto").getResultList();
													  // from Auto a where a.model LIKE 'Porsche%'
			//List<Auto> allAutos = session.createQuery("from Auto a where a.model = :model").setParameter("model", "Porsche 911").getResultList();
			
			//session.detach(user1); // отделяет объект от Hibernate (изменения записей в об этом объекте в БД происходить не будут) 
			//session.remove(user1); // удаляет объект из БД
			session.getTransaction().commit();
			System.out.println(user1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			factory.close();
			session.close();
		}
	}
	
	// UPDATE
	private static void update(SessionFactory factory) {
		Session session = factory.getCurrentSession();
			try {
				session.beginTransaction();
				User user2 = session.get(User.class, 2); // с тех пор, как сделан get объекта, 
				user2.setName("Shiranui Mai");			 // все изменения объекта в коде будут влиять на отображение объекта в базе
				
				//session.createQuery("update Auto set color = 'Black'").executeUpdate(); // формирует обычный запрос в БД
				
				//session.createQuery("delete from Auto where id = 2").executeUpdate();
				
				session.getTransaction().commit();
				System.out.println(user2);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			finally {
				factory.close();
				session.close();
			}
			
			
		}
	
	    // DELETE
		private static void delete(SessionFactory factory) {
			Session session = factory.getCurrentSession();
				try {
					session.beginTransaction();
					User user3 = session.get(User.class, 3);
					session.delete(user3);
					session.getTransaction().commit();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				finally {
					factory.close();
					session.close();
				}
			}
	
	
}
