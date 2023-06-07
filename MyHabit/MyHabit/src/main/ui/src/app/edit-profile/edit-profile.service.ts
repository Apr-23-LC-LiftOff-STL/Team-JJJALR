import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { ProfileEdit } from "./edit-profile";

@Injectable(
    { providedIn: 'root' }
)

export class EditProfileService {
    private javaServerUrl = environment.devServerUrl;

    constructor(private http: HttpClient) { }

    // EDIT PROFILE METHODS

    // // display user profile
    // public displayUserProfile(id: number): Observable<???> {
    //     return this.http.get<???> (`${this.javaServerUrl}/profile/${id}`);
    // }

    // update existing profile (personal information ONLY)
    public updateProfile(profileEdit: ProfileEdit): Observable<ProfileEdit> {
        return this.http.put<ProfileEdit>(`${this.javaServerUrl}/profile/update/info`, profileEdit);
    }

    // // update profile picture
    // public updateProfilePic() {
    //     return this.http.put<ProfileEdit>(`${this.javaServerUrl}/profile/update/info`, profileEdit);
    // }

    // // update status
    // public updateStatus() {
    //     return this.http.put<ProfileEdit>(`${this.javaServerUrl}/profile/update/info`, profileEdit);
    // }

    // // update bio
    // public updateBio() {
    //     return this.http.put<ProfileEdit>(`${this.javaServerUrl}/profile/update/info`, profileEdit);
    // }

    // // find profile by id
    // public findUserById(int id) {
    //     return this.http.put<ProfileEdit>(`${this.javaServerUrl}/profile/update/info`, profileEdit);
    // }

    // // delete profile
    // public deleteUser(id: number): Observable<void>  {
    //     return this.http.delete<void>(`${this.javaServerUrl}/profile/delete/${id}`);
    // }

}