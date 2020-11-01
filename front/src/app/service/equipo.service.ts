import {Injectable, NgZone} from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {EquipoModel} from "../model/Equipo.model";
import { v4 as uuid } from 'uuid';


@Injectable({
  providedIn: 'root'
})
export class EquipoService {

  private url = `${environment.urlApiEquipo}`;

  constructor(
    private http: HttpClient,
    private ngZone: NgZone
  ) {
  }

  findAll(): Observable<Array<EquipoModel>> {
    return this.http.get<Array<EquipoModel>>(`${this.url}`);
  }

  getEquipoEvents(): Observable<any> {
    return new Observable(observer => {
      let idUnico = uuid();
      const eventSource = new EventSource(`${this.url}/stream/${idUnico}`);

      eventSource.onmessage = event => {
        this.ngZone.run(() => {
          observer.next(event);
        });
      };

      eventSource.onerror = error => {
        this.ngZone.run(() => {
          console.error(error);
          observer.error(error);
        });
      };
    });
  }
}
