package com.chi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import com.chi.film.Movie;

public class SearchMovieDaoImpl implements SearchMovieDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Movie> searchAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Movie> list = null;
		try {
			String hql = "select * from Movie ";
			Query query = session.createSQLQuery(hql)
					.addScalar("id", IntegerType.INSTANCE) 
			        .addScalar("movieName", StringType.INSTANCE) 
			        .addScalar("movieNumber", IntegerType.INSTANCE) ;
			query.setResultTransformer(Transformers.aliasToBean(com.chi.film.Movie.class));
			list = query.list();
			session.getTransaction().commit();						
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}				
		
		return list;
	}
	
	public boolean minusNumber(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Movie> list = null;
		try {
			String hql = "update Movie  set movieNumber = movieNumber + 1 where id = 2";
			Query query = session.createSQLQuery(hql) ;
            query.executeUpdate();
			session.getTransaction().commit();	
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}		
		
	}
}
