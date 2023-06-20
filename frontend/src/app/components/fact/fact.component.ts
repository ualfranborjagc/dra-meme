import { Component, OnInit } from '@angular/core';
import { ApiServiceService } from '../../api-service.service';

@Component({
  selector: 'app-fact',
  templateUrl: './fact.component.html',
  styleUrls: ['./fact.component.css']
})
export class FactComponent implements OnInit {
  facts: any[] = [];

  constructor(private apiService: ApiServiceService) {}

  ngOnInit(): void {
    this.getFact();
  }

  getFact() {
    this.apiService.getFact().subscribe(
      (response: any) => {
        this.facts = response;
        console.log(this.facts);
      },
      (error: any) => {
        console.log(error);
      }
    );
  }
}
