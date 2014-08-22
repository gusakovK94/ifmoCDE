package jifmo.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

import jifmo.exceptions.*;

public abstract class Connector {

	public Connector() {
		CookieHandler.setDefault(new CookieManager());
	}

	public void login(String login, String password)
			throws MalformedURLException, NotStudentException, NotValidLoginException {
		String loginParameters = ParametersBuilder.buildLoginParameters(login, password);
		String loginPage = getResponseFromGetOrPostRequest(Constants.initLoginURL(), loginParameters);
		checkLoginPage(loginPage);
		checkStudent(loginPage);
	}

	public String getResponseFromGetOrPostRequest(URL url, String params) {
		try {
			URLConnection urlConnection = url.openConnection();
			writeInConnection(urlConnection, params);
			return getOutputStringFromConnection(urlConnection);
		} catch (IOException e) {
			System.err.println("Some problems with urlConnection");
			e.printStackTrace();
			return null;
		}
	}

	private void writeInConnection(URLConnection urlConnection, String params) {
		urlConnection.setDoOutput(true);
		try (DataOutputStream outputStream = new DataOutputStream(urlConnection.getOutputStream())) {
			outputStream.writeBytes(params);
			outputStream.flush();
		} catch (IOException e) {
			System.err.println("Some problems with urlConnection");
			e.printStackTrace();
		}
	}

	private String getOutputStringFromConnection(URLConnection urlConnection) {
		StringBuilder outputString = new StringBuilder();
		String charset = getCharsetFromConnection(urlConnection);
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(urlConnection.getInputStream(), charset))) {
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				outputString.append(line);
			}
			return outputString.toString();
		} catch (IOException e) {
			System.err.println("Some problems with urlConnection");
			e.printStackTrace();
			return null;
		}
	}

	private String getCharsetFromConnection(URLConnection urlConnection) {
		String charset = urlConnection.getHeaderField("Content-Type");
		charset = charset.substring(charset.lastIndexOf("=") + 1);
		if (charset != null) {
			return charset;
		}
		else {
			return "Windows-1251";
		}
	}


	private void checkLoginPage(String loginPage) throws NotValidLoginException {
		if (loginPage.contains("Доступ запрещен"))
			throw new NotValidLoginException();
	}

	private void checkStudent(String loginPage) throws NotStudentException {
		if (!loginPage.contains("Студент"))
			throw new NotStudentException();
	}


	public String getResponseFromGetOrPostRequest(URL url) {
		try {
			URLConnection urlConnection = url.openConnection();
			return getOutputStringFromConnection(urlConnection);
		} catch (IOException e) {
			System.out.println("Some problems with urlConnection");
			e.printStackTrace();
			return null;
		}
	}

}
