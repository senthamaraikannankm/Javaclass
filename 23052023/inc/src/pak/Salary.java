package pak;

 

public class Salary {

	private double basic;
	private double da;
	private double pf;
	private double gross;
	private double net;

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
		 getDa();
		 getPf();
		 getGross(); 
		 getNet();
	}

	public double getDa() {
		return  this.da =  ((basic*42)/100);
	}
 

	public double getPf() {
		return this.pf = ((basic*12)/100);
	}

 
	public double getGross() {
		return this.gross =  this.basic + this.da + this.pf ;
	}


	public double getNet() {
		return this.net =  this.gross -  this.pf  ;
	}

 
	@Override
	public String toString() {
		return "\n ******** Salary [basic=" + basic + ", da=" + da + ", pf=" + pf + " ,gross "+ gross + " ,Net " + net + "] ********* \n";
	}

}