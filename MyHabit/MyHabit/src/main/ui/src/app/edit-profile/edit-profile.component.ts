import { Component, OnInit } from '@angular/core';
import { ProfileEdit } from './edit-profile';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { EditProfileService } from './edit-profile.service';
import { error } from 'console';
@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  // PROPERTIES
  // call ProfileEdit interface
  public profileEdit!: ProfileEdit;
  model: any = {};


  // CONSTRUCTORS
  constructor(private editProfileService: EditProfileService, private http: HttpClient, private router: Router) {
    this.http = http;
    this.router = router;
  }

  ngOnInit(): void {
    if (!localStorage.authToken) {
      this.router.navigate(['/registration'])
    } else {
      let url = `http://localhost:8080/profile/${localStorage.authToken}`
      this.http.get<any>(url).subscribe(res => {
        // profileEdit now holds the User object for the user logged in
        // res is the response (user id)
        this.profileEdit = res;
      })
    }
  }

  
  // METHODS:

  // UPDATE PROFILE INFO
  // onUpdateProfile takes in editPorfileForm as paramenter, returns nothing (void)
  public onUpdateProfile(editProfileForm: ngForm): void {
    // call updateProfile method from editProfileService
    // takes in values from profile form (editProfileForm.value) as parameters
    // .subscribe listens for the appropriate event to execute the fxn in ()
    this.editProfileService.updateProfile(editProfileForm.value).subscribe(
      // assign ProfileEdit values to response variable
      (response: ProfileEdit) => {
        // when event occurs, .subscribe will print response
        console.log(response);
        // if a user's id (I picked an arbitrary field) is not undefined
        if (response.id != 0) {
          // then return the user to their profile???
          this.router.navigate([''])
        }
      },
      // if an error occurs, print error message
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  };

  // addProfile method is encompassed in addUsers method in AuthenticationController
  // users create a profile upon registration

  // updateProfile() {
  //   let url = 'http://localhost:8080/profile/update/info';
  //   let profileData = {
  //     userId: this.model.userId,
  //     firstName: this.model.firstName,
  //     lastName: this.model.lastName,
  //     displayName: this.model.displayName,
  //     email: this.model.email,
  //     location: this.model.location,
  //     status: this.model.status
  //   }
  //   console.log(profileData)
  // this.http.put<any>(url, profileData).subscribe(res =>{
  //   console.log("test")
  //   console.log(res)
  //   if(res.id !== 0){
  //     localStorage.setItem('authToken', res.id)
  //     console.log(localStorage.authToken)
  //      this.router.navigate(["homepage"])
  //   }
  // }),
  // console.log()
  // }

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
