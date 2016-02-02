package net.brewspberry.business.beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import net.brewspberry.business.beans.SimpleHoublon;


@Entity
public class Houblon extends SimpleHoublon implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -7373607373918515813L;


	/**
	 * 
	 */
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="hbl_bra_id")
    private Brassin hbl_brassin;
    
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="hbl_etp_id")
    private Etape hbl_etape;
    
    
	public Houblon() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Brassin getHbl_brassin() {
		return hbl_brassin;
	}


	public void setHbl_brassin(Brassin hbl_brassin) {
		this.hbl_brassin = hbl_brassin;
	}


	public Etape getHbl_etape() {
		return hbl_etape;
	}


	public void setHbl_etape(Etape hbl_etape) {
		this.hbl_etape = hbl_etape;
	}
	
	
	
    
	
    
}