import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LibroListaComponent } from './libro-lista/libro-lista.component';
import { AgregarLibroComponent } from './agregar-libro/agregar-libro.component';
import { EditarLibroComponent } from './editar-libro/editar-libro.component';

const routes: Routes = [
  {path: 'libros', component: LibroListaComponent},
  {path: '', redirectTo: '/libros', pathMatch: 'full'},
  {path: 'agregar-libro', component: AgregarLibroComponent},
  {path: 'editar-libro/:id', component: EditarLibroComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
