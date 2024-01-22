import { Component, OnInit, inject } from '@angular/core';
import { PostService } from '../services/post.service';

@Component({
  selector: 'app-post',
  standalone: true,
  imports: [],
  templateUrl: './post.component.html',
  styleUrl: './post.component.scss'
})
export class PostComponent implements OnInit{

  private postService = inject(PostService);
  posts: any=[];

  ngOnInit(): void {
    this.loadPosts();
    }


  loadPosts(){
    this.postService.fetchFakeData().subscribe((posts:any) =>{
      console.log(posts);
      this.posts=posts;
    })
  }

}
