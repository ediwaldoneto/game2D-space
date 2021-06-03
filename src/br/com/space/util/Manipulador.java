package br.com.space.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import br.com.space.maquina.Constants;
import br.com.space.util.log.Log;

/**
 * @author Neto
 *
 */
public class Manipulador {

	private Manipulador() {

	}

	private static Properties getPro() throws FileNotFoundException {

		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(

				Constants.PATH_OS + File.separator + Constants.PASTA_SYSTEMA + File.separator
						+ Constants.AQUIVO_PROPERTIES);
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			Log.writeLog("Manipulador.criarConfigDefault.getPro() " + e);

		}
		return properties;
	}

	public static int getValor(String valor) {

		Properties properties = null;
		try {
			properties = getPro();
		} catch (FileNotFoundException e) {
			Log.writeLog("Manipulador.criarConfigDefault.getValor() " + e);

		}

		int result = Integer.valueOf(properties.getProperty(valor));

		return result;

	}

	public static void criarConfigDefault() {
		String caminho = Constants.PATH_OS + File.separator + Constants.PASTA_SYSTEMA;
		File file = new File(caminho);

		if (!file.exists()) {
			file.mkdir();
			Log.writeLog("Manipulador.criaConfigDefault() -> Criando configuração");

			InputStream in = Manipulador.class.getResourceAsStream(Constants.PATH_INTERNO);

			Log.writeLog("Manipulador.criaConfigDefault() :: Montou path interno -> " + in);

			Log.writeLog("Manipulador.criaConfigDefault() :: Montou path do sistema -> " + file);

			try {
				Files.copy(in, Paths.get(Constants.PATH_OS + File.separator + Constants.PASTA_SYSTEMA + File.separator
						+ Constants.AQUIVO_PROPERTIES), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				Log.writeLog("Manipulador.criaConfigDefault() -> " + e.getMessage());

			}

			Log.writeLog("Manipulador.criaConfigDefault() -> Fim configuração inicial dados.properties");
		}

	}

}