package br.com.space;

import br.com.space.util.Manipulador;
import br.com.space.util.log.Log;

public class Start {

	private static String JAVA_VERSION = System.getProperty("java.version");
	private static String OS_NAME = System.getProperty("os.name");
	private static String OS_ARCH = System.getProperty("os.arch");

	public static void main(String[] args) {

		long t = System.currentTimeMillis();

		Manipulador.criarConfigDefault();

		Log.writeLog("Start :: Container");
		Log.writeLog("###############################");
		Log.writeLog("# Java " + JAVA_VERSION);
		Log.writeLog("# System " + OS_NAME + " " + OS_ARCH);
		Log.writeLog("###############################");

		new Container();

		Log.writeLog("Tempo -> " + (System.currentTimeMillis() - t) / 1000d);
	}

}
