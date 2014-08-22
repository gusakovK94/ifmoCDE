package jifmo.disciplines;

import java.util.ArrayList;
import java.util.List;

public class ProgrammingDisciplines extends AbstractDiscipline {
	public static List<String> programmingDisciplines = new ArrayList<>();
	static {
		programmingDisciplines.add("Основы программирования");
		programmingDisciplines.add("Объектно-ориентированное программирование");
		programmingDisciplines.add("Архитектура информационных систем");
		programmingDisciplines.add("Технологии программирования");
		programmingDisciplines.add("WEB-программирование");
		programmingDisciplines.add("Объектно-ориентированное программирование на СИ++");
	}

	public static boolean checkProgrammingDiscipline(String subjectName) {
		return checkDiscipline(programmingDisciplines, subjectName);
	}
}
