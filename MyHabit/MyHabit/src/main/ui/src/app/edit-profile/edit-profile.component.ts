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
  // call ProfileEdit interface
  public profileEdit!: ProfileEdit;
  model: any = {};


  // CONSTRUCTORS
  constructor(private http: HttpClient, private router: Router) { }

  // constructor(private editProfileService: EditProfileService, private http: HttpClient, private router: Router) {
  //   this.http = http;
  //   this.router = router;
  // }

  ngOnInit(): void {
    // on initialization, if authToken (userId) doesn't exist
    if (!localStorage.authToken) {
      // route to registration form
      this.router.navigate(['/registration'])
    } else {
      // else if authToken is valid (user does exist), go to user's profile
      let url = `http://localhost:8080/profile/${localStorage.authToken}`
      // make a get request to user profile url with userId
      this.http.get<any>(url)
      // when the get request is made, assign the user's id to "response"
      .subscribe(response => {
        // profileEdit now holds the User object for the user logged in
        this.profileEdit = response;
      })
    }
  }


  // METHODS:

  // UPDATE PROFILE INFO

  // addProfile method is encompassed in addUsers method in AuthenticationController
  // users create a profile upon registration

  updateProfile() {
    let url = 'http://localhost:8080/profile/update/info';
    let profileData = {
      userId: this.model.userId,
      firstName: this.model.firstName,
      lastName: this.model.lastName,
      displayName: this.model.displayName,
      email: this.model.email,
      location: this.model.location,
      status: this.model.status
    }
    console.log(profileData)
    this.http.put<any>(url, profileData).subscribe(res => {
      console.log("test")
      console.log(res)
      if (res.id !== 0) {
        localStorage.setItem('authToken', res.id)
        console.log(localStorage.authToken)
        this.router.navigate(["profile"])
      }
    }),
      console.log()
  }

  // onUpdateProfile takes in editPorfileForm as paramenter, returns nothing (void)
  // public onUpdateProfile(editProfileForm: NgForm): void {
  //   // call updateProfile method from editProfileService
  //   // takes in values from profile form (editProfileForm.value) as parameters
  //   // .subscribe listens for the appropriate event to execute the fxn in ()
  //   this.editProfileService.updateProfile(editProfileForm.value).subscribe(
  //     // assign ProfileEdit values to response variable
  //     (response: ProfileEdit) => {
  //       // when event occurs, .subscribe will print response
  //       console.log(response);
  //       // if a user's id (I picked an arbitrary field) is not undefined
  //       if (response.id != 0) {
  //         // then return the user to their profile???
  //         this.router.navigate(['profile'])
  //       }
  //     },
  //     // if an error occurs, print error message
  //     (error: HttpErrorResponse) => {
  //       alert(error.message);
  //     }
  //   )
  // };

  // updateProfilePic() {
  //   let url = 'http://localhost:8080/profile/update/info';
  //   let picData = {
  //     userId: this.model.userId,
  //     picUrl: this.model.picUrl
  //   }
  //   console.log(picData)
  // }

  // updateStatus() {
  //   let url = 'http://localhost:8080/profile/update/status';
  //   let statusData = {
  //     userId: this.model.userId,
  //     status: this.model.status
  //   }
  //   console.log(statusData)
  // }

  // updateBio() {
  //   let url = 'http://localhost:8080/profile/update/bio';
  //   let bioData = {
  //     userId: this.model.userId,
  //     bio: this.model.bio
  //   }
  //   console.log(bioData)
  // }

  // findUserById() {
  //   let url = 'http://localhost:8080/profile/${localStorage.authToken}';
  //   let userId = this.model.userId;
  // }

  // deleteUser() {
  //   let url = 'http://localhost:8080/profile/delete/${localStorage.authToken}';
  //   let userId = this.model.userId;
  // }

}
