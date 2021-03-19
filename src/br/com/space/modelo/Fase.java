package br.com.space.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import br.com.space.util.TecladoAdapter;

public class Fase extends JPanel implements ActionListener {

	private static final long serialVersionUID = -4956115614909783906L;

	private Image background;
	private Jogador jogador;
	private Timer timer;
	private List<Inimigo1> inimigo;

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

		iniciarInimigos();

	}

	public void iniciarInimigos() {

		int aux[] = new int[20];
		this.inimigo = new ArrayList<Inimigo1>();

		for (int i = 0; i < aux.length; i++) {
			int x = (int) (Math.random() * 800 + 600);
			int y = (int) (Math.random() * 650 + 30);
			inimigo.add(new Inimigo1(x, y));
		}
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

		for (int o = 0; o < inimigo.size(); o++) {
			Inimigo1 in = inimigo.get(o);
			in.load();
			graphics2d.drawImage(in.getImagem(), in.getX(), in.getY(), this);
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

		for (int o = 0; o < inimigo.size(); o++) {
			Inimigo1 in = inimigo.get(o);
			if (in.isVisivel()) {
				in.update();
			} else {
				inimigo.remove(o);
			}
			repaint();
		}

	}

}
