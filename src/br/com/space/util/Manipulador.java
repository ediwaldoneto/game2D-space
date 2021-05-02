package br.com.space.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Manipulador {

	private static final String PATH = "C:\\Space\\";
	private static final String NAME_PROP = "dados.properties";

	private Manipulador() {

	}

	private static  Properties getPro() throws FileNotFoundException {
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(

				PATH + NAME_PROP);
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
		
		int result =  Integer.valueOf(properties.getProperty(valor));
		
		return result;

	}

}