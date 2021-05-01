package br.com.space.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
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
	private boolean isGame;

	public Fase() {

		setFocusable(true);
		setDoubleBuffered(false);

		ImageIcon ref = new ImageIcon("res\\back.png");
		background = ref.getImage();

		jogador = new Jogador();
		jogador.load();
		
		addKeyListener(new TecladoAdapter(this.jogador));

		timer = new Timer(5, this);
		timer.start();

		iniciarInimigos();
		isGame = true;

	}

	// Iniciando inimigos

	public void iniciarInimigos() {

		int aux[] = new int[120];
		this.inimigo = new ArrayList<Inimigo1>();

		for (int i = 0; i < aux.length; i++) {
			int x = (int) (Math.random() * 7025 + 1024);
			int y = (int)((Math.random() * 768)  - (Math.random() * 768));
			inimigo.add(new Inimigo1(x, y));
		}
	}

	// Verifica as colisao

	public void verificaColisao() {

		Rectangle nave = jogador.getBounds();
		Rectangle tiro1;
		Rectangle enemy;

		for (int i = 0; i < inimigo.size(); i++) {

			Inimigo1 ini = inimigo.get(i);
			enemy = ini.getBounds();
			if (nave.intersects(enemy)) {
				jogador.setVisible(false);
				ini.setVisivel(false);
				isGame = false;
			}
		}

		List<Tiro> tiros = jogador.getTiros();

		for (int j = 0; j < tiros.size(); j++) {

			Tiro tmpTiro = tiros.get(j);
			tiro1 = tmpTiro.getBounds();

			for (int l = 0; l < inimigo.size(); l++) {
				Inimigo1 ini = inimigo.get(l);
				enemy = ini.getBounds();
				if (tiro1.intersects(enemy)) {
					ini.setVisivel(false);
					tmpTiro.setVisivel(false);
				}
			}

		}
	}

	public void paint(Graphics graphics) {

		Graphics2D graphics2d = (Graphics2D) graphics;

		if (isGame) {

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
		} else {
			ImageIcon gameOver = new ImageIcon("res\\gameover.png");
			graphics2d.drawImage(gameOver.getImage(), 0, 0, null);
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

		for (int j = 0; j < inimigo.size(); j++) {
			Inimigo1 in = inimigo.get(j);
			if (in.isVisivel()) {
				in.update();
			} else {
				inimigo.remove(j);
			}

		}
		verificaColisao();
		repaint();
	}

}
