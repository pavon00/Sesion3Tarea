package pkg;

import java.util.ArrayList;

public class Cuenta {

	private Double saldo;
	private String numero, titular;
	private ArrayList<Movimiento> listaMovimientos;
	static int contador;

	public Cuenta(String string, String string2, double i) {
		this.numero = string;
		this.titular = string2;
		this.saldo = i;
		contador = 0;
		setListaMovimientos(new ArrayList<Movimiento>());
	}

	public boolean seEncuentraMovimientoDetalle(String s) {
		for (Movimiento movimiento : listaMovimientos) {
			if (movimiento.getDetalle().equals(s)) {
				return true;
			}
		}
		return false;
	}

	public boolean seEncuentranMovimientosDetalles(ArrayList<String> detalles) {
		for (String d : detalles) {
			if (!seEncuentraMovimientoDetalle(d)) {
				return false;
			}
		}
		return true;
	}

	public void ingreso(int i) {
		// TODO Auto-generated method stub
		this.saldo = this.saldo + i;
		this.listaMovimientos.add(new Movimiento(i, Movimiento.Signo.D, "Ingreso de " + i + "€ (" + contador + ")"));
		contador++;
	}

	public void reintegro(int i) throws Exception {
		// TODO Auto-generated method stub
		if ((this.saldo - i) >= -500) {
			this.saldo = this.saldo - i;
			this.listaMovimientos
					.add(new Movimiento(i, Movimiento.Signo.H, "Reintegro de " + i + "€ (" + contador + ")"));
			contador++;
		} else {
			contador++;
			throw new Exception("Fondos insuficientes (saldo " + this.saldo + "€) en la cuenta " + this.numero
					+ " para el reintegro de " + i + "€ (" + (contador-1) + ")");
		}

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
