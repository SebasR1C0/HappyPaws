package upc.edu.pe.happypaws.serviceinterfaces;

import upc.edu.pe.happypaws.entities.Notificacion;

import java.util.List;

public interface INotificacionService {
    public List<Notificacion> list();
    public void insert(Notificacion notificacion);
    public void update(Notificacion notificacion);
    public void delete(int notificacionId);
    public List<Notificacion> findemisor(int id);
    public List<Notificacion> findreceptor(int id);
}
