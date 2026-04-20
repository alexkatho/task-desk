/**
 * Frontend-Modell einer Task.
 *
 * Dieses Interface beschreibt, wie eine Task
 * in unserer Angular-Anwendung verwendet wird.
 *
 * Wichtig:
 * Das ist kein "echtes" Laufzeitobjekt wie in Java,
 * sondern ein TypeScript-Typ zur Entwicklungszeit.
 * Er hilft uns bei Lesbarkeit, Typsicherheit und Autovervollständigung.
 */
export interface Task {
  id: number;
  title: string;
  description: string | null;
  status: 'TODO' | 'IN_PROGRESS' | 'DONE';
}