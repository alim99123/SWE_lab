package application.usecase;

import application.usecase.port.UseCase;

public interface UseCaseFactory {
	
	UseCaseFactory FACTORY = new UseCaseFacade();
	UseCase usecase();

}
