package upc.edu.pe.happypaws.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.happypaws.entities.Rol;
import upc.edu.pe.happypaws.repositories.IRolRepository;
import upc.edu.pe.happypaws.serviceinterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService {
    @Autowired
    private IRolRepository rolRepository;

    @Override
    public List<Rol> list() {
        return rolRepository.findAll();
    }

    @Override
    public void insert(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void update(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void delete(int rolId) {
        rolRepository.deleteById(rolId);
    }

    @Override
    public List<String[]> countrol() {
        return rolRepository.countrol();
    }
}
