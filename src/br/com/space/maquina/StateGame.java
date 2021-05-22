package br.com.space.maquina;

/**
 * @author Neto
 *
 */
public class StateGame {

	@SuppressWarnings("unused")
	private static int vida;
	private static int pontos;
	private static boolean emJogo;
	private static StateGame instance;

	private StateGame() {
	}

	public static StateGame getInstance() {
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
