package com.anhkhoido.pomelo.dao.provider;

import com.anhkhoido.pomelo.embeddedId.PersonCompositePrimaryKey;
import com.anhkhoido.pomelo.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderRepository {

    private ProviderRepository providerRepository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public Provider save(Provider provider) {
        return providerRepository.save(provider);
    }

    @Override
    public <S extends Provider> Iterable<S> saveAll(Iterable<S> iterable) {
        return providerRepository.saveAll(iterable);
    }

    @Override
    public Optional<Provider> findById(PersonCompositePrimaryKey personCompositePrimaryKey) {
        return providerRepository.findById(personCompositePrimaryKey);
    }

    @Override
    public boolean existsById(PersonCompositePrimaryKey personCompositePrimaryKey) {
        return providerRepository.existsById(personCompositePrimaryKey);
    }

    @Override
    public Iterable<Provider> findAll() {
        return providerRepository.findAll();
    }

    @Override
    public Iterable<Provider> findAllById(Iterable<PersonCompositePrimaryKey> iterable) {
        return providerRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return providerRepository.count();
    }

    @Override
    public void deleteById(PersonCompositePrimaryKey personCompositePrimaryKey) {
        providerRepository.deleteById(personCompositePrimaryKey);
    }

    @Override
    public void delete(Provider provider) {
        providerRepository.delete(provider);
    }

    @Override
    public void deleteAll(Iterable<? extends Provider> iterable) {
        providerRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        providerRepository.deleteAll();
    }
}
