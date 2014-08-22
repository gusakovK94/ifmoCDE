package jifmo.disciplines;

import java.util.ArrayList;
import java.util.List;

public class MathDisciplines extends AbstractDiscipline {
	public static List<String> mathDisciplines = new ArrayList<>();

	static {
		mathDisciplines.add("Теория принятия решений");
		mathDisciplines.add("Методы оптимизации");
		mathDisciplines.add("Математика");
		mathDisciplines.add("Дискретная математика");
		mathDisciplines.add("Прикладная математика");
		mathDisciplines.add("Вычислительная математика");
		mathDisciplines.add("Теория вероятностей и математическая статистика");
	}

	public static boolean checkMathDisciplines(String subjectName) {
		return checkDiscipline(mathDisciplines, subjectName);
	}
}
