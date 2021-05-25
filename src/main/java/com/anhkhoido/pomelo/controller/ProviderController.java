package com.anhkhoido.pomelo.controller;

import com.anhkhoido.pomelo.dao.provider.ProviderRepository;
import com.anhkhoido.pomelo.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/medicalBooking/providers")
public class ProviderController extends AbstractController {

    private ProviderRepository providerRepository;

    @Autowired
    public ProviderController(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Provider provider) {
        providerRepository.save(provider);
    }

    @Override
    public Iterable<Provider> findAll() {
        return providerRepository.findAll();
    }

    @Override
    public void deleteAll() {
        providerRepository.deleteAll();
    }

}
