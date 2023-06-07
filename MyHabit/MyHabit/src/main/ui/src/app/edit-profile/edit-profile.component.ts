import { Component, OnInit } from '@angular/core';
import { ProfileEdit } from './edit-profile';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  public profileEdit!: ProfileEdit;
  constructor(private http: HttpClient,
    private router: Router) { }

  ngOnInit(): void {
    if(!localStorage.authToken){
      this.router.navigate(['/registration'])
      } else {
      let url = `http://localhost:8080/profile/${localStorage.authToken}`
      this.http.get<any>(url).subscribe(res =>{
        // profileEdit now holds the User object for the user logged in
        // res is the response (user id)
      this.profileEdit = res;
      })
    }
  }
}
