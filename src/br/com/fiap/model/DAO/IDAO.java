package br.com.fiap.model.DAO;

public interface IDAO {
	
	public String inserir(Object obj);
	
	public String alterar (Object obj);
	
	public String excluir (Object obj);
	
	public String listarTodos();
	
}
