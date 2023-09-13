package br.com.fiap.controller;

import java.sql.Connection;

import br.com.fiap.model.DAO.ClienteDAO;
import br.com.fiap.model.DAO.Conexao;
import br.com.fiap.model.bean.Cliente;

public class ClienteController {
	
	public String  insereCliente(int id, String nome, String placa) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Cliente clienteBean = new Cliente();
		clienteBean.setIdCliente(id);
		clienteBean.setNomeCliente(nome);
		clienteBean.setPlaca(placa);
		ClienteDAO clienteDao = new ClienteDAO(con);
		resultado = clienteDao.inserir(clienteBean);
		Conexao.fecharConexao(con);
		return resultado;
	}
	
	public String alteraCliente(int id, String nome, String placa) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Cliente clienteBean = new Cliente();
		clienteBean.setIdCliente(id);
		clienteBean.setNomeCliente(nome);
		clienteBean.setPlaca(placa);
		ClienteDAO clienteDao = new ClienteDAO(con);
		resultado = clienteDao.alterar(clienteBean);
		Conexao.fecharConexao(con);
		return resultado;
	}
	
	public String excluiCliente(int id, String nome, String placa) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Cliente clienteBean = new Cliente();
		clienteBean.setPlaca(placa);
		ClienteDAO clienteDao = new ClienteDAO(con);
		resultado = clienteDao.excluir(clienteBean);
		Conexao.fecharConexao(con);
		return resultado;
	}
	
	public String listaCliente() {
		String resultado = "";
		Connection con = Conexao.abrirConexao();
		ClienteDAO ClienteDao = new ClienteDAO(con);
		resultado = ClienteDao.listarTodos();
		Conexao.fecharConexao(con);
		return (resultado!=null)? resultado : null;
	}
	
}
