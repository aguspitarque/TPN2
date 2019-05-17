package ar.edu.unlam.pb2.tp2;



public class CuentaSueldo {
	protected Double saldo;
	
	public CuentaSueldo(Double saldo) {
		this.saldo = saldo;
		
	}
	
	public Boolean extraer(Double cantidad) {
		if(cantidad>this.saldo) {
			return false;
		}
		else {
			this.saldo = this.saldo-cantidad;
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
		int result = 1;
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaSueldo other = (CuentaSueldo) obj;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		return true;
	}
}
