package HTML_URL2;


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jpgsPNGS {
     public static void main(String[] args) throws IOException {
            Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
            log(doc.title());

            Elements newsHeadlines = doc.select("#mp-itn b a");
            Elements pngs = doc.select("img[src$=.png]");
            Elements jpgs = doc.select("img[src$=.jpg]");
          
            //FORMA 1
            System.out.println("FORMA 1");
            int contarjpg =0;
            int contarpng =0;

            for (Element headline : newsHeadlines) {
                log("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
            }
            for (Element jpgss : jpgs) {
                contarjpg++;

            }
            System.out.println("Hay "+contarjpg+" jpgs");
            for (Element pngss : pngs) {
                contarpng++;

            }
            System.out.println("Hay "+contarpng+" pngs");
            
            System.out.println("");
            System.out.println("");
            //FORMA 2
            System.out.println("FORMA 2");
            System.out.println("PNG: " + pngs.size());
            System.out.println("JPG: " + jpgs.size());
        }
     //contar png y jpg

        private static void log(String msg, String... vals) {
            System.out.println(String.format(msg, vals));
        }
    }
