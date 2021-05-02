package br.com.space.modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import br.com.space.Container;


public class Jogador {

	private int x, y;
	private int dx, dy;
	private Image imgJogador;
	private int largura, altura;
	private List<Tiro> tiros;
	private boolean isVisible;

	public Jogador() {

		this.x = 100;
		this.y = 100;
		tiros = new ArrayList<Tiro>();
		isVisible = true;
	}

	public void load() {

		ImageIcon img = new ImageIcon("res\\jogador.png");
		imgJogador = img.getImage();

		this.altura = imgJogador.getHeight(null);
		this.largura = imgJogador.getWidth(null);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}

	public void update() {
		x += dx;
		y += dy;
	}

	public void tiro() {

		this.tiros.add(new Tiro(x + largura, y + (altura / 4)));
	}

	public void keypressed(KeyEvent event) {

		int evento = event.getKeyCode();

		// System.out.println("Jogador.keypressed() -> " + event.getExtendedKeyCode());

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

		if (evento == KeyEvent.VK_SPACE) {

			tiro();
		}

		if (evento == KeyEvent.VK_F3) {

			//new Container();
			
		}

		if (evento == KeyEvent.VK_F4) {

			Container frame = new Container();
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

		}

	}

	public void keyRelease(KeyEvent event) {

		int evento = event.getKeyCode();

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

	public List<Tiro> getTiros() {
		return tiros;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

}
