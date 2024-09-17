package upc.edu.pe.happypaws.serviceinterfaces;

import upc.edu.pe.happypaws.entities.Comprobante;

import java.util.List;

public interface IComprobanteService {
    public List<Comprobante> list();
    public void insert(Comprobante comprobante);
    public void update(Comprobante comprobante);
    public void delete(int comprobanteId);
}
