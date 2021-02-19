package HTML_URL2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class EjemploUrl {


	public static void main(String[] args) {

		String strUrl; 
		URL url;	

		strUrl = "http://www.rcag.org.uk/index.php/item/1003-archbishop-philip-rip";	
		try {
			url = new URL(strUrl);
		} catch (MalformedURLException e) {
			System.err.println("Error " + e.getLocalizedMessage());
			return;
		}

		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(url.openStream()));
		}
		catch (IOException ioe) {
			System.err.println("Error lectura: " + ioe.getLocalizedMessage());
			return;
		}

		int contador=0;
		String inputLine;
		//String patron="<img ";
		try {
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
				//SI EL HTML ESTA EN LA MISMA LINEA. HAY QUE BUSCAR DONDE ACABA con INDEXOF
				if(inputLine.contains("<img")) {
					contador++;
				}
			}
			in.close();
			System.out.println("EL CONTADOR SE REPITE " + contador);
		}
		catch(IOException ioe) {
			System.err.println("Error leyendo el contenido de la URL.");
		}

	} 
} 