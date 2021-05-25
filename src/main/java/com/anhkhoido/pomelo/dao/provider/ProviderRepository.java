package com.anhkhoido.pomelo.dao.provider;

import com.anhkhoido.pomelo.embeddedId.PersonCompositePrimaryKey;
import com.anhkhoido.pomelo.model.Provider;
import org.springframework.data.repository.CrudRepository;

public interface ProviderRepository extends CrudRepository<Provider, PersonCompositePrimaryKey> {

}
