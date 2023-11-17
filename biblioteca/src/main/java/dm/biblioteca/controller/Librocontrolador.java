package dm.biblioteca.controller;

import dm.biblioteca.exception.RescursoNoEncontrado;
import dm.biblioteca.model.Libro;
import dm.biblioteca.service.LibroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/biblioteca-inventario-app")
@CrossOrigin(value = "http://localhost:4200")
public class Librocontrolador {
    private static final Logger logger = LoggerFactory.getLogger(Librocontrolador.class);
    @Autowired
    private LibroService libroService;

    @GetMapping("/libros")
    public List<Libro> obtenerLibros(){
        logger.info("Obteniendo libros");
        return this.libroService.listarLibro();
    }

    @PostMapping("/libros")
    public Libro guardarLibro(@RequestBody Libro libro){
        logger.info("Guardando libro");
        return this.libroService.guardarLibro(libro);
    }

    @GetMapping("/libros/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable(value = "id") Integer id){
        logger.info("Obteniendo libro por id");
        Libro libro = this.libroService.buscarLibro(id);
        if(libro == null){
            throw new RescursoNoEncontrado("Libro no encontrado con el id: "+id);
        }
        return ResponseEntity.ok().body(libro);
    }

    @PutMapping("/libros/{id}")
    public ResponseEntity<Libro> actulizarProducto(@PathVariable(value = "id") Integer id, @RequestBody Libro libroRecibido){
        logger.info("Actualizando libroRecibido");
        Libro libro = this.libroService.buscarLibro(id);
        if(libro == null){
            throw new RescursoNoEncontrado("Libro no encontrado con el id: "+id);
        }
        libro.setTitulo(libroRecibido.getTitulo());
        libro.setAutor(libroRecibido.getAutor());
        libro.setAnio(libroRecibido.getAnio());
        libro.setGenero(libroRecibido.getGenero());
        this.libroService.guardarLibro(libro);
        return ResponseEntity.ok(libro);
    }

    @DeleteMapping("/libros/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarLibro(@PathVariable(value = "id") Integer id){
        logger.info("Eliminando libro");
        Libro libro = this.libroService.buscarLibro(id);
        if(libro == null){
            throw new RescursoNoEncontrado("Libro no encontrado con el id: "+id);
        }
        this.libroService.eliminarLibroPorId(id);
        Map<String,Boolean> respuesta = Map.of("eliminado",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
