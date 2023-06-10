import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';
// import { FlexLayoutModule } from "@angular/flex-layout";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { TimelineComponent } from './timeline/timeline.component';
import { NavbarComponent } from './navbar/navbar.component';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

import { RegistrationComponent } from './registration/registration.component';
import { ProfileComponent } from './profile/profile.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { HomepageComponent } from './homepage/homepage.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { EditProfileService } from './edit-profile/edit-profile.service';
import { AddProfileComponent } from './add-profile/add-profile.component';

const routes: Routes = [
  { path: "", component: HomepageComponent },
  { path: "login", component: UserloginComponent },
  { path: "profile", component: ProfileComponent },
  { path: "registration", component: RegistrationComponent },
  { path: "timeline", component: TimelineComponent },
  { path: "registration", component: RegistrationComponent },
  { path: "homepage", component: HomepageComponent },
  {
    path: "update",
    children: [
      { path: "info", component: EditProfileComponent }
    ]
  },
  { path: "profile/add", component: AddProfileComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    UserloginComponent,
    NavbarComponent,
    TimelineComponent,
    RegistrationComponent,
    HomepageComponent,
    ProfileComponent,
    EditProfileComponent,
    AddProfileComponent
  ],
  imports: [
    // FlexLayoutModule,
    BrowserModule,
    AppRoutingModule,
    MatSlideToggleModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule,
    NoopAnimationsModule
  ],
  providers: [
    EditProfileService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}
