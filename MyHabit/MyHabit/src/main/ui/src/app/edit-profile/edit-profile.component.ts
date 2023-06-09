import { Component, OnInit } from '@angular/core';
import { ProfileEdit } from './edit-profile';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { EditProfileService } from './edit-profile.service';
import { NgForm } from '@angular/forms';


// Add a component decorator - identifies the class as a component
// Choose a CSS selector - tells angular to instantiate the component where tag is found in html file
// Define the template - tells angular how to render the component
// Declare component styles by calling CSS file

// COMPONENT DECORATOR
@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css'],
})

export class EditProfileComponent implements OnInit {

  // PROPERTIES
  public profileEdit!: ProfileEdit;


  // CONSTRUCTORS
  constructor(private editProfileService: EditProfileService, private http: HttpClient, private router: Router) {
    this.http = http;
    this.router = router;
  }

  ngOnInit(): void {
    // when the component is initialized it will call the functions below
      this.onUpdateProfile();
  }

  public onUpdateProfile(editProfileForm:  NgForm): void {
    this.editProfileService.updateProfile(editProfileForm.value, this.profileEdit.id).subscribe(
      (response: ProfileEdit) => {
        this.profileEdit = response;
        this.router.navigate(['profile'])
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

}
