import { ChangeDetectorRef, Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TaskService } from '../../services/task.service';
import { TaskCreateRequest } from '../../../../models/task-create-request-model';

/**
 * Diese Component stellt ein Formular zum Erstellen
 * einer neuen Task bereit.
 *
 * Verantwortlichkeiten:
 * - Formular definieren
 * - Validierung bereitstellen
 * - Submit verarbeiten
 * - Backend aufrufen
 * - nach Erfolg zurück zur Liste navigieren
 */
@Component({
  selector: 'app-task-create',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './task-create.component.html',
  styleUrl: './task-create.component.scss'
})
export class TaskCreateComponent {
  private readonly fb = inject(FormBuilder);
  private readonly taskService = inject(TaskService);
  private readonly router = inject(Router);
  private readonly cdr = inject(ChangeDetectorRef);

  /**
   * Speichert, ob gerade ein Submit läuft.
   */
  submitting = false;

  /**
   * Fehlernachricht für den UI-Fall, dass das Speichern scheitert.
   */
  error = '';

  /**
   * Reactive Form:
   * Hier definieren wir Felder, Startwerte und Validatoren.
   */
  taskForm = this.fb.group({
    title: ['', [Validators.required, Validators.maxLength(255)]],
    description: ['', [Validators.maxLength(1000)]],
    status: ['TODO', [Validators.required]]
  });

  /**
   * Wird beim Formular-Submit aufgerufen.
   */
  onSubmit(): void {
    this.error = '';

    /**
     * Wenn das Formular ungültig ist,
     * brechen wir den Submit sauber ab.
     */
    if (this.taskForm.invalid) {
      this.taskForm.markAllAsTouched();
      return;
    }

    this.submitting = true;

    /**
     * getRawValue() liest die aktuellen Formwerte aus.
     *
     * Wir mappen die Werte bewusst in unser Request-Modell.
     */
    const formValue = this.taskForm.getRawValue();

    const request: TaskCreateRequest = {
      title: formValue.title ?? '',
      description: formValue.description || null,
      status: (formValue.status as 'TODO' | 'IN_PROGRESS' | 'DONE') ?? 'TODO'
    };

    this.taskService.createTask(request).subscribe({
      next: (createdTask) => {
        console.log('Task erfolgreich erstellt:', createdTask);
        this.submitting = false;
        this.cdr.detectChanges();

        /**
         * Nach erfolgreichem Speichern zurück zur Liste.
         */
        this.router.navigateByUrl('/');
      },
      error: (err) => {
        console.error('Fehler beim Erstellen der Task:', err);
        this.error = 'Task konnte nicht erstellt werden.';
        this.submitting = false;
        this.cdr.detectChanges();
      }
    });
  }
}