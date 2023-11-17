package dm.biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RescursoNoEncontrado extends RuntimeException{
    public RescursoNoEncontrado(String mensaje){
        super(mensaje);
    }
}
