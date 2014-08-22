package jifmo.rating;

import jifmo.common.Discipline;
import jifmo.core.ItmoConnector;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class CommonStatistics {

	protected ItmoConnector itmoConnector;

	public CommonStatistics(ItmoConnector itmoConnector) {
		this.itmoConnector = itmoConnector;
	}

	public double getSummaryMarkByAllDisciplinesByAllPeriods() throws MalformedURLException {
		List<String> periods = itmoConnector.getPeriods();
		double summaryMark = 0.0;
		for (String period : periods) {
			summaryMark += getSummaryMarkBySubjectsInPeriod(period);
		}
		return summaryMark;
	}

	public double getSummaryMarkBySubjectsInPeriod(String period) throws MalformedURLException {
		List<Discipline> disciplinesByPeriod = itmoConnector.getDisciplinesByPeriod(period);
		double summaryMark = 0.0;
		for (Discipline discipline : disciplinesByPeriod) {
			summaryMark += discipline.getCurrentMark();
		}
		return summaryMark;
	}

	public int getCountOfDisciplinesByAllPeriods() throws MalformedURLException {
		List<String> periods = itmoConnector.getPeriods();
		int countOfDisciplines = 0;
		for (String period : periods) {
			countOfDisciplines += getCountOfDisciplinesByPeriod(period);
		}
		return countOfDisciplines;
	}

	public int getCountOfDisciplinesByPeriod(String period) throws MalformedURLException {
		List<Discipline> disciplines = new ArrayList<>();
		for (Discipline subject : itmoConnector.getDisciplinesByPeriod(period)) {
			if (subject.getCurrentMark() != 0.0) {
				disciplines.add(subject);
			}
		}
		return disciplines.size();
	}

	/*public double getAverageMarkByExamSubjectsInPeriod(String period) throws MalformedURLException{
		List<Discipline> examDisciplines = itmoConnector.getExamDisciplinesByPeriod(period);
		double summaryMark = 0.0;
		for (Discipline subject : examDisciplines) {
			summaryMark += subject.getExamMark();
		}
	}*/

}
