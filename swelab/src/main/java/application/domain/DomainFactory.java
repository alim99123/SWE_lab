package application.domain;

import application.domain.port.Domain;

public interface DomainFactory {

	DomainFactory FACTORY = new DomainFacade();
	
	Domain domain();
}
