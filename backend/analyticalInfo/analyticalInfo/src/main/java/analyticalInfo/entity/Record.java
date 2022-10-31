package analyticalInfo.entity;

import java.util.Date;
import java.util.UUID;

import org.hibernate.envers.Audited;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "record")
@Audited

public class Record {
	
	@Id
	private UUID id; 
	private Date searchDate; 
	private String action; 
	private String origen; 
	private String IP;
	
	public Record() {}
	
	public Record(Date searchDate, String action, String origen, String iP) {
		super();
		this.searchDate = searchDate;
		this.action = action;
		this.origen = origen;
		IP = iP;
	}

	public Date getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(Date searchDate) {
		this.searchDate = searchDate;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		this.IP = iP;
	} 
	
	 @Override
	    public String toString() {
	        return "Record{" +
	                "id=" + id +
	                ", Date='" + searchDate + '\'' +
	                ", make='" + action + '\'' +
	                ", model='" + origen + '\'' +
	                ", status='" + IP + '\'' +
	                '}';
	    }
	
	
	
	

}
