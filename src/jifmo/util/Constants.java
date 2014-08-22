package jifmo.util;

import java.net.MalformedURLException;
import java.net.URL;

public final class Constants {

	/* urls */
	public static final String loginURL = "http://de.ifmo.ru/servlet";
	public static final String journalPage = "https://de.ifmo.ru/servlet/distributedCDE?Rule=eRegister";
	public static final String profilePage = "https://de.ifmo.ru/servlet/distributedCDE?Rule=editPersonProfile";

	public static URL initLoginURL() throws MalformedURLException {
		return new URL(loginURL);
	}

	public static URL initJournalURL() throws MalformedURLException {
		return new URL(journalPage);
	}

	public static URL initProfileURL() throws MalformedURLException {
		return new URL(profilePage);
	}


	/* Request Values */
	public static final String RULE = "Rule=";
	public static final String RuleValue = "LOGON";
	public static final String LOGIN = "LOGIN=";
	public static final String PASSWORD = "PASSWD=";

	/* Selectors */
	public static final String APPRENTICESHIP = "select[name=APPRENTICESHIP] > option";
	public static final String DISCIPLINE = "table.d_table > tbody :has(td.td_vmenu_left)";
	public static final String PERSON = "div.d_text";

}
