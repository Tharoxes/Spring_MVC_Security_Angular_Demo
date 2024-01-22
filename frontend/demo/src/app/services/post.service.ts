import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';

const JSON_URL = 'https://jsonplaceholder.typicode.com/posts';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private http = inject(HttpClient);

  constructor() { }

  fetchFakeData() {
    return this.http.get(JSON_URL);
  }
}
