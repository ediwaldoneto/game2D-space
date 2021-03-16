package br.com.space;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import br.com.space.modelo.Fase;

public class Container extends JFrame {

	private static final long serialVersionUID = 2271094873264268584L;

	public Container() throws HeadlessException {

		add(new Fase());

		this.setTitle("Space");
		this.setSize(1000,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

	}

	public static void main(String[] args) {

		new Container();
	}

}
