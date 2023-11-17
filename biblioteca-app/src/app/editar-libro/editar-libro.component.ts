import { Component } from '@angular/core';
import { Libro } from '../libro';
import { LibroService } from '../libro.service';
import { ActivatedRoute, Router } from '@angular/router';
import { error } from 'console';

@Component({
  selector: 'app-editar-libro',
  templateUrl: './editar-libro.component.html'
})
export class EditarLibroComponent {
  libro: Libro = new Libro();
  id: number;

  constructor(private libroService: LibroService, private ruta: ActivatedRoute, private enrutador: Router) { }

  ngOnInit(){
    this.id = this.ruta.snapshot.params['id'];
    this.libroService.obtenerLibroPorId(this.id).subscribe({
      next: (datos) => this.libro = datos
      ,
      error: (error: any) => console.log(error)
      }
    );
  }
  onSubmit(){
    this.guardarLibro();
  }
  guardarLibro(){
    this.libroService.editarLibro(this.id, this.libro).subscribe(
      {
        next: (datos) => this.irLibroLista(),
        error: (error: any) => console.log(error)
      }
    );
  }
  irLibroLista(){
    this.enrutador.navigate(['/libros']);
  }
}
