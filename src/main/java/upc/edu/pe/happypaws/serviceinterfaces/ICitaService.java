package upc.edu.pe.happypaws.serviceinterfaces;

import upc.edu.pe.happypaws.entities.Cita;

import java.util.List;

public interface ICitaService {
    public List<Cita> list();
    public void insert(Cita cita);
    public void update(Cita cita);
    public void delete(int citaId);
}
