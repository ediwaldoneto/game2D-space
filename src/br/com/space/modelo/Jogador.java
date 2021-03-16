package br.com.space.modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Jogador {

	private int x, y;
	private int dx, dy;
	private Image imgJogador;
	private int largura, altura;

	public Jogador() {

		// Inicializando posicao do jogador
		this.x = 100;
		this.y = 100;
	}

	public void load() {

		// carregando img do jogador
		ImageIcon img = new ImageIcon("res\\jogador.png");
		imgJogador = img.getImage();

		altura = imgJogador.getHeight(null);
		largura = imgJogador.getWidth(null);
	}

	public void update() {
		x += dx;
		y += dy;
	}

	public void keypressed(KeyEvent event) {

		int evento = event.getKeyCode();
		
		System.out.println("Jogador.keypressed() ->  " + event.getExtendedKeyCode());
		
		if (evento == KeyEvent.VK_UP) {
			dy = -3;
		}
		if (evento == KeyEvent.VK_DOWN) {
			dy = 3;
		}
		if (evento == KeyEvent.VK_LEFT) {
			dx = -3;
		}
		if (evento == KeyEvent.VK_RIGHT) {
			dx = 3;
		}
	}

	public void keyRelease(KeyEvent event) {

		int evento = event.getKeyCode();
		
		System.out.println("Jogador.keyRelease() -> " + event.getExtendedKeyCode());
		
		if (evento == KeyEvent.VK_UP) {
			dy = 0;
		}
		if (evento == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		if (evento == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if (evento == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImgJogador() {
		return imgJogador;
	}

}
