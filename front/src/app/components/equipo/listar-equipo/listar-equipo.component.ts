import {Component, OnInit} from '@angular/core';
import {EquipoService} from "../../../service/equipo.service";
import {EquipoModel} from "../../../model/Equipo.model";

@Component({
  selector: 'app-listar-equipo',
  templateUrl: './listar-equipo.component.html',
  styleUrls: ['./listar-equipo.component.css']
})
export class ListarEquipoComponent implements OnInit {

  public listaEquipo: Array<EquipoModel>;

  constructor(
    private equipoService: EquipoService
  ) {
  }

  ngOnInit(): void {
    this.consultar();

    this.equipoService.getEquipoEvents().subscribe(event => {
      this.listaEquipo.push(JSON.parse(event.data));
    })
  }

  private consultar(): void {
    this.equipoService.findAll().subscribe({
      next: equipos => {
        this.listaEquipo = equipos;
      },
      error: err => {
        this.listaEquipo = [];
      }
    })
  }
}
