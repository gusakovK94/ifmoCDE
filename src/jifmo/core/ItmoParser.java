package jifmo.core;

import jifmo.common.Discipline;
import jifmo.common.PersonInfo;
import jifmo.util.Constants;
import jifmo.util.PageParser;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.util.ArrayList;
import java.util.List;

public class ItmoParser {

	public static List<String> parsePeriods(String mainJournalPage) {
		return PageParser.parse(mainJournalPage, Constants.APPRENTICESHIP);
	}

	public static List<Discipline> parseDisciplines(String mainJournalPage) {
		Elements disciplines = PageParser.getElementsBySelector(mainJournalPage, Constants.DISCIPLINE);
		List<Discipline> listOfSubjects = new ArrayList<>();
		for (Element discipline : disciplines) {
			Discipline subject = buildDisciplineFromElement(discipline);
			listOfSubjects.add(subject);
		}
		return listOfSubjects;
	}

	public static Discipline buildDisciplineFromElement(Element discipline) {
		Discipline subject = new Discipline();
		List<String> listOfSubjects = PageParser.getOutputListFromParse(discipline.select("td"));
		subject.setSubjectName(listOfSubjects.get(2));
		subject.setCurrentMark(listOfSubjects.get(3));
		subject.setExamMark(listOfSubjects.get(4));
		subject.setTestMark(listOfSubjects.get(5));
		return subject;
	}

	public static List<Discipline> parseExamDisciplines(String mainJournalPage) {
		List<Discipline> disciplines = parseDisciplines(mainJournalPage);
		List<Discipline> examDisciplines = new ArrayList<>();
		for (Discipline subject : disciplines) {
			if (subject.getExamMark() != null) {
				examDisciplines.add(subject);
			}
		}
		return examDisciplines;
	}
	public static PersonInfo parseProfile(String profilePage) {
		Element personInfo = PageParser.getElementsBySelector(profilePage, Constants.PERSON).first();
		PersonInfo person = buildPersonInfoFromElement(personInfo);
		return person;
	}

	public static PersonInfo buildPersonInfoFromElement(Element element) {
		List<String> infoList = PageParser.getOutputListFromParse(element.select("td"));
		PersonInfo person = new PersonInfo();
		person.surname = infoList.get(0);
		person.name = infoList.get(2);
		person.patronymic = infoList.get(3);
		person.gender = infoList.get(4);
		person.dateOfBirth = infoList.get(5);
		person.placeOfBirth = infoList.get(6);
		return person;
	}
}
