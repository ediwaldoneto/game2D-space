package br.com.space.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Manipulador {

	private static final String PATH = "C:\\Space\\";
	private static final String NAME_PROP = "dados.properties";

	private Manipulador() {

	}

	private static Properties getPro() throws FileNotFoundException {

		criaConfigDefault();

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

		int result = Integer.valueOf(properties.getProperty(valor));

		return result;

	}

	private static void criaConfigDefault() {

		File file = new File(PATH);

		if (!file.exists()) {
			file.mkdir();

			System.out.println("Manipulador.criaConfigDefault() :: As configurações do jogo não existem");
			System.out.println("Manipulador.criaConfigDefault() :: Criando o Path = " + PATH);

			String path = PATH + NAME_PROP;
			BufferedWriter bw = null;
			FileWriter fw = null;

			System.out.println("Manipulador.criaConfigDefault() :: Criando o arquivo = " + NAME_PROP);

			try {

				fw = new FileWriter(path, true);
				bw = new BufferedWriter(fw);

				bw.write("######### DADOS SPACE #########");
				bw.write("\n");
				bw.write("VELOCIDADE_INIMIGO = 6");
				bw.write("\n");
				bw.write("QUANTIDADE_INIMIGO = 300");
				bw.write("\n");
				bw.write("QTD_NEBULA = 20");
				bw.write("\n");
				bw.write("VELOCIDADE_NEBULA = 3");
				bw.write("\n");
				bw.write("VELOCIDADE_TIRO = 4");

				System.out.println("Manipulador.criaConfigDefault() :: Arquivo default foi criado com sucesso");

			} catch (Exception e) {

				e.printStackTrace();
			}

			finally {
				try {
					if (bw != null) {
						bw.close();
					}
					if (fw != null) {
						fw.close();
					}
				} catch (Exception e2) {

					e2.printStackTrace();
				}
			}

		}
	}
}