package net.brewspberry.business.service;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.DatatypeConstants.Field;

import net.brewspberry.business.IGenericDao;
import net.brewspberry.business.IGenericService;
import net.brewspberry.business.ISpecificEtapeService;
import net.brewspberry.business.beans.DurationBO;
import net.brewspberry.business.beans.Etape;
import net.brewspberry.exceptions.DAOException;
import net.brewspberry.util.DateManipulator;
import net.brewspberry.dao.EtapeDaoImpl;

public class EtapeServiceImpl implements IGenericService<Etape>, ISpecificEtapeService {

	
	
	IGenericDao<Etape> etapeDao = new EtapeDaoImpl();
	@Override
	public Etape save(Etape arg0) throws DAOException {
		
		return etapeDao.save(arg0);
	}

	@Override
	public Etape update(Etape arg0) {
		
		return etapeDao.update(arg0);
	}

	@Override
	public Etape getElementById(long id) {
		return etapeDao.getElementById(id);
	}

	@Override
	public List<Etape> getAllElements() {
		return etapeDao.getAllElements();
	}

	@Override
	public void deleteElement(long id) {
		etapeDao.deleteElement(id);
		
	}

	@Override
	public void deleteElement(Etape arg0) {
		etapeDao.deleteElement(arg0);		
	}

	@Override
	public List<Etape> getAllDistinctElements() {
		return etapeDao.getAllDistinctElements();
	}

	@Override
	public Etape terminateStep(Etape etape) {
		

		if (etape != null){
			
			etape.setEtp_fin(new Date());
			
			etape.setEtp_duree(DateManipulator.getInstance().getDurationBetween(etape.getEtp_debut(), etape.getEtp_fin()));
			
		}
		
		this.update(etape);
		return etape;
	}

}
