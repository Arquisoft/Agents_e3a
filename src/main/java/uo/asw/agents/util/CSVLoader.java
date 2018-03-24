package uo.asw.agents.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CSVLoader {
	
	private static final String SEPARATOR = ",";
	private static final String RUTA = "src/main/resources/db/csv/kindCode.csv";
	
	private static Map<String, String> keyCodes;
	
	
	/**
	 * Método para leer de un archivo csv
	 * @return hashMap con la información del csv
	 * @throws IOException
	 */
	private  Map<String, String> getKeyCodesFromCVS() throws IOException  {
		BufferedReader br = null;
		Map<String, String> keyCodes = new HashMap<String, String>();
		
		try {
			br = new BufferedReader(new FileReader(RUTA));
			String line = br.readLine();
			while (line!=null) {
				String[] fields = line.split(SEPARATOR);
				keyCodes.put(fields[1],fields[0]);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("No se ha encontrado el fichero");
		} catch (IOException e) {
			throw new IOException("Error de entrada salida");
		} finally {
			if (br!=null)
				br.close();
		}
		return keyCodes;
	}
	
	public Map<String, String> getKeyCodes() throws IOException {
		keyCodes = getKeyCodesFromCVS();
		return keyCodes;
	}
	
	
	
	
}

