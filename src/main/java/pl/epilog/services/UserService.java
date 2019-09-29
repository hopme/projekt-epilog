package pl.epilog.services;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.epilog.dto.FactorDTO;
import pl.epilog.model.Factor;
import pl.epilog.repositories.FactorRepository;
import pl.epilog.repositories.UserRepository;

import java.time.LocalDateTime;


@Service
@Transactional
public class UserService {

    private FactorRepository factorRepository;
    private UserRepository userRepository;

    public UserService(FactorRepository factorRepository, UserRepository userRepository) {
        this.factorRepository = factorRepository;
        this.userRepository = userRepository;
    }

    public void addFactor(FactorDTO factorData) {
        Factor factor = new Factor();
        factor.setName(factorData.getName());
        factor.setCategory(factorData.getCategory());
        factor.setCreated(LocalDateTime.now());
        factorRepository.save(factor);
    }
}