import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit {
  

 
  model: any = {};

  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  // public onLoginClick(){
  //   this.router.navigate(['./homepage']);
  // }

  ngOnInit(): void {
  }

  login(){
    let url = 'http://localhost:8080/login'
    let userData = {
      userName: this.model.userName,
      password: this.model.password
    };
    console.log(userData);
    this.http.post<any>(url, userData).subscribe(res =>{
      console.log("test")
      console.log(res)
      if(res.id !== 0){
        localStorage.setItem('authToken', res.id)
        console.log(localStorage.authToken)
         this.router.navigate(["homepage"])
      }
    }),
    // // (error: HttpErrorResponse) => {
    // //   alert(error.message);
    // },

    console.log()
  }
}


