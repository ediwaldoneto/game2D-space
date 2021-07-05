package br.com.space.maquina;

import br.com.space.util.log.Log;

/**
 * @author Neto
 *
 */
public class StateGame {

	private static int vida;
	private static int pontos;
	private static boolean emJogo;

	private StateGame() {
	}

	public static void inicializaJogo() {
		vida = 1;
		pontos = 0;
		emJogo = true;
		Log.writeLog(
				"StateGame :: inicializaJogo :: -> " + " vida = " + vida 
				+ " pontos = " + pontos + " emJogo = " + emJogo);
	}

	public static void fimDeJogo() {
		StateGame.emJogo = false;

	}

	public static boolean isEmJogo() {

		return emJogo;

	}

	public static String obtemPontos() {
		int pt = 0;
		pt += getPontos();
		return String.valueOf(pt);
	}

	public static void incluiPonto() {
		StateGame.pontos += 1;
	}

	protected static int getPontos() {
		return pontos;
	}

	public static void statusTrue() {
		StateGame.emJogo = true;
	}
}
