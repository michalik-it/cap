import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule} from '@angular/material';
import {MatTableModule} from '@angular/material/table';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FactService} from './shared/fact/fact.service';
import {FactListComponent} from './fact-list/fact-list.component';
import { FactEditComponent } from './fact-edit/fact-edit.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/fact-list', pathMatch: 'full' },
  {
    path: 'fact-list',
    component: FactListComponent
  },
  {
    path: 'fact-add',
    component: FactEditComponent
  },
  {
    path: 'fact-edit/:botId/:id',
    component: FactEditComponent
  }
];


@NgModule({
  declarations: [
    AppComponent,
    FactListComponent,
    FactEditComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatTableModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [FactService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
