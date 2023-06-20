import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MemeComponent } from './components/meme/meme.component';
import { FactComponent } from './components/fact/fact.component';
import { ContactComponent } from './components/contact/contact.component';
import { FavoriteComponent } from './components/favorite/favorite.component';
import { MemeDetailComponent } from './components/meme-detail/meme-detail.component';
import { FactDetailComponent } from './components/fact-detail/fact-detail.component';

const routes: Routes = [
  { path: 'memes', component: MemeComponent },
  { path: 'facts', component: FactComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'favorites', component: FavoriteComponent },
  //{ path: 'memedet', component: MemeDetailComponent },
  { path: 'memedet/:url', component: MemeDetailComponent },
  //{ path: 'factsdet', component: FactDetailComponent },
  { path: 'factsdet/:fact', component: FactDetailComponent },
  { path: '', redirectTo: 'memes', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
