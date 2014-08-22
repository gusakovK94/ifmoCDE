package jifmo.disciplines;

import java.util.List;

public class AbstractDiscipline {

	public static boolean checkDiscipline(List<String> disciplines, String subjectName) {
		int index = subjectName.indexOf('(');
		String shortSubjectName = subjectName.substring(0, index - 1);
		for (String discipline : disciplines) {
			if (discipline.equals(shortSubjectName))
				return true;
		}
		return false;
	}

}
