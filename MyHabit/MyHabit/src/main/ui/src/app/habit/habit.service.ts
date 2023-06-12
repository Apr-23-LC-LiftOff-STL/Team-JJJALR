import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Habit } from "./habit";

@Injectable({ providedIn: 'root' })
export class HabitService {
  private apiServerUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }
  
  public getHabits(): Observable<Habit[]> {
    return this.http.get<Habit[]>(`${this.apiServerUrl}/habit/all`)
  }

  public addHabits(habit: Habit): Observable<Habit> {
    return this.http.post<Habit>(`${this.apiServerUrl}/habit/add`, habit)
  }

  public updateHabits(habit: Habit, habitId: Number): Observable<Habit> {
    return this.http.put<Habit>(`${this.apiServerUrl}/habit/update${habitId}`, habit)
  }

  public deleteHabits(habitId: Number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/habit/delete${habitId}`)
  }
}
