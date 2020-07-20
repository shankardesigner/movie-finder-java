package com.sageNepal.MovieFinder.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleSearchUtils {
     public static String getUri(String searchTerms) {
         String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
         String url = "https://www.google.com/search?tbm=isch&sxsrf=ALeKk02FtaORgG96dZYTbbEE1ne51Kjszw%3A1594982071819&source=hp&biw=1366&bih=637&ei=t34RX_P0L5DyrAHnsbbgAg&q=" + searchTerms + "&oq=180&gs_lcp=CgNpbWcQAxgAMgQIIxAnMgQIIxAnMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAA6BwgjEOoCECc6BQgAELEDULkhWJknYJ86aAFwAHgAgAHyBYgBgw2SAQkyLTIuMS42LTGYAQCgAQGqAQtnd3Mtd2l6LWltZ7ABCg&sclient=img";
//         String url = "https://www.google.com/search?q=" + searchTerms + "%20movie%20poster&tbm=isch&tbs=isz%3Am&hl=en&ved=0CAIQpwVqFwoTCLijwvjT2OoCFQAAAAAdAAAAABAC&biw=1354&bih=630";
         try {
             Document var = Jsoup.connect(url).userAgent(userAgent).referrer("https://www.google.com/").get();
             Elements node = var.select("a.wXeWr.islib.nfEiy.mM5pbd");

             Element element = node.select("img").select("[data-src]").get(0);
             element.removeAttr("width").removeAttr("height").removeAttr("data-lt").removeAttr("class").removeAttr("jsname");
             String htmlNode = element.toString().replace("data-src", "src");
             return htmlNode;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return "No image Found";
     }
}
