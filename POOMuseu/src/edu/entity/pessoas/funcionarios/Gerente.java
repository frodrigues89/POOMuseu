package edu.entity.pessoas.funcionarios;

import edu.entity.pessoas.Funcionario;

public class Gerente extends Funcionario{
		
	@Override
	public Double calcSalario() {
		return super.getSalarioBase() * (this.getBonus()/100);
	}
}
