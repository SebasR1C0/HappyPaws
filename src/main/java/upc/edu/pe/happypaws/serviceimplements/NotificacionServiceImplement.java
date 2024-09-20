package upc.edu.pe.happypaws.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.happypaws.entities.Notificacion;
import upc.edu.pe.happypaws.repositories.INotificacionRepository;
import upc.edu.pe.happypaws.serviceinterfaces.INotificacionService;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificacionServiceImplement implements INotificacionService {
    @Autowired
    private INotificacionRepository notificacionRepository;


    @Override
    public List<Notificacion> list() {
        return notificacionRepository.findAll();
    }

    @Override
    public void insert(Notificacion notificacion) {
        notificacionRepository.save(notificacion);
    }

    @Override
    public void update(Notificacion notificacion) {
        notificacionRepository.save(notificacion);
    }

    @Override
    public void delete(int notificacionId) {
        notificacionRepository.deleteById(notificacionId);
    }

    @Override
    public List<Notificacion> findemisor(int id) {
        return notificacionRepository.findemisor(id);
    }

    @Override
    public List<Notificacion> findreceptor(int id) {
        return notificacionRepository.findreceptor(id);
    }

    @Override
    public List<String[]> notifiacionxfecha(LocalDate fecha) {
        return notificacionRepository.notifiacionxfecha(fecha);
    }
}
