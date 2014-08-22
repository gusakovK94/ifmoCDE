package jifmo.core;

import jifmo.common.Discipline;
import jifmo.common.PersonInfo;
import jifmo.util.Connector;
import jifmo.util.Constants;
import jifmo.util.ParametersBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class ItmoConnector extends Connector {

	public List<String> getPeriods() throws MalformedURLException {
		String mainJournalPage = getResponseFromGetOrPostRequest(Constants.initJournalURL());
		List<String> periodsList = ItmoParser.parsePeriods(mainJournalPage);
		return periodsList;
	}

	public List<Discipline> getDisciplinesByPeriod(String period) throws MalformedURLException {
		String mainJournalPage = getResponseFromGetOrPostRequest(Constants.initJournalURL(),
				ParametersBuilder.buildPeriodParameters(period));

		List<Discipline> disciplinesList = ItmoParser.parseDisciplines(mainJournalPage);
		return disciplinesList;
	}

	public List<Discipline> getExamDisciplinesByPeriod(String period) throws MalformedURLException {
		String mainJournalPage = getResponseFromGetOrPostRequest(Constants.initJournalURL(),
				ParametersBuilder.buildPeriodParameters(period));
		List<Discipline> examDisciplines = ItmoParser.parseExamDisciplines(mainJournalPage);
		return examDisciplines;
	}


	public PersonInfo getPersonInfo() throws MalformedURLException {
		String profilePage = getResponseFromGetOrPostRequest(Constants.initProfileURL());
		PersonInfo person = ItmoParser.parseProfile(profilePage);
		return person;
	}

}
