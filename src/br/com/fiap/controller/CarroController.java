package br.com.fiap.controller;

import java.sql.Connection;

import br.com.fiap.model.DAO.CarroDAO;
import br.com.fiap.model.DAO.Conexao;
import br.com.fiap.model.bean.Carro;

public class CarroController {
	
	public String insereCarro(String placa, String cor, String descricao){
		String resultado;
		Connection con = Conexao.abrirConexao();
		Carro carroBean = new Carro();
		carroBean.setPlaca(placa);
		carroBean.setCor(cor);
		carroBean.setDescricao(descricao);
		CarroDAO carroDao = new CarroDAO(con);
		resultado = carroDao.inserir(carroBean);
		Conexao.fecharConexao(con);
		return resultado;
	}
	
	public String alteraCarro(String placa, String cor, String descricao){
		String resultado;
		Connection con = Conexao.abrirConexao();
		Carro carroBean = new Carro();
		carroBean.setPlaca(placa);
		carroBean.setCor(cor);
		carroBean.setDescricao(descricao);
		CarroDAO carroDao = new CarroDAO(con);
		resultado = carroDao.alterar(carroBean);
		Conexao.fecharConexao(con);
		return resultado;
	}
	
	public String excluirCarro(String placa) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Carro carroBean = new Carro();
		carroBean.setPlaca(placa);			
		CarroDAO carroDao = new CarroDAO(con);
		resultado = carroDao.excluir(carroBean);
		Conexao.fecharConexao(con);
		return resultado;			
	}
	
	public String listaCarro() {
		String resultado = "";
		Connection con = Conexao.abrirConexao();
		CarroDAO CarroDao = new CarroDAO(con);
		resultado = CarroDao.listarTodos();
		Conexao.fecharConexao(con);
		return (resultado!=null)? resultado : null;
	}
}
