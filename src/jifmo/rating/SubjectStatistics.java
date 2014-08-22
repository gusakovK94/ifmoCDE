package jifmo.rating;

import jifmo.common.Discipline;
import jifmo.core.ItmoConnector;
import jifmo.disciplines.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class SubjectStatistics extends CommonStatistics {

	public SubjectStatistics(ItmoConnector itmoConnector) throws MalformedURLException {
		super(itmoConnector);
	}

	public double getSummaryMarkByGraphicDisciplinesInPeriod(String period) throws MalformedURLException {
		return getSummaryMarkBySelectedDisciplinesInPeriod(GraphicDisciplines.graphicDisciplines, period);
	}

	public double getSummaryMarkByHumanitarianDisciplinesInPeriod(String period) throws MalformedURLException {
		return getSummaryMarkBySelectedDisciplinesInPeriod(HumanitarianDisciplines.humanitarianList, period);
	}

	public double getSummaryMarkByInformaticDisciplinesInPeriod(String period) throws MalformedURLException {
		return getSummaryMarkBySelectedDisciplinesInPeriod(InformaticDisciplines.informaticDisciplines, period);
	}

	public double getSummaryMarkByMathDisciplinesInPeriod(String period) throws MalformedURLException {
		return getSummaryMarkBySelectedDisciplinesInPeriod(MathDisciplines.mathDisciplines, period);
	}

	public double getSummaryMarkByPhysicsDisciplinesInPeriod(String period) throws MalformedURLException {
		return getSummaryMarkBySelectedDisciplinesInPeriod(PhysicsDisciplines.physicsDisciplines, period);
	}

	public double getSummaryMarkByProgrammingDisciplinesInPeriod(String period) throws MalformedURLException {
		return getSummaryMarkBySelectedDisciplinesInPeriod(ProgrammingDisciplines.programmingDisciplines, period);
	}

	public double getSummaryMarkBySpecDisciplinesInPeriod(String period) throws MalformedURLException {
		return getSummaryMarkBySelectedDisciplinesInPeriod(SpecDisciplines.specDisciplines, period);
	}

	public double getSummaryMarkBySportDisciplinesInPeriod(String period) throws MalformedURLException {
		return getSummaryMarkBySelectedDisciplinesInPeriod(SportDisciplines.sportDisciplines, period);
	}

	private double getSummaryMarkBySelectedDisciplinesInPeriod(List<String> disciplines, String period)
			throws MalformedURLException {
		List<Discipline> disciplinesByPeriod = itmoConnector.getDisciplinesByPeriod(period);
		double summaryMark = 0.0;
		for (Discipline subject : disciplinesByPeriod) {
			if (AbstractDiscipline.checkDiscipline(disciplines, subject.getSubjectName())) {
				summaryMark += subject.getCurrentMark();
			}
		}
		return summaryMark;
	}

}
