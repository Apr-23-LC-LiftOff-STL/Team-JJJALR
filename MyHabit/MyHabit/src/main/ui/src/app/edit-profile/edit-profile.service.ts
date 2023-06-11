import { HttpClient } from "@angular/common/http";
import { Injectable} from "@angular/core";
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
    public profileEdit!: ProfileEdit;
      

    // CONSTRUCTOR
    // add HttpClient to make call to the backend
    constructor(private http: HttpClient) { }


    // EDIT-PROFILE METHODS
    // update existing profile
    public updateProfile(profileEdit: ProfileEdit,  id:  number): Observable<ProfileEdit> {
        return this.http.put<ProfileEdit>(`${this.javaServerUrl}/profile/edit/${localStorage.authToken}`, profileEdit);
    }

    // view profile
    public viewProfile(id:  number): Observable<ProfileEdit> {
        return this.http.get<ProfileEdit>(`${this.javaServerUrl}/profile/${localStorage.authToken}`);
    }

}
