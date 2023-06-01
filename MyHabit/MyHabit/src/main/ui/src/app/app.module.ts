import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';
// import { FlexLayoutModule } from "@angular/flex-layout";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { HttpClientModule, HttpClient} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RegistrationComponent } from './registration/registration.component';
import { HomepageComponent } from './homepage/homepage.component';
import { EditorModule } from '@tinymce/tinymce-angular';
import { HabitcreateHabitComponent } from './habitcreate-habit/habitcreate-habit.component';


const routes: Routes = [
  {path:"", component: HomepageComponent},
  {path:" ", component: HomepageComponent},
  {path:"login", component: UserloginComponent},
  {path:"registration", component: RegistrationComponent},
  {path:"homepage", component: HomepageComponent}

]


@NgModule({
  declarations: [
    AppComponent,
    UserloginComponent,
    RegistrationComponent,
    HomepageComponent,
    HabitcreateHabitComponent,
  ],
  imports: [
    // FlexLayoutModule,
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule,
    EditorModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {

}

