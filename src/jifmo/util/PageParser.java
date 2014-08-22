package jifmo.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class PageParser {

	public static List<String> parse(String page, String selector) {
		Elements elements = getElementsBySelector(page, selector);
		return getOutputListFromParse(elements);
	}

	public static Elements getElementsBySelector(String page, String selector) {
		Document resultPage = Jsoup.parse(page);
		Elements elements = resultPage.select(selector);
		return elements;
	}

	public static List<String> getOutputListFromParse(Elements elements) {
		List<String> elementsList = new ArrayList<>();
		for (Element element : elements) {
			elementsList.add(element.text());
		}
		return elementsList;
	}

}
