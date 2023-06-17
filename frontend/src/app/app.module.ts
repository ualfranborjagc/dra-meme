import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { SidenavComponent } from './components/sidenav/sidenav.component';
import { NombreDelComponenteComponent } from './components/nombre-del-componente/nombre-del-componente.component';
import { MemeComponent } from './components/meme/meme.component';
import { FactComponent } from './components/fact/fact.component';
@NgModule({
  declarations: [
    AppComponent,
    SidenavComponent,
    NombreDelComponenteComponent,
    MemeComponent,
    FactComponent,
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
