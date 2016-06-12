package edu.entity.pessoas.funcionarios;

import edu.entity.pessoas.Funcionario;

public class Atendente extends Funcionario {
	
	@Override
	public Double calcSalario() {
		return super.getSalarioBase() * (this.getBonus()/100);
	}
	
}
