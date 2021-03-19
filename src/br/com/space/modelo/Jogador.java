package br.com.space.modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Jogador {

	private int x, y;
	private int dx, dy;
	private Image imgJogador;
	private int largura, altura;
	private List<Tiro> tiros;

	public Jogador() {

		// Inicializando posicao do jogador
		this.x = 100;
		this.y = 100;
		tiros = new ArrayList<Tiro>();
	}

	public void load() {

		// carregando img do jogador
		ImageIcon img = new ImageIcon("res\\jogador.png");
		imgJogador = img.getImage();

		this.altura = imgJogador.getHeight(null);
		this.largura = imgJogador.getWidth(null);
	}

	public void update() {
		x += dx;
		y += dy;
	}

	public void tiro() {

		this.tiros.add(new Tiro(x + largura, y + (altura / 2)));
	}

	public void keypressed(KeyEvent event) {

		int evento = event.getKeyCode();

		System.out.println("Jogador.keypressed() ->  " + event.getExtendedKeyCode());

		if (evento == KeyEvent.VK_W) {
			dy = -3;
		}
		if (evento == KeyEvent.VK_S) {
			dy = 3;
		}
		if (evento == KeyEvent.VK_A) {
			dx = -3;
		}
		if (evento == KeyEvent.VK_D) {
			dx = 3;
		}

		// ACAO DE TIRO
		if (evento == KeyEvent.VK_P) {

			tiro();
		}

		if (evento == KeyEvent.VK_F3) {

		}
	}

	public void keyRelease(KeyEvent event) {

		int evento = event.getKeyCode();

		if (evento == KeyEvent.VK_W) {
			dy = 0;
		}
		if (evento == KeyEvent.VK_S) {
			dy = 0;
		}
		if (evento == KeyEvent.VK_A) {
			dx = 0;
		}
		if (evento == KeyEvent.VK_D) {
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

	public List<Tiro> getTiros() {
		return tiros;
	}

}
