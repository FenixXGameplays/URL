package HTML_URL2;
import java.io.IOException;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class listaEnlaces {

	public static void main(String[] args) throws IOException{
		  Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
          log(doc.title());

	        Elements links = doc.select("a[href]");
	        Elements media = doc.select("[src]");
	        Elements imports = doc.select("link[href]");

	        
	        //FORMA 1
	        System.out.println("FORMA 1");
	        int videos = 0;
	        int enlaces = 0;
	        int importados = 0;
	        
	        for (Element src : media) {
	            videos++;
	        }
	        System.out.println("VIDEOS: " + videos);

	        for (Element link : imports) {
	           importados++;
	        }

	        System.out.println("IMPORTADOS: " + importados);
	        for (Element link : links) {
	            enlaces++;
	        }
	        System.out.println("ENLACES: " + enlaces);
	        
	        //FORMA 2
	        System.out.println("");
	        System.out.println("");
	        System.out.println("FORMA 2");
	        System.out.println("LINKS: " + links.size());
	        System.out.println("MEDIA: " + media.size());
	        System.out.println("IMPORTS: " + imports.size());
	       
	        imports.size();
	        
	    }

	 private static void log(String msg, String... vals) {
         System.out.println(String.format(msg, vals));
     }

}
