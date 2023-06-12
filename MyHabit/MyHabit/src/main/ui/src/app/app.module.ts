import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ProfileComponent } from './profile/profile.component';
// import { FlexLayoutModule } from "@angular/flex-layout";

// COMPONENTS
import { AppComponent } from './app.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { TimelineComponent } from './timeline/timeline.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegistrationComponent } from './registration/registration.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { HomepageComponent } from './homepage/homepage.component';

import { CreateHabitComponent } from './create-habit/create-habit.component';
import { HabitComponent } from './habit/habit.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';

// SERVICES
// import { EditProfileService } from './edit-profile/edit-profile.service';


const routes: Routes = [
  {path: "", component: HomepageComponent },
  {path: "login", component: UserloginComponent },
  {path: "profile", component: ProfileComponent },
  {path: "registration", component: RegistrationComponent },
  {path: "timeline", component: TimelineComponent },
  {path: "registration", component: RegistrationComponent },
  {path: "timeline", component: TimelineComponent},
  {path:"registration", component: RegistrationComponent},
  {path:"homepage", component: HomepageComponent},
  {path:"createhabit", component: CreateHabitComponent},
  {path: "homepage", component: HomepageComponent },
  {path: "edit/:id", component: EditProfileComponent }


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
    CreateHabitComponent,
    HabitComponent,
    EditProfileComponent
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
    // EditProfileService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}
