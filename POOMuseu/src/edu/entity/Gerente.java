package edu.entity;

public class Gerente extends Funcionario{
		
	@Override
	public Double calcSalario() {
		return super.getSalarioBase() * (this.getBonus()/100);
	}
}
