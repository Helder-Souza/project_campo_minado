package br.com.helder.cm.visao;

import javax.swing.JFrame;

import br.com.helder.cm.modelo.Tabuleiro;

public class TelaPrincipal extends JFrame {

	public TelaPrincipal() {
		Tabuleiro tabuleiro = new Tabuleiro(16, 30, 15);
		add(new PainelTabuleiro(tabuleiro));
		
		setTitle("Campo Minado");
		setSize(677, 440); // setSize(690, 438)
		setLocationRelativeTo(this);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TelaPrincipal();
	}
}