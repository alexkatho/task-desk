/**
 * Dieses Interface beschreibt die Daten,
 * die unser Frontend an das Backend sendet,
 * wenn eine neue Task erstellt wird.
 *
 * Wichtig:
 * Das ist bewusst NICHT dasselbe wie Task.
 *
 * Warum?
 * Beim Erstellen hat die Task noch keine ID.
 * Die ID wird erst vom Backend erzeugt.
 */
export interface TaskCreateRequest {
  title: string;
  description: string | null;
  status: 'TODO' | 'IN_PROGRESS' | 'DONE';
}