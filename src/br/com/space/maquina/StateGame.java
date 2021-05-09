package br.com.space.maquina;

/**
 * @author Neto
 *
 */
public class StateGame {

	private static int vida;
	private static int pontos;
	private static boolean emJogo;
	private static StateGame instance;

	private StateGame() {
	}

	public static StateGame getIntance() {
		if (instance == null) {
			instance = new StateGame();
		}
		return instance;
	}

	public static void inicializaJogo() {
		vida = 1;
		pontos = 0;
		emJogo = true;
	}

	public static void fimDeJogo() {
		emJogo = false;
	}

	public static boolean isEmJogo() {
		return emJogo;
	}

	public static String obtemVida() {
		String aux = String.valueOf(vida);
		return aux;
	}

}
