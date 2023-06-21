import { Component, OnInit } from '@angular/core';
import { ApiServiceService } from '../../api-service.service';

interface meme {
  id: number;
  favId: number;
  memeImg: string;
}

@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.css'],
})
export class FavoriteComponent {
  favorites: any[] = [];
  memes: meme[] = [];
  favname: string = '';

  constructor(private apiService: ApiServiceService) {}
  ngOnInit(): void {
    this.getAllFavorites();
    this.getFavorite();
  }

  //Mostrar favoritos
  getAllFavorites() {
    this.apiService.getAllFavorites().subscribe(
      (response: any) => {
        this.favorites = response;
        console.log(this.favorites);
      },
      (error: any) => {
        console.log(error);
      }
    );
  }
  //quitar un favorito
  quitFavorite(id: any) {
    this.apiService.deleteFavorite(id).subscribe(
      (response: any) => {
        console.log(response);
      },
      (error: any) => {
        console.log(error);
      }
    );
  }
  crearFavorito() {
    var fav = {
      nameFav: this.favname,
    };
    this.apiService.createFavoriteGroup(fav).subscribe(
      (response: any) => {
        console.log(response);
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  getFavorite() {
    this.favorites = [];
    this.apiService.getAllFavorites().subscribe((data: any) => {
      this.favorites = data;
      console.log(data);
      this.loadMemes();
    });
  }

  loadMemes() {
    this.memes = [];
    this.favorites.forEach(favorite => {
      this.getMemesofFavorite(favorite.id);
    });
  }

  getMemesofFavorite(idFav: any) {
    this.apiService.getFavoriteById(idFav).subscribe((data: any) => {
      const favorites: meme[] = data.map((meme: any) => {
        return {
          id: meme.id,
          favId: meme.id,
          memeImg: meme.memeImg,
        };
      });
      this.memes = this.memes.concat(favorites);
    });
  }

}

/*
import { Component, OnInit } from '@angular/core';
import { ApiServiceService } from '../../api-service.service';


@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.css'],
})
export class FavoriteComponent {
  favorites: any[] = [];
  memesFavorite: any[] = [];
  favname: string = '';

  constructor(private apiService: ApiServiceService) {}
  ngOnInit(): void {
    this.getAllFavorites();
  }

  //Mostrar favoritos
  getAllFavorites() {
    this.apiService.getAllFavorites().subscribe(
      (response: any) => {
        this.favorites = response;
        console.log(this.favorites);
        for (let i = 0; i < this.favorites.length; i++) {
          this.getFavorite(this.favorites[i].id);
        }
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  crearFavorito() {
    var fav = {
      nameFav: this.favname,
    };
    this.apiService.createFavoriteGroup(fav).subscribe(
      (response: any) => {
        console.log(response);
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  getFavorite(id:any) {
    this.apiService.getMemesByFavoritoId(id).subscribe((data: any) => {
      this.memesFavorite = data;
      console.log(data.id);
    });
  }
}
 */
