package dm.biblioteca.service;

import dm.biblioteca.model.Libro;
import dm.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibroService implements ILibroService{
    @Autowired
    private LibroRepository libroRepository;
    @Override
    public List<Libro> listarLibro() {
        return this.libroRepository.findAll();
    }

    @Override
    public Libro buscarLibro(Integer idLibro) {
        return this.libroRepository.findById(idLibro).orElse(null);
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return this.libroRepository.save(libro);
    }

    @Override
    public void eliminarLibroPorId(Integer idLibro) {
        this.libroRepository.deleteById(idLibro);
    }
}
