package core.ics.repository;

import core.ics.model.Client;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientRepository implements PanacheRepositoryBase<Client, Long> {
}
