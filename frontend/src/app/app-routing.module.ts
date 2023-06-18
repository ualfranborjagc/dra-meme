import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MemeComponent } from './components/meme/meme.component';
import { FactComponent } from './components/fact/fact.component';
import { ContactComponent } from './components/contact/contact.component';

const routes: Routes = [
  { path: 'memes', component: MemeComponent },
  { path: 'facts', component: FactComponent },
  { path: 'contact', component: ContactComponent },
  { path: '', redirectTo: 'memes', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
