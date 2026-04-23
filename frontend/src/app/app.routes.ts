import { Routes } from '@angular/router';
import { TaskListComponent } from './features/tasks/pages/task-list/task-list.component';
import { TaskCreateComponent } from './features/tasks/pages/task-create/task-create.component';

export const routes: Routes = [
  {
    path: '',
    component: TaskListComponent
  },
  {
    path: 'tasks/new',
    component: TaskCreateComponent
  }
];