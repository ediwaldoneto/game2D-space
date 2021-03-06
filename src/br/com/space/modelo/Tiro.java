package br.com.space.modelo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import br.com.space.util.Manipulador;
import br.com.space.util.som.Audio;

public class Tiro {

	private int x, y;
	private Image img;
	private int largura, altura;
	private boolean isVisivel;

	private static final int LARGURA = 939;
	private static int VELOCIDADE = Manipulador.getValor("VELOCIDADE_TIRO");
	private static String PATH_AUDIO = "res\\som\\weaponfire.wav";

	public Tiro(int x, int y) {

		this.x = x;
		this.y = y;
		this.isVisivel = true;
		//Audio.play(PATH_AUDIO, false, 0.8f);

	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}

	public void load() {

		ImageIcon imagem = new ImageIcon(Tiro.class.getResource("/dados/image/tiro1.png"));
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

	public int getLargura() {
		return largura;
	}

	public int getAltura() {
		return altura;
	}

}
