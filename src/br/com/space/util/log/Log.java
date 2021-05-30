package br.com.space.util.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Neto
 *
 */
public final class Log {

	private static String PATH_EXTERNO = "C:\\log\\";

	private Log() {
	}

	public static void writeLog(String msg) {

		String dataHora = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
				.format(Calendar.getInstance().getTime());

		File file = new File(PATH_EXTERNO);
		if (!file.exists()) {
			file.mkdir();
		}
		String path = PATH_EXTERNO + "log.txt";
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			fw = new FileWriter(path, true);
			bw = new BufferedWriter(fw);

			bw.write("INFO " + "[" + dataHora + "] " + msg);
			bw.write("\n");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
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