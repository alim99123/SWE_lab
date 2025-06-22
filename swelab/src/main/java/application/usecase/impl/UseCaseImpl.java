package application.usecase.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import application.domain.port.Domain;
import application.statemachine.port.StateMachine;

public class UseCaseImpl {

	public UseCaseImpl(StateMachine stateMachine, Domain domain) {
		// TODO Auto-generated constructor stub
	}

	public void sysop(String str) {
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		logger.log(Level.INFO, str);
	}
}
