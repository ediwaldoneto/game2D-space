package br.com.space.modelo;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Contador extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1613513099988059844L;
	JLabel label;
	Timer timer;

	public Contador(String pontos) {
		this.add(getLabel(pontos));
		this.go(pontos);
	}

	public JLabel getLabel(String pontos) {
		if (this.label == null) {
			this.label = new JLabel(pontos);
			this.label.setPreferredSize(new Dimension(100, 22));
		}

		return this.label;
	}

	public void go(String pontos) {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText(pontos);
			}
		};
		this.timer = new Timer(1000, action);
		this.timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
