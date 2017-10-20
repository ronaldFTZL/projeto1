package br.sceweb.model;

import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.sceweb.servico.ConfiguraDB;
import br.sceweb.servico.FabricaDeConexoes;

/**
 * Esta classe registra as informações de empresas que podem oferecer estagio para alunos
 * @author Lab103
 * @version 1
 *
 */
public class EmpresaDAO {
	
	ConfiguraDB configuraDB;
	
	public EmpresaDAO (ConfiguraDB db){
		this.configuraDB = db;
	}
	
	public int adiciona(Empresa empresa){
		PreparedStatement ps;
		int codigoRetorno=0;
		try (Connection conn = new FabricaDeConexoes(configuraDB).getConnection()){
		ps = (PreparedStatement) conn.prepareStatement(
		"insert into empresa (cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone) values(?,?,?,?,?)");
			ps.setString(1,empresa.getCnpj());
			ps.setString(2, empresa.getNomeDaEmpresa());
			ps.setString(3, empresa.getNomeFantasia());
			ps.setString(4, empresa.getEndereco());
			ps.setString(5, empresa.getTelefone());
			codigoRetorno = ps.executeUpdate();
			ps.close();
				
			} catch (SQLException e){
				System.out.println("erro = " + e.getMessage());
				
			}
		return codigoRetorno;
	}
	/**
	* exclui uma empresa pelo cnpj
	 * @param cnpj
	 * @return 0 erro na exclusao ou 1 excluido com sucesso
	 */
	public int exclui (String cnpj) {
		java.sql.PreparedStatement ps;
		int codigoretorno = 0;
		try (Connection conn = new FabricaDeConexoes(configuraDB).getConnection()) {
			ps= conn.prepareStatement ("delete from empresa where cnpj = ?");
			ps.setString(1, cnpj);
			codigoretorno = ps.executeUpdate();
		}
		catch (SQLException e){
			System.out.println("erro metodo excluir = " + e.getMessage());
		}
		return codigoretorno;
	}
		

}
