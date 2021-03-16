package br.com.space.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import br.com.space.modelo.Jogador;

public class TecladoAdapter extends KeyAdapter {

	private Jogador jogador;

	public TecladoAdapter(Jogador jogador) {
		this.jogador = jogador;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		jogador.keypressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		jogador.keyRelease(e);
	}

}
