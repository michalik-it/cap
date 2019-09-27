import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {PanelModule} from 'primeng/components/panel/panel';
import {ButtonModule} from 'primeng/components/button/button';
import {AccordionModule} from 'primeng/components/accordion/accordion';
import {TableModule} from 'primeng/table';
import {BooksComponent} from './components/books/books.component';
import {HttpClientModule} from '@angular/common/http';

@NgModule({

  declarations: [
    AppComponent,
    BooksComponent
  ],

  imports: [
    BrowserModule,
    BrowserAnimationsModule, FormsModule,
    AppRoutingModule,
    AccordionModule,
    PanelModule,
    ButtonModule,
    TableModule,
    HttpClientModule
  ],

  providers: [],

  bootstrap: [AppComponent]

})

export class AppModule {
}

