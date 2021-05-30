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

import br.com.space.util.log.Log;

/**
 * @author Neto
 *
 */
public class Manipulador {

	private static String PROPERTIES = "dados.properties";
	private static String PATH_INTERNO = "res\\dados\\dados.properties";
	private static String PATH_EXTERNO = System.getProperty("user.home") + File.separator + PROPERTIES;

	private Manipulador() {

	}

	private static Properties getPro() throws FileNotFoundException {

		criarConfigDefault();

		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(

				PATH_EXTERNO);
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			Log.writeLog("Manipulador.criarConfigDefault.getPro() " + e);
			e.printStackTrace();
		}
		return properties;
	}

	public static int getValor(String valor) {

		Properties properties = null;
		try {
			properties = getPro();
		} catch (FileNotFoundException e) {
			Log.writeLog("Manipulador.criarConfigDefault.getValor() " + e);
			e.printStackTrace();
		}

		int result = Integer.valueOf(properties.getProperty(valor));

		return result;

	}

	private static void criarConfigDefault() {
		File file = new File(PATH_EXTERNO);

		if (!file.exists()) {
			Log.writeLog("Manipulador.criaConfigDefault() -> Criando configuração");

			InputStream in = null;
			try {
				in = new FileInputStream(PATH_INTERNO);
			} catch (FileNotFoundException e) {
				Log.writeLog("Manipulador.criaConfigDefault() -> " + e);
				e.printStackTrace();
			}

			Log.writeLog("Manipulador.criaConfigDefault() :: Montou path interno -> " + in);

			Log.writeLog("Manipulador.criaConfigDefault() :: Montou path do sistema -> " + file);

			try {
				Files.copy(in, Paths.get(PATH_EXTERNO), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				Log.writeLog("Manipulador.criaConfigDefault() -> " + e);
				e.printStackTrace();
			}

			Log.writeLog("Manipulador.criaConfigDefault() -> Fim configuração inicial dados.properties");
		}

	}

	
}    