package application.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CompletableFuture;

import javax.swing.JButton;

import application.statemachine.port.Observer;
import application.statemachine.port.State;
import application.statemachine.port.Subject;
import application.usecase.port.UseCase;

public class Controller implements ActionListener, Observer {

	@SuppressWarnings("unused")
	private MainFrame myView;
	private UseCase myModel;
	private Subject subject;

	public Controller(MainFrame view, Subject subject, UseCase model) {
		this.myView = view;
		this.myModel = model;
		this.subject = subject;
		this.subject.attach(this);
	}

	public synchronized void actionPerformed(ActionEvent e) {

		/* read input */
		String str = (((JButton) e.getSource()).getText());

		CompletableFuture.runAsync(() -> this.myModel.sysop(str));
	}

	public void update(State newState) {
		/* modify controller or view if necessary */
	}

}
