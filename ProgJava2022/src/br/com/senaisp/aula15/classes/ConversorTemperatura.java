package br.com.senaisp.aula15.classes;

import javax.management.InvalidAttributeValueException;
/**
 * Classe desenvolvida para conversão de temperaturas
 * @author Richard Brosler
 * @version 1.0.0.0
 *
 */
public class ConversorTemperatura {
	private int intOrigem;
	private int intDestino;
	private double dblTemperatura;
	//Constructor
	public ConversorTemperatura() {
		this.intOrigem = 1;
		this.intDestino = 1;
		dblTemperatura = 0;
	}
	public int getIntOrigem() {
		return intOrigem;
	}
	/**
	 * Setter para informar qual temperatura origem para converter a temperatura
	 * Valores válidos são 1 - Celsius, 2 - Fahrenheit ou 3 - Kelvin
	 * @param intOrigem Deve ser informado os valores 1, 2 ou 3
	 * @throws InvalidAttributeValueException Se valores forem inválidos, causam uma exceção
	 */
	public void setIntOrigem(int intOrigem) throws InvalidAttributeValueException {
		if (intOrigem != 1 && intOrigem != 2 && intOrigem !=3) {
			throw new InvalidAttributeValueException("Valores válidos são 1, 2 ou 3!");
		}
		this.intOrigem = intOrigem;
	}
	public int getIntDestino() {
		return intDestino;
	}
	/**
	 * Setter para informar qual temperatura destino será convertida a temperatura
	 * Valores válidos são 1 - Celsius, 2 - Fahrenheit ou 3 - Kelvin
	 * @param intDestino Deve ser informado os valores 1, 2 ou 3
	 * @throws InvalidAttributeValueException Se valores forem inválidos, causam uma exceção
	 */
	public void setIntDestino(int intDestino) throws InvalidAttributeValueException {
		if (intDestino != 1 && intDestino != 2 && intDestino !=3) {
			throw new InvalidAttributeValueException("Valores válidos são 1, 2 ou 3!");
		}
		this.intDestino = intDestino;
	}
	public double getDblTemperatura() {
		return dblTemperatura;
	}
	public void setDblTemperatura(double dblTemperatura) {
		this.dblTemperatura = dblTemperatura;
	}
	/**
	 * Método público que irá retornar a temperatura calculada de acordo com 
	 * os campos preenchidos
	 * @return Retorna a temperatura calculada
	 */
	public double getTemperaturaConvertida() {
		return calcularTemperatura();
	}
	/**
	 * Método interno para calcular a temperatura
	 * @return Retorna a temperatura calculada conforme os campos forem preenchidos
	 */
	private double calcularTemperatura() {
		double dblTempConv=dblTemperatura;
		if (this.intOrigem == 1) { // testando origem celsius
			if (this.intDestino == 2) { // testando destino Fahrenheit
				dblTempConv = this.dblTemperatura * 9 / 5 + 32;
			} else if (this.intDestino == 3) { // testando destino kelvin
				dblTempConv = this.dblTemperatura + 273;
			}
		} else if (this.intOrigem == 2) { // testando origem fahrenheit
			if (this.intDestino == 1) { // testando destino Celsius
				dblTempConv = ( this.dblTemperatura - 32 ) * 5 / 9;
			} else if (this.intDestino == 3) { // testando destino kelvin
				dblTempConv = ( this.dblTemperatura - 32 ) * 5 / 9 + 273;
			}
		} else { // Calculand origem Kelvin
			if (this.intDestino == 1) { // testando destino Celsius
				dblTempConv = this.dblTemperatura - 273;
			} else if (this.intDestino == 2) { // testando destino Fahenheit
				dblTempConv = ( this.dblTemperatura - 273 ) * 9 / 5 + 32;
			}
		}
		return dblTempConv;
	}
}
