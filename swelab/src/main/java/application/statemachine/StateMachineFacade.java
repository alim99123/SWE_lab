package application.statemachine;

import application.statemachine.impl.StateMachineImpl;
import application.statemachine.port.Observer;
import application.statemachine.port.State;
import application.statemachine.port.StateMachine;
import application.statemachine.port.Subject;

public class StateMachineFacade implements StateMachineFactory, StateMachine, Subject{
	
	private StateMachineImpl stateMachine;

	
	@Override
	public synchronized StateMachine stateMachine() {
		if (this.stateMachine == null)
			this.stateMachine = new StateMachineImpl();
		return this;
	}

	@Override
	public synchronized Subject subject() {
		if (this.stateMachine == null)
			this.stateMachine = new StateMachineImpl();
		return this;
	}
	
	
	
	@Override
	public synchronized void attach(Observer obs) {
		this.stateMachine.attach(obs);
		
	}

	@Override
	public synchronized void detach(Observer obs) {
		this.stateMachine.detach(obs);
	}

	@Override
	public synchronized State getState() {
		return this.stateMachine.getState();
	}

	@Override
	public synchronized boolean setState(State state) {
		return this.stateMachine.setState(state);
	}



	

	
	
	

}
