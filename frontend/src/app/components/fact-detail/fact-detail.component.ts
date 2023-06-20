import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-fact-detail',
  templateUrl: './fact-detail.component.html',
  styleUrls: ['./fact-detail.component.css']
})
export class FactDetailComponent {
  text: string = '';
  constructor(private route: ActivatedRoute) { }
  ngOnInit() {
    this.decodeURL();
  }
  decodeURL(): void {
    const factUrlParam = this.route.snapshot.paramMap.get('fact');
    console.log(factUrlParam);
    if (factUrlParam !== null) {
      this.text = decodeURIComponent(factUrlParam);
    }
  }
}
