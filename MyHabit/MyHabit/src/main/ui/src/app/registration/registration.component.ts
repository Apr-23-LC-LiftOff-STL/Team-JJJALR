import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

    model: any = {}

  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  register(){
    let url = 'http://localhost:8080/register'
    let userData = {
      userName: this.model.userName,
      password: this.model.password,
      passwordVerification: this.model.passwordVerification
    }
    console.log(userData)
    this.http.post<any>(url, userData).subscribe(res =>{
      console.log(res)
    })
  }

}
