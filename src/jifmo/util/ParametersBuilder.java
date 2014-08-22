package jifmo.util;

public class ParametersBuilder {

	public static String buildLoginParameters(String login, String password) {
		return Constants.RULE+Constants.RuleValue+"&"+Constants.LOGIN+login+"&"+Constants.PASSWORD+password;
	}

	public static String buildPeriodParameters(String period) {
		return Constants.RULE+"eRegister"+"&"+"UNIVER=1"+"&"+"APPRENTICESHIP="+period;
	}
}
