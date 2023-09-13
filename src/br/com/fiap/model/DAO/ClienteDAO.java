package br.com.fiap.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.model.bean.Cliente;

public class ClienteDAO implements IDAO{
	private Connection con;
	private Cliente cliente;
	
	public ClienteDAO(Connection con) {
		this.con = con;
	}
	
	public Connection getCon() {
		return con;
	}

	public String inserir(Object obj) {
		cliente = (Cliente) obj;
		String sql = "insert into cliente(idCliente, nomeCliente, placa) values(?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getNomeCliente());
			ps.setString(3, cliente.getPlaca());
			if (ps.executeUpdate() > 0) {
				return "Cliente inserido com sucesso";
			} else {
				return "Erro ao inserir ciente";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String alterar(Object obj) {
		cliente = (Cliente) obj;
		String sql = "update cliente set nomeCliente =?, placa=? ";
		sql+="where idCliente = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, cliente.getNomeCliente());
			ps.setString(2, cliente.getPlaca());
			ps.setInt(3, cliente.getIdCliente());
			if (ps.executeUpdate() > 0) {
				return "Cliente alterado com sucesso";
			} else {
				return "Erro ao alterar ciente";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String excluir(Object obj) {
		cliente = (Cliente) obj;
		String sql = "delete from cliente where idCliente=? ";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, cliente.getNomeCliente());
			if (ps.executeUpdate() > 0) {
				return "Cliente excluido com sucesso";
			} else {
				return "Erro ao excluir ciente";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String listarTodos() {
		String sql = "select * from cliente";
		String listaCliente= "Lista dos clientes \n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					listaCliente += "Id do Cliente: " + rs.getString(1)+"\n";
					listaCliente += "Nome do Cliente: " + rs.getString(2)+"\n";
					listaCliente += "Descriacao: " + rs.getString(3)+"\n\n";
				}
				return listaCliente;
			}else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}		
	}
}
