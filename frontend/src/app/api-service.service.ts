import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  private createFav = 'http://localhost:8080/api/api/favoritos';
  private getAllFav = 'http://localhost:8080/api/api/favoritos';
  private scrappingUrl = 'http://localhost:8080/api/fact/fact';
  private apiKey = '82f8feeed4msh30faf4ba5564de0p1791cajsnbb7aaa2432e0';
  private apiUrl = 'https://programming-memes-images.p.rapidapi.com/v1/memes';

  constructor(private http: HttpClient) { }

  //Tomar memes
  getMemes(): Observable<any> {
    const headers = new HttpHeaders({
      "X-Rapidapi-Key": "82f8feeed4msh30faf4ba5564de0p1791cajsnbb7aaa2432e0",
      "X-Rapidapi-Host": "programming-memes-images.p.rapidapi.com"
    });
    return this.http.get(this.apiUrl, { headers })
      .pipe(
        catchError((error: HttpErrorResponse) => {
          return throwError(error.message || 'Server error');
        })
      );
  }

  //Tomar facts
  getFact(): Observable<any> {
    return this.http.get(this.scrappingUrl);
  }

  //Crear un grupo de favoritos
  createFavoriteGroup(fav:any): Observable<any> {
    return this.http.post(this.createFav,fav);
  }

  //Añadir un meme a favoritos
  //private addFav = 'http://localhost:8080/api/api/favoritos/{{NUMERO}}/memes';
  addFavorite(meme: any, id: any): Observable<any> {
    var addFav = `http://localhost:8080/api/api/${id}/favoritos`;
    return this.http.post(addFav, meme);
  }

  //Quitar un favorito
  deleteFavorite(id: any): Observable<any> {
    var deleteFav = `http://localhost:8080/api/api/favoritos/${id}`;
    return this.http.delete(deleteFav);
  }

  //Tomar todos los memes en favoritos
  getAllFavorites(): Observable<any> {
    return this.http.get(this.getAllFav);
  }

  getFavoriteById(id: any): Observable<any> {
    //"/favoritos/{id}"
    var ruta = `http://localhost:8080/api/api/favoritos/${id}`;
    return this.http.get(ruta);
  }

  getMemesByFavoritoId(favId: number): Observable<any> {
    var getRuta = `http://localhost:8080/api/api/favoritos/${favId}/memes`;
    return this.http.get(getRuta);
  }
}
