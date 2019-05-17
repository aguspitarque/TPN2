package ar.edu.unlam.pb2.tp2;


public class CajaDeAhorro extends CuentaSueldo{
	public CajaDeAhorro(Double saldo) {
		super(saldo);
	}
	
	public Boolean extraer(Double cantidad) {
		Integer i;
		for(i=0;i<6;i++) {
		if(cantidad>this.saldo) {
			return false;
		}
		else {
			this.saldo= this.saldo-cantidad;
			return true;
		}
	}
		if(cantidad>this.saldo) {
			return false;
		}
		else {
			this.saldo= this.saldo-cantidad-6.0;
			return true;
		}
		
		
	}
	
	public void depositar(Double cantidad) {
		this.saldo = this.saldo+cantidad;
	}
	

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CajaDeAhorro other = (CajaDeAhorro) obj;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		return true;
	}
	
}
