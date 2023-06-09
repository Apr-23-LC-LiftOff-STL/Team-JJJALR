import { HttpClient } from "@angular/common/http";
import { Injectable, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { ProfileEdit } from "./edit-profile";

// Injectables mark a class as available to be used as a dependency
// 'root' refers to the application-level injector - it should appear as a provider in the app.module.ts file
// Services should be scoped (called only when needed) by making them LAZY (lazy loading them)

// INJECTABLE DECORATOR
@Injectable(
    { providedIn: 'root' }
)

export class EditProfileService {

    // assign backend URL from environment.ts to the javaServerUrl variable to reference below
    private javaServerUrl = environment.devServerUrl;

    // CONSTRUCTOR
    // add HttpClient to make call to the backend
    constructor(private http: HttpClient) { }


    // EDIT-PROFILE METHODS
    // update existing profile (personal information ONLY)
    public updateProfile(profileEdit: ProfileEdit): Observable<ProfileEdit> {
        return this.http.put<ProfileEdit>(`${this.javaServerUrl}/profile/${id}/update/info`, profileEdit);
    }


    // TODO: MOVE TO THEIR OWN INDIVIDUAL COMPONENTS - need their own forms
    // // update profile picture
    // public updateProfilePic(): Observable<any> {
    //     return this.http.put<any>(`${this.javaServerUrl}/profile/${id}/update/picture`, Observable);
    // }

    // // update status
    // public updateStatus(): Observable<any>  {
    //     return this.http.put<any>(`${this.javaServerUrl}/profile/${id}/update/status`, Observable);
    // }

    // // update bio
    // public updateBio(): Observable<any>  {
    //     return this.http.put<any>(`${this.javaServerUrl}/profile/${id}/update/bio`, Observable);
    // }


    // MOVE TO USER SERVICE COMPONENT
    // ** insert findAllUsers method somewhere
    //
    // // find profile by id
    // public findUserById(id: number): Observable<any>  {
    //     return this.http.get<any>(`${this.javaServerUrl}/profile/${id}`);
    // }
    // display user profile
    // public displayUserProfile(id: number): Observable<any> {
    //     return this.http.get<any> (`${this.javaServerUrl}/profile/${id}`, Observable);
    // }
    // // delete user
    // public deleteUser(userId: number): Observable<void>  {
    //     return this.http.delete<void>(`${this.javaServerUrl}/profile/delete/${id}`);
    // }

}
