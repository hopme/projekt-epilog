package pl.epilog.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.epilog.model.Factor;
import pl.epilog.repositories.FactorRepository;

public class FactorConverter implements Converter<String, Factor> {

    private FactorRepository factorRepository;

    @Override
    public Factor convert(String id) {
        return factorRepository.findById(Long.parseLong(id));
    }

    @Autowired
    public void setFactorRepository(FactorRepository factorRepository) {
        this.factorRepository = factorRepository;
    }



}