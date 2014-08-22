package jifmo.rating;

import jifmo.core.ItmoConnector;

import java.io.IOException;
import java.net.MalformedURLException;

public class PercentRating extends SubjectStatistics {

	public PercentRating(ItmoConnector itmoConnector) throws MalformedURLException, IOException {
		super(itmoConnector);
	}

	/*public double getPercentRatingByMathDisciplines() {
		return round(100*getSummaryMarkByMathDisciplines()/getSummaryMarkByAllSubjects());
	}

	public double getPercentRatingByMathDisciplinesByPeriod() {
		return round(100*getSummaryMarkByMathDisciplinesByPeriod()/getSummaryMarkBySubjectsInPeriod());
	}

	public double getPercentRatingByHumanitarianDisciplines() {
		return round(100*getSummaryMarkByHumanitariesDisciplines()/getSummaryMarkByAllSubjects());
	}

	public double getPercentRatingByProgrammingDisciplines() {
		return round(100*getSummaryMarkByProgrammingDisciplines()/getSummaryMarkByAllSubjects());
	}

	public double getPercentRatingByGraphicDisciplines() {
		return round(100*getSummaryMarkByGraphicDisciplines()/getSummaryMarkByAllSubjects());
	}

	public double getPercentRatingByInformaticDisciplines() {
		return round(100*getSummaryMarkByInformaticDisciplines()/getSummaryMarkByAllSubjects());
	}

	public double getPercentRatingByPhysicsDisciplines() {
		return round(100*getSummaryMarkByPhysicsDisciplines()/getSummaryMarkByAllSubjects());
	}

	public double getPercentRatingBySpecDisciplines() {
		return round(100*getSummaryMarkBySpecDisciplines()/getSummaryMarkByAllSubjects());
	}

	public double getPercentRatingBySportDisciplines() {
		return round(100*getSummaryMarkBySportDisciplines()/getSummaryMarkByAllSubjects());
	}

	private double round(double value) {
		return ((int) (value*100 + 0.5))/100.0;
	}*/

}
