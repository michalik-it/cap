import {Component, OnInit} from '@angular/core';
import {Book, BookService} from '../../services/book/book.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss']
})
export class BooksComponent implements OnInit {

  books: Book[];

  constructor(private bookService: BookService) {
  }

  ngOnInit() {
    console.log('init')
    this.bookService.getBooks()
      .then(books => this.books = books);
  }

  onRowEditInit(book: Book) {
    console.log('Row edit initialized');
  }

  onRowEditSave(book: Book) {
    console.log('Row edit saved');
  }

  onRowEditCancel(book: Book, index: number) {
    console.log('Row edit cancelled');
  }

}
