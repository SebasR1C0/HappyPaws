package upc.edu.pe.happypaws.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.happypaws.entities.Albergue;
import upc.edu.pe.happypaws.repositories.IAlbergueRepository;
import upc.edu.pe.happypaws.serviceinterfaces.IAlbergueService;

import java.util.List;

@Service
public class AlbergueServiceImplement implements IAlbergueService {
    @Autowired
    private IAlbergueRepository albergueRepository;


    @Override
    public List<Albergue> list() {
        return albergueRepository.findAll();
    }

    @Override
    public void insert(Albergue albergue) {
        albergueRepository.save(albergue);
    }

    @Override
    public void update(Albergue albergue) {
        albergueRepository.save(albergue);
    }

    @Override
    public void delete(int albergueId) {
        albergueRepository.deleteById(albergueId);
    }

    @Override
    public List<Albergue> findalbergue(String albergueName) {
        return albergueRepository.findname(albergueName);
    }

    @Override
    public List<Albergue> AbiertoAhora() {
        return albergueRepository.AbiertoAhora();
    }

    @Override
    public List<String[]> albergueporcantidad() {
        return albergueRepository.albergueporcantidad();
    }
}
