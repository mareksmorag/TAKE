import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {
  curDate!: Date
  constructor() {
    this.curDate = new Date()
  }

  ngOnInit(): void {
  }

}
