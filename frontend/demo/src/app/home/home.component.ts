import { PostComponent } from '../post/post.component';
import { Component, OnInit, inject } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [PostComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {

  constructor(){}

  ngOnInit(){
  }
}
