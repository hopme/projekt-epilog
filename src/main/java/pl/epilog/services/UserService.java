package pl.epilog.services;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.epilog.dto.DayLogDTO;
import pl.epilog.dto.FactorDTO;
import pl.epilog.model.DayLog;
import pl.epilog.model.Factor;
import pl.epilog.model.User;
import pl.epilog.repositories.DayLogRepository;
import pl.epilog.repositories.FactorRepository;
import pl.epilog.repositories.UserRepository;

import javax.validation.Valid;
import java.time.LocalDateTime;


@Service
@Transactional
public class UserService {

    private FactorRepository factorRepository;
    private UserRepository userRepository;
    private DayLogRepository dayLogRepository;

    public UserService(FactorRepository factorRepository, UserRepository userRepository, DayLogRepository dayLogRepository) {
        this.factorRepository = factorRepository;
        this.userRepository = userRepository;
        this.dayLogRepository = dayLogRepository;
    }

    public void addFactor(FactorDTO factorData) {
        Factor factor = new Factor();
        factor.setName(factorData.getName());
        factor.setCategory(factorData.getCategory());
        factor.setCreated(LocalDateTime.now());
        factorRepository.save(factor);
    }

    public void addDayLog(String email, @Valid DayLogDTO daylogData) {
        DayLog dayLog = new DayLog();
        dayLog.setCreated(daylogData.getCreated());
        dayLog.setFactors(daylogData.getFactors());
        User user = userRepository.getByEmail(email);
        dayLog.setUser(user);
        dayLog.setAttack(daylogData.getAttack());
        dayLogRepository.save(dayLog);
    }

}