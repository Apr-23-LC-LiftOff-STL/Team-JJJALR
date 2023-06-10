import { Component, OnInit } from '@angular/core';
// import { profile } from '../profile/profile';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-profile',
  templateUrl: './add-profile.component.html',
  styleUrls: ['./add-profile.component.css']
})
export class AddProfileComponent implements OnInit {

 

  constructor(){}

  ngOnInit(): void {
  }

  // public addProfile() {
  //   let url = `${this.javaServerUrl}/profile/add`;
  //   let profileData = {
  //     firstName: this.model.firstName,
  //     lastName: this.model.lastName,
  //     displayName: this.model.displayName,
  //     email: this.model.email,
  //     location: this.model.location,
  //     status: this.model.status,
  //     bio: this.model.bio,
  //     profileImageURL: this.model.profileImageURL,
  //   };
  //   console.log(profileData)
  //   console.log(url);
  //   this.http.post<any>(url, profileData).subscribe(res => {
  //     console.log(profileData);
  //     console.log(res); // ERROR OCCURING HERE

  //     //   if(res.id !== 0){
  //     //     localStorage.setItem('authToken', res.id)
  //     //     console.log(localStorage.authToken)
  //     //   }
  //     // }, (error: HttpErrorResponse) => {
  //     //   alert(error.message);
  //     // })
  //   })
  // };
  
}