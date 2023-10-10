package pkg;

import java.util.ArrayList;

public class Cuenta {

	private Double saldo;
	private String numero, titular;
	private ArrayList<Movimiento> listaMovimientos;
	int i;

	public Cuenta(String string, String string2, double i) {
		this.numero = string;
		this.titular = string2;
		this.saldo = i;
		this.i = 1;
		setListaMovimientos(new ArrayList<Movimiento>());
		this.listaMovimientos.add(new Movimiento(i, Movimiento.Signo.H, "Saldo inicial " + i + "€"));
	}

	public void ingreso(int i) {
		// TODO Auto-generated method stub
		this.saldo = this.saldo + i;
		this.listaMovimientos.add(new Movimiento(i, Movimiento.Signo.D, "Ingreso de " + i + "€ (" + this.i + ")"));
		this.i++;
	}

	public void reintegro(int i) throws Exception {
		// TODO Auto-generated method stub
		if ((this.saldo + i) < 500) {
			this.saldo = this.saldo - i;
			this.listaMovimientos.add(new Movimiento(i, Movimiento.Signo.H, "Reintegro de " + i + "€ (" + this.i + ")"));
			this.i++;
		}
		throw new Exception("Fondos insuficientes (saldo " + this.saldo + "€) en la cuenta " + this.numero
				+ " para el reintegro de " + i + "€");

	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public ArrayList<Movimiento> getListaMovimientos() {
		return listaMovimientos;
	}

	public void setListaMovimientos(ArrayList<Movimiento> listaMovimientos) {
		this.listaMovimientos = listaMovimientos;
	}

}
