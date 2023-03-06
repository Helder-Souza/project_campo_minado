package br.com.helder.cm.visao;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import br.com.helder.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {

	public PainelTabuleiro(Tabuleiro tabuleiro) {
		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));
		
		tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
		
		tabuleiro.registrarObservador(e -> {
			
			SwingUtilities.invokeLater(() -> {
				if(e.isGanhou()) {
					Icon ganhou = new ImageIcon(getClass().getResource("icones/ganhou.jpg"));
					
					JLabel label = new JLabel("Ganhou :)", ganhou, SwingConstants.CENTER);
					label.setHorizontalTextPosition(SwingConstants.CENTER);
					
					label.setVerticalTextPosition(SwingConstants.TOP);
					label.setPreferredSize(new Dimension(230, 230));
					
					JOptionPane.showMessageDialog(this, label);
					
				} else {
					Icon perdeu = new ImageIcon(getClass().getResource("icones/perdeu.jpg"));
					
					JLabel label2 = new JLabel("Perdeu :(", perdeu, SwingConstants.CENTER);
					label2.setHorizontalTextPosition(SwingConstants.CENTER);
					
					label2.setVerticalTextPosition(SwingConstants.TOP);
					label2.setPreferredSize(new Dimension(230, 230));
					JOptionPane.showMessageDialog(this, label2);
				}
				
				tabuleiro.reiniciar();
			});
		});
	}
}
