package br.com.space.modelo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Tiro {

	private int x, y;
	private Image img;
	private int largura, altura;
	private boolean isVisivel;

	private static final int LARGURA = 939;
	private static final int VELOCIDADE = 2;

	public Tiro(int x, int y) {

		this.x = x;
		this.y = y;
		this.isVisivel = true;
	}

	public void load() {

		ImageIcon imagem = new ImageIcon("res\\tiro1.png");
		img = imagem.getImage();

		this.altura = img.getHeight(null);
		this.largura = img.getWidth(null);
	}

	public void update() {

		this.x += VELOCIDADE;
		if (this.x > LARGURA) {
			isVisivel = false;
		}
	}

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public static int getVelocidade() {
		return VELOCIDADE;
	}

	public Image getImg() {
		return img;
	}

}
