package jifmo;

import jifmo.common.Discipline;
import jifmo.core.ItmoConnector;
import jifmo.rating.CommonStatistics;
import jifmo.rating.SubjectStatistics;

import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		ItmoConnector itmoConnector = new ItmoConnector();
		itmoConnector.login("161400", "qid187");
		List<Discipline> examDisciplines = itmoConnector.getExamDisciplinesByPeriod("2011/2012");
		for (Discipline subject : examDisciplines) {
			System.out.println(subject.getSubjectName());
		}
	}

}
