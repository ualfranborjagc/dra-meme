import { Component, OnInit } from '@angular/core';
import { ApiServiceService } from '../../api-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-meme',
  templateUrl: './meme.component.html',
  styleUrls: ['./meme.component.css'],
})
export class MemeComponent implements OnInit {
  memes: any[] = [];
  popup: boolean = false;
  opciones: any[] = [];
  filtro: any[] = [];
  seleccion: string = '';
  idFav:any;
  imgMeme: string = '';
  constructor(private apiService: ApiServiceService) {}
  ngOnInit(): void {
    this.getMeme();
    this.getAllFavorites();
  }

  opcionesSel() {
    this.filtro = this.opciones.filter((opcion) =>
      opcion.toLowerCase().startsWith(this.seleccion.toLowerCase())
    );
    console.log(this.filtro);
  }
  actualizarEntrada(opcion: string, id: any) {
    this.seleccion = opcion;
    this.idFav = id;
    this.filtro = [];
  }

  popupMeme(imgMeme: string) {
    this.imgMeme = imgMeme;
    this.popup = true;
  }

  closepopupMeme() {
    this.popup = false;
  }

  getMeme() {
    this.apiService.getMemes().subscribe(
      (data) => {
        this.memes = data;
        console.log(this.memes);
      },
      (error) => {
        console.log(error);
      }
    );
  }
  addFavorite() {
    var meme = {
      imageUrl: this.imgMeme,
    };
    this.apiService.addFavorite(meme, this.idFav).subscribe(
      (response: any) => {
        console.log(response);
      },
      (error: any) => {
        console.log(error);
      }
    );
    this.idFav = '';
  }
  //Mostrar favoritos
  getAllFavorites() {
    this.apiService.getAllFavorites().subscribe(
      (response: any) => {
        this.opciones = response;
        console.log(this.opciones);
      },
      (error: any) => {
        console.log(error);
      }
    );
  }
}
