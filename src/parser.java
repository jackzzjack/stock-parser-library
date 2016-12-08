import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class parser {
	
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://mops.twse.com.tw/server-java/t164sb01?step=1&CO_ID=2881&SYEAR=2016&SSEASON=3&REPORT_ID=C").get();
		
		Elements mainTableTr = doc.select("table.main_table.hasBorder").get(0).select("tr");
		
		for (Element element: mainTableTr) {	
			Elements inside = element.select("td");
			
			if (inside.isEmpty() != true)					// Filter td may not exist @ tr
				System.out.println(inside.first().text().replaceAll("　", "").replaceAll(" ", ""));		// Full-space and half-space bar
		}
	}
}
