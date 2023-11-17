import { Component } from '@angular/core';
import { Libro } from '../libro';
import { LibroService } from '../libro.service';
import { Router } from '@angular/router';
import { error } from 'console';

@Component({
  selector: 'app-agregar-libro',
  templateUrl: './agregar-libro.component.html',
  styleUrl: './agregar-libro.component.css'
})
export class AgregarLibroComponent {
  libro: Libro = new Libro();
  constructor(private libroService: LibroService, private enrutador: Router) { }

  onSubmit() {
    this.guardarLibro();
  }

  guardarLibro() {
    this.libroService.agregarLibro(this.libro).subscribe(
      { 
        next: (datos) => {
        this.irListadoLibros();
      },
      error: (error: any) => {console.log(error)}
      }
    );
  }

  irListadoLibros() {
    this.enrutador.navigate(['/libros']);
  }

}
