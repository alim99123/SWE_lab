package application.statemachine;

import application.statemachine.port.StateMachine;
import application.statemachine.port.Subject;

public interface StateMachineFactory {
	
	StateMachineFactory FACTORY = new StateMachineFacade();
	
	StateMachine stateMachine();

	Subject subject();


}
