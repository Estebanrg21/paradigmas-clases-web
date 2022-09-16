package una.ac.cr.webservice.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import una.ac.cr.webservice.entity.Log;
import una.ac.cr.webservice.repository.LogRepository;

import java.util.Date;

@Aspect
@Component
public class PersonaAOP{

    @Autowired
    LogRepository logRepository;

    @Before("execution(* una.ac.cr.webservice.repository.PersonaRepository.findById(..))")
    public void logFindById (JoinPoint joinPoint){
        //System.out.println("PersonaAOP.logB4V1():\n TARGET: "+ joinPoint.getSignature().getClass());
        createLogEntry(joinPoint.getSignature().getName());
    }

    @Before("execution(* una.ac.cr.webservice.repository.PersonaRepository.findAll(..))")
    public void logFindAll (JoinPoint joinPoint){
        createLogEntry(joinPoint.getSignature().getName());
    }

    @Before("execution(* una.ac.cr.webservice.repository.PersonaRepository.save(..))")
    public void logSave (JoinPoint joinPoint){
        createLogEntry(joinPoint.getSignature().getName());
    }

    @Before("execution(* una.ac.cr.webservice.repository.PersonaRepository.delete(..))")
    public void logDelete (JoinPoint joinPoint){
        createLogEntry(joinPoint.getSignature().getName());
    }

    private void createLogEntry(String method ) {
        Log log = new Log();
        log.setFecha(new Date());
        log.setMetodo(method);
        logRepository.save(log);
    }

}
