package upc.edu.pe.happypaws.serviceinterfaces;

import upc.edu.pe.happypaws.entities.Albergue;

import java.util.List;

public interface IAlbergueService {
    public List<Albergue> list();
    public void insert(Albergue albergue);
    public void update(Albergue albergue);
    public void delete(int albergueId);
}
