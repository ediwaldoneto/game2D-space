package br.com.space.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.Timer;

import br.com.space.util.TecladoAdapter;

public class Fase extends JPanel implements ActionListener {

	private static final long serialVersionUID = -4956115614909783906L;

	private Image background;
	private Jogador jogador;
	private Timer timer;

	public Fase() {

		setFocusable(true);
		setDoubleBuffered(false);

		ImageIcon ref = new ImageIcon("res\\back.jpg");
		background = ref.getImage();

		jogador = new Jogador();
		jogador.load();
		addKeyListener(new TecladoAdapter(this.jogador));

		timer = new Timer(5, this);
		timer.start();

	}

	public void paint(Graphics graphics) {

		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.drawImage(background, 0, 0, null);
		graphics2d.drawImage(jogador.getImgJogador(), jogador.getX(), jogador.getY(), this);

		List<Tiro> tiros = jogador.getTiros();

		for (int i = 0; i < tiros.size(); i++) {
			Tiro t = tiros.get(i);
			t.load();
			graphics2d.drawImage(t.getImg(), t.getX(), t.getY(), this);
		}

		graphics.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		jogador.update();

		List<Tiro> tiros = jogador.getTiros();

		for (int i = 0; i < tiros.size(); i++) {
			Tiro t = tiros.get(i);
			if (t.isVisivel()) {
				t.update();
			} else {
				tiros.remove(i);
			}
		}

		repaint();

	}

}
