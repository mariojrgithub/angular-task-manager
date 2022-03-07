import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../Task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private apiUrl = 'http://localhost:4040/api/v1/tasks';

  constructor(private http: HttpClient) { }

  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.apiUrl)
  }

  deleteTask(task: Task): Observable<Task> {
    const url = `${this.apiUrl}/${task.taskId}`;
    return this.http.delete<Task>(url);
  }

  updateTaskCompleted(task: Task): Observable<Task> {
    const url = `${this.apiUrl}`;
    return this.http.put<Task>(url, task);
  } 
}
