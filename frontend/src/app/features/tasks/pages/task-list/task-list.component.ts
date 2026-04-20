import { ChangeDetectorRef, Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TaskService } from '../../services/task.service';
import { Task } from '../../../../models/task.model';

/**
 * Diese Component repräsentiert die Task-Listen-Seite.
 *
 * Verantwortung dieser Component:
 * - Daten beim Start laden
 * - Ladezustand verwalten
 * - Fehlerzustand verwalten
 * - Daten fürs Template bereitstellen
 */
@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './task-list.component.html',
  styleUrl: './task-list.component.scss'
})
export class TaskListComponent implements OnInit {
  /**
   * Zugriff auf unseren TaskService.
   */
  private readonly taskService = inject(TaskService);

  private readonly cdr = inject(ChangeDetectorRef);

  /**
   * Hier speichern wir die geladenen Tasks.
   */
  tasks: Task[] = [];

  /**
   * Zeigt an, ob gerade geladen wird.
   */
  loading = false;

  /**
   * Fehlernachricht für UI-Anzeige.
   */
  error = '';

  /**
   * Lifecycle-Hook:
   * Wird aufgerufen, wenn die Component initialisiert ist.
   */
  ngOnInit(): void {
    this.loadTasks();
  }

  /**
   * Lädt Tasks aus dem Backend.
   */
  loadTasks(): void {
    this.loading = true;
    this.error = '';

    console.log('Starte Request auf Tasks API...');

    this.taskService.getTasks().subscribe({
      next: (tasks) => {
        this.tasks = tasks;
        this.loading = false;
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error('Fehler beim Laden der Tasks:', err);
        this.error = 'Tasks konnten nicht geladen werden.';
        this.loading = false;
        this.cdr.detectChanges();
      },
      complete: () => {
        console.log('Task-Request abgeschlossen.');
      }
    });
  }
}