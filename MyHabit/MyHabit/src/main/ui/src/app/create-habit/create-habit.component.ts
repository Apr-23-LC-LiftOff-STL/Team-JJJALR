import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { HabitComponent } from '../habit/habit.component';
import { HabitService } from '../habit/habit.service';
import { NgForm } from '@angular/forms';
import { Habit } from '../habit/habit';



@Component({
  selector: 'app-create-habit',
  templateUrl: './create-habit.component.html',
  styleUrls: ['./create-habit.component.css']
})
export class CreateHabitComponent implements OnInit {
  public habit?: Habit;
  model: any = {}

  constructor(private habitService:HabitService,
    private http: HttpClient,
    private router: Router) { 
    
  }

  ngOnInit(): void {
  }

  onAddHabit(habitForm: NgForm){
    this.habitService.addHabits(habitForm.value).subscribe((response: Habit) => {
      console.log(response);
    },)
  }

}
