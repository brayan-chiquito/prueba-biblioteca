package dm.biblioteca;

import dm.biblioteca.controller.Librocontrolador;
import dm.biblioteca.model.Libro;
import dm.biblioteca.service.LibroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(Librocontrolador.class)
public class LibroControladorTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibroService libroService;

    @Test
    public void testObtenerLibros() throws Exception {
        // Datos de prueba
        Libro libro1 = new Libro(1,"El señor de los anillos", "J.R.R. Tolkien", "1954", "Fantasía");
        Libro libro2 = new Libro(2,"Libro 2", "Autor 2", "1954", "Fantasía");
        List<Libro> libros = Arrays.asList(libro1,libro2);

        // Configuración del servicio mock
        when(libroService.listarLibro()).thenReturn(libros);

        // Realizar la solicitud simulada y verificar la respuesta
        mockMvc.perform(get("/libros"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idLibro").value(1))
                .andExpect(jsonPath("$[0].titulo").value("El señor de los anillos"))
                .andExpect(jsonPath("$[0].autor").value("J.R.R. Tolkien"))
                .andExpect(jsonPath("$[1].idLibro").value(2))
                .andExpect(jsonPath("$[1].titulo").value("Libro 2"))
                .andExpect(jsonPath("$[1].autor").value("Autor 2"));
    }

}
