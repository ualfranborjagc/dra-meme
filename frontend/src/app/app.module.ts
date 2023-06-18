import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { MemeComponent } from './components/meme/meme.component';
import { FactComponent } from './components/fact/fact.component';
import { ContactComponent } from './components/contact/contact.component';
import { MenuComponent } from './components/menu/menu.component';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from '@angular/router';
import { MemeDetailComponent } from './components/meme-detail/meme-detail.component';
import { FactDetailComponent } from './components/fact-detail/fact-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    MemeComponent,
    FactComponent,
    ContactComponent,
    MenuComponent,
    MemeDetailComponent,
    FactDetailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
