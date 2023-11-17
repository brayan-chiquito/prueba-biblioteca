import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Libro } from './libro';

@Injectable({
  providedIn: 'root'
})
export class LibroService {
  private urlBase = "http://localhost:8080/biblioteca-inventario-app/libros";
  constructor(private httpClient: HttpClient) {}
    
  obtenerLibros(): Observable<Libro[]> {
    return this.httpClient.get<Libro[]>(this.urlBase);
  }
  agregarLibro(libro: Libro): Observable<Object> {
    return this.httpClient.post(this.urlBase, libro);
  }
  obtenerLibroPorId(id: number){
    return this.httpClient.get<Libro>(this.urlBase+"/"+id);
  }
  editarLibro(id: number, libro: Libro): Observable<Object>{
    return this.httpClient.put(this.urlBase+"/"+id, libro);
  }
  eliminarLibro(id: number): Observable<Object>{
    return this.httpClient.delete(this.urlBase+"/"+id);
  }
}
