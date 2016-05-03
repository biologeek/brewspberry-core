package net.brewspberry.business;

import net.brewspberry.business.beans.Actioner;

public interface ISpecificActionerLauncherService {

	public Actioner startAction(Actioner actioner) throws Exception;

	public Actioner stopAction(Actioner actioner) throws Exception;
}
