package br.com.fiap.view;

import javax.swing.JOptionPane;

import br.com.fiap.controller.CarroController;

public class CarroView {

	public static void main(String[] args) {
		String aux, escolha = "sim", placa, cor, descricao;
		int opcao;

		CarroController carro = new CarroController();
		while (escolha.equalsIgnoreCase("sim")) {
			try {
				aux = JOptionPane.showInputDialog("Escolha: \n" + "[1]-Insere\n[2]-Altera\n[3]-Exclui");
				opcao = Integer.parseInt(aux);
				placa = JOptionPane.showInputDialog("Digite a placa do carro: ");
				
				switch (opcao) {
				
				case 1:
					cor = JOptionPane.showInputDialog("Digite a cor do carro");
					descricao = JOptionPane.showInputDialog("Digite a descricao do carro");
					System.out.println(carro.insereCarro(placa, cor, descricao));
					JOptionPane.showMessageDialog(null, carro.listaCarro());					
					break;
				case 2:
					cor = JOptionPane.showInputDialog("Digite a cor do carro");
					descricao = JOptionPane.showInputDialog("Digite a descricao do carro");
					System.out.println(carro.alteraCarro(placa, cor, descricao));
					JOptionPane.showMessageDialog(null, carro.listaCarro());
					break;
				case 3:
					System.out.println(carro.excluirCarro(placa));
					JOptionPane.showConfirmDialog(null, carro.listaCarro());
					break;
				default:
					System.out.println("Escolha incorreta");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			escolha = JOptionPane.showInputDialog("Deseja continuar?");
		}

		JOptionPane.showMessageDialog(null, "fim do programa");
	}

}
