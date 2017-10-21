package br.sceweb.model;

import java.util.InputMismatchException;

/**
 * Esta classe registra as informações das empresas que estao autorizadas a
 * oferecer estagio para alunos
 * 
 * @author professor
 * @version 1.0
 *
 */
public class Empresa {
	String cnpj;
	String nomeDaEmpresa;
	String nomeFantasia;
	String endereco;
	String telefone;

	public String getCnpj() {
		return cnpj;
	}

	public String setCnpj(String cnpj) {
		String msg = "";
		if (isValido(cnpj)) {
			this.cnpj = cnpj;
		} else {
			msg = "CNPJ invalido.";
		}
		return msg;
	}

	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}

	public String setNomeDaEmpresa(String nomeDaEmpresa) {
		String msg = "";
		if (isValido(nomeDaEmpresa)) {
			this.nomeDaEmpresa = nomeDaEmpresa;

		} else {
			msg = " Nome Invalido";
			return msg;
		}
		return nomeDaEmpresa;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean validaNome(String nomeEmpresa) {
		if (cnpj.equals(" ")) {
			this.nomeDaEmpresa = nomeEmpresa;
		} else {
			return false;
		}
		return true;
	}

	/*
	 * valida o cnpj
	 */
	public boolean isValido(String cnpj) {
		char dig13, dig14;
		int sm, i, r, num, peso;
		if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222")
				|| cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
				|| cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888")
				|| cnpj.equals("99999999999999") || (cnpj.length() != 14)) {
			return (false);
		}
		// "try" - protege o código para eventuais erros de conversao de tipo
		// (int)
		try { // Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {
				// converte o i-ésimo caractere do CNPJ em um número:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posição de '0' na tabela ASCII)
				num = (int) (cnpj.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}
			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - r) + 48);

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (cnpj.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}
			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - r) + 48);
			// Verifica se os dígitos calculados conferem com os dígitos
			// informados.
			if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13)))
				return (true);
			else
				return (false);
		}

		catch (InputMismatchException erro) {
			erro.printStackTrace();
			return (false);
		}
	}

}
