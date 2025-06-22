package application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import application.domain.DomainFactory;
import application.domain.port.Domain;
import application.statemachine.StateMachineFactory;
import application.statemachine.port.Observer;
import application.statemachine.port.State;
import application.statemachine.port.StateMachine;
import application.statemachine.port.Subject;
import application.statemachine.port.State.S;
import application.usecase.UseCaseFactory;
import application.usecase.port.UseCase;

class InitTest implements Observer {

	State s;

	@Test
	void test() {

		StateMachine stateMachine = StateMachineFactory.FACTORY.stateMachine();
		Assertions.assertNotNull(stateMachine);
		Subject subject = StateMachineFactory.FACTORY.subject();
		Assertions.assertEquals(stateMachine, subject);
		subject.attach(this);

		Assertions.assertTrue(stateMachine.getState().isSubStateOf(S.CREATE_TEMPLATE));
		Assertions.assertEquals(S.CREATE_TEMPLATE, this.s);
		subject.detach(this);

		Domain domain = DomainFactory.FACTORY.domain();
		Assertions.assertNotNull(domain);

		UseCase usecase = UseCaseFactory.FACTORY.usecase();
		Assertions.assertNotNull(usecase);

		usecase.sysop("test");
		Assertions.assertTrue(true);

	}

	@Override
	public void update(State currentState) {
		this.s = currentState;
	}

}
