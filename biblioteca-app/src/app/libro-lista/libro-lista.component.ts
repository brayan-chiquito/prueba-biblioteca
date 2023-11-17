import { Component } from '@angular/core';
import { Libro } from '../libro';
import { LibroService } from '../libro.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-libro-lista',
  templateUrl: './libro-lista.component.html'
})
export class LibroListaComponent {
  libros: Libro[];
  constructor(private libroService: LibroService, private enrutador: Router) { }

  ngOnInit(){
    this.obtenerLibros();
  }
  obtenerLibros(){
    this.libroService.obtenerLibros().subscribe(data => {
      this.libros = data;
    });
  }

  editarLibro(id: number){
    this.enrutador.navigate(['editar-libro', id]);
  }
  eliminarLibro(id: number){
    this.libroService.eliminarLibro(id).subscribe(
      {
        next: (datos) => this.obtenerLibros(),
        error: (error) => console.error(error)
      }
    );
  }
}
