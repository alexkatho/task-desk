import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../../../models/task.model';
/**
 * Der TaskService kapselt die Kommunikation mit dem Backend.
 *
 * Ganz wichtig:
 * HTTP-Zugriffe gehören nicht direkt in Komponenten,
 * sondern in Services.
 *
 * Warum?
 * - Trennung von UI und Datenzugriff
 * - Wiederverwendbarkeit
 * - bessere Testbarkeit
 * - klarere Architektur
 */
@Injectable({
  providedIn: 'root'
})
export class TaskService {
  /**
   * HttpClient wird aus Angulars Dependency Injection geholt.
   *
   * Das funktioniert nur, weil wir in app.config.ts
   * provideHttpClient() registriert haben.
   */
  private readonly http = inject(HttpClient);

  /**
   * Basis-URL unseres Backends.
   *
   * Für den Start schreiben wir die URL noch direkt hinein,
   * damit der Datenfluss klar bleibt.
   *
   * Später lagern wir das in environment-Dateien aus.
   */
  private readonly apiUrl = 'http://localhost:8080/api/tasks';

  /**
   * Lädt alle Tasks aus dem Backend.
   *
   * Rückgabe ist ein Observable<Task[]>.
   *
   * Wichtige Denkweise:
   * Ein HTTP-Call ist asynchron.
   * Wir bekommen also nicht sofort eine Liste zurück,
   * sondern ein Objekt, das später Daten liefert.
   */
  getTasks(): Observable<Task[]> {
  console.log('HTTP GET an:', this.apiUrl);
  return this.http.get<Task[]>(this.apiUrl);
}
}