import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListarEquipoComponent} from "./components/equipo/listar-equipo/listar-equipo.component";

const routes: Routes = [
  {path: "", redirectTo: "listar-equipo", pathMatch: "full"},
  {path: "listar-equipo", component: ListarEquipoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
