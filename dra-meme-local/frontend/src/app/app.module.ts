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
import { FavoriteComponent } from './components/favorite/favorite.component';
import { ApiServiceService } from './api-service.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    MemeComponent,
    FactComponent,
    ContactComponent,
    MenuComponent,
    MemeDetailComponent,
    FactDetailComponent,
    FavoriteComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ApiServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
