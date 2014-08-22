package jifmo.common;

public class Discipline {

	private String subjectName;
	private double currentMark;
	private String examMark;
	private String testMark;

	public void setSubjectName(String subjectName) {
		if (subjectName.isEmpty())
			return;
		this.subjectName = subjectName;
	}

	public void setCurrentMark(String currentMark) {
		if (currentMark.isEmpty())
			return;
		String mark = currentMark;
		if (currentMark.contains(",")) {
			mark = currentMark.replace(',', '.');
		}
		this.currentMark = Double.parseDouble(mark);
	}

	public void setExamMark(String examMark) {
		if (examMark.isEmpty())
			return;
		this.examMark = examMark;
	}

	public void setTestMark(String testMark) {
		if (testMark.isEmpty())
			return;
		this.testMark = testMark;
	}

	public double getCurrentMark() {
		return this.currentMark;
	}

	public String getExamMark() {
		return this.examMark;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public String getTestMark() {
		return this.testMark;
	}

}
