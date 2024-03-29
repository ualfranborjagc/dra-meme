import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MemeDetailComponent } from './meme-detail.component';

describe('MemeDetailComponent', () => {
  let component: MemeDetailComponent;
  let fixture: ComponentFixture<MemeDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MemeDetailComponent]
    });
    fixture = TestBed.createComponent(MemeDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
