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

  // declare/initialize fields?

  public profileEdit!: ProfileEdit;
  model: any = {};

  constructor(
    private http: HttpClient,
    private router: Router) { }

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

  // METHODS

  // TODO: need to write an add profile method in UserController if not already there
  // addProfile() { }

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
  }

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
