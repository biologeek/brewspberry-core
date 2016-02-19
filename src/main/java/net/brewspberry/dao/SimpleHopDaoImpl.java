package net.brewspberry.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import net.brewspberry.business.IGenericDao;
import net.brewspberry.business.beans.SimpleHoublon;
import net.brewspberry.exceptions.DAOException;
import net.brewspberry.util.HibernateUtil;

public class SimpleHopDaoImpl implements IGenericDao<SimpleHoublon> {

	private Session session = HibernateUtil.getSession();

	@Override
	public void deleteElement(long arg0) {

		session.delete((SimpleHoublon) session.get(SimpleHoublon.class, arg0));
		HibernateUtil.closeSession();
	}

	@Override
	public void deleteElement(SimpleHoublon arg0) {
		session.delete(arg0);
		HibernateUtil.closeSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SimpleHoublon> getAllDistinctElements() {

		Transaction tx = session.beginTransaction();
		List<SimpleHoublon> result = new ArrayList<SimpleHoublon>();

		try {
			result = session.createQuery("from SimpleHoublon group by ing_desc").list();
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			HibernateUtil.closeSession();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SimpleHoublon> getAllElements() {
		return (List<SimpleHoublon>) session.createQuery("from SimpleHoublon").list();
	}

	@Override
	public SimpleHoublon getElementById(long arg0) {
		Transaction tx = session.beginTransaction();
		SimpleHoublon result = new SimpleHoublon();
		try {	
			result = (SimpleHoublon) session.get(SimpleHoublon.class, arg0);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}
		session.evict(result);
		HibernateUtil.closeSession();
		return result;
	}

	@Override
	public SimpleHoublon save(SimpleHoublon arg0) throws DAOException {
		Transaction tx = session.beginTransaction();
		SimpleHoublon result = new SimpleHoublon();
		try {

			long resultId = (long) session.save(arg0);
			result = (SimpleHoublon) session.get(SimpleHoublon.class, resultId);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			HibernateUtil.closeSession();
		}
		return result;
	}

	@Override
	public SimpleHoublon update(SimpleHoublon arg0) {
		Transaction tx = session.beginTransaction();

		SimpleHoublon result = new SimpleHoublon();

		if (arg0.getIng_id() != 0) {
			try {
				session.update(arg0);
				tx.commit();
				result = arg0;

			} catch (HibernateException e) {
				e.printStackTrace();
				tx.rollback();
			}
			finally {
				HibernateUtil.closeSession();
			}
		} else {

			try {
				result = this.save(arg0);
			} catch (HibernateException | DAOException e) {
				e.printStackTrace();
				tx.rollback();
			}
			finally {
				HibernateUtil.closeSession();
			}
		}
		return result;
	}

	@Override
	public SimpleHoublon getElementByName(String name) {
		
		SimpleHoublon result = (SimpleHoublon) session.createQuery("from SimpleHoublon where hbl_variete = '"+name+"'").uniqueResult();

		HibernateUtil.closeSession();
		return result;
		
	}
}