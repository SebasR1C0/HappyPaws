package upc.edu.pe.happypaws.serviceinterfaces;

import upc.edu.pe.happypaws.entities.Mascota;

import java.util.List;

public interface IMascotaService {
    public List<Mascota> list();
    public void insert(Mascota mascota);
    public void update(Mascota mascota);
    public void delete(int mascotaId);
    public List<Mascota> mascotasestado(boolean estado);
    public List<Mascota> mascotasrazas(String raza);
    public List<Mascota> mascotassexo(String sexo);
    public List<String[]> mascotaxraza();
    public List<String[]> mascotaxadopcion();
}
