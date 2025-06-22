package application.usecase;

import application.domain.DomainFactory;
import application.statemachine.StateMachineFactory;
import application.statemachine.port.StateMachine;
import application.statemachine.port.State.S;
import application.usecase.impl.UseCaseImpl;
import application.usecase.port.UseCase;

public class UseCaseFacade implements UseCaseFactory, UseCase {

	private UseCaseImpl usecase;
	private StateMachine stateMachine;
	
	@Override
	public UseCase usecase() {
		if (this.usecase == null) {
			this.stateMachine = StateMachineFactory.FACTORY.stateMachine();
			this.usecase = new UseCaseImpl(stateMachine, DomainFactory.FACTORY.domain());
		}
		return this;
	}

	@Override
	public synchronized void sysop(String str) {
		if (this.stateMachine.getState().isSubStateOf( S.CREATE_TEMPLATE /* choose right state*/ ))
			this.usecase.sysop(str);
	}
	
	
	

}
