package application.gui;

import java.util.TooManyListenersException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import application.statemachine.StateMachineFactory;
import application.statemachine.port.Observer;
import application.statemachine.port.State;
import application.statemachine.port.Subject;
import application.usecase.UseCaseFactory;
import application.usecase.port.UseCase;


public class MainFrame extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;

	private transient UseCase usecase = UseCaseFactory.FACTORY.usecase();
	private transient Subject subject = StateMachineFactory.FACTORY.subject();
	private transient Controller controller;

	private static final int WIDTH = 600;
	private static final int HEIGHT = 500;

	private JButton btn = new JButton("Hello SWE");
	private JPanel panel = new JPanel();

	public MainFrame() throws TooManyListenersException {
		super("Application");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.subject.attach(this);
		this.controller = new Controller(this, subject, usecase);

		/* build view */
		this.btn.addActionListener(this.controller);
		this.panel.add(this.btn);
		this.getContentPane().add(this.panel);
	}

	public void update(State newState) {
		/* modify view if necessary */}

}
