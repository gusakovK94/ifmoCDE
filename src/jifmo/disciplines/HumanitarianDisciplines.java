package jifmo.disciplines;

import java.util.ArrayList;
import java.util.List;

public class HumanitarianDisciplines extends AbstractDiscipline {
	public static List<String> humanitarianList = new ArrayList<>();

	static {
		humanitarianList.add("Имидж специалиста и корпоративная культура");
		humanitarianList.add("Иностранный язык");
		humanitarianList.add("Культурология");
		humanitarianList.add("Основы эффективных коммуникаций");
		humanitarianList.add("История");
		humanitarianList.add("Организация и управление бизнес-процессами");
		humanitarianList.add("Экономика");
		humanitarianList.add("Правоведение");
		humanitarianList.add("Философия");
		humanitarianList.add("Экология");
	}

	public static boolean checkHumanitarianDiscipline(String subjectName) {
		return checkDiscipline(humanitarianList, subjectName);
	}
}
