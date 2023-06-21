import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-meme-detail',
  templateUrl: './meme-detail.component.html',
  styleUrls: ['./meme-detail.component.css']
})
export class MemeDetailComponent implements OnInit{
  imgUrl: string = '';

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.decodeURL();
  }
  decodeURL(): void {
    const imgUrlParam = this.route.snapshot.paramMap.get('url');
    console.log(imgUrlParam);
    if (imgUrlParam !== null) {
      this.imgUrl = decodeURIComponent(imgUrlParam);
    }
  }
}
