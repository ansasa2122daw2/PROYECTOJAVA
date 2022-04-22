package DAO;

import java.util.List;

public interface InterfaceDAO {
    public List <Persona> getAll();
    public void insert(Persona p);
    public void update(Persona p);
    public void delete(Persona p);
}
