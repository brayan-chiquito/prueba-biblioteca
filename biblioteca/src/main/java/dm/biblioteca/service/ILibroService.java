package dm.biblioteca.service;

import dm.biblioteca.model.Libro;

import java.util.List;

public interface ILibroService {
    public List<Libro> listarLibro();
    public Libro buscarLibro(Integer idLibro);
    public Libro guardarLibro(Libro libro);
    public void eliminarLibroPorId(Integer idLibro);
}
