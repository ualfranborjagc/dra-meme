import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  private getAllFav = 'http://localhost:8080/api/favoritos';
  private scrappingUrl = 'http://localhost:8080/api/fact/fact';
  private apiKey = '82f8feeed4msh30faf4ba5564de0p1791cajsnbb7aaa2432e0';
  private apiUrl = 'https://programming-memes-images.p.rapidapi.com/v1/memes';

  constructor(private http: HttpClient) { }

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

  getFact(): Observable<any> {
    return this.http.get(this.scrappingUrl);
  }
}
