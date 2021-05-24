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

/**
 * @author Neto
 *
 */
public class Manipulador {

	private static String PROPERTIES = "dados.properties";
	private static String PATH_INTERNO = "./src/dados/dados.properties";
	private static String PATH_EXTERNO = System.getProperty("user.home") + File.separator + PROPERTIES;

	private Manipulador() {

	}

	private static Properties getPro() throws FileNotFoundException {

		try {
			criaConfigDefault();
		} catch (IOException ex) {

			ex.printStackTrace();
		}

		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(

				PATH_EXTERNO);
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return properties;
	}

	public static int getValor(String valor) {

		Properties properties = null;
		try {
			properties = getPro();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		int result = Integer.valueOf(properties.getProperty(valor));

		return result;

	}

	private static void criaConfigDefault() throws IOException {
		File file = new File(PATH_EXTERNO);

		if (!file.exists()) {
			System.out.println("Manipulador.criaConfigDefault() -> Criando configuração inicial");

			InputStream in = new FileInputStream(PATH_INTERNO);

			System.out.println("Manipulador.criaConfigDefault() :: Carregou path interno -> " + in);

			System.out.println("Manipulador.criaConfigDefault() :: Carregou path do sistema -> " + PATH_EXTERNO);

			Files.copy(in, Paths.get(PATH_EXTERNO), StandardCopyOption.REPLACE_EXISTING);

			System.out.println("Manipulador.criaConfigDefault() -> Fim configuração inicial");
		}

	}

}