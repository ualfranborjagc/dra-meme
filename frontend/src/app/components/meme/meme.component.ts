import { Component, OnInit } from '@angular/core';
import { ApiServiceService } from '../../api-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-meme',
  templateUrl: './meme.component.html',
  styleUrls: ['./meme.component.css'],
})
export class MemeComponent implements OnInit {
  liked = false;
  memes: any[] = [];
  img: string = 'https://i.imgflip.com/1ur9b0.jpg';
  constructor(private apiService: ApiServiceService) {}
  ngOnInit(): void {
    //this.getMeme();
  }
  toggleLike() {
    this.liked = !this.liked;
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
}
