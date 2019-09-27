import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  Indiastate = [
    'Rajasthan',
    'UP',
    'Mp',
    'Delhi',
    'Goa',
    'Gurjat',
    'Punjab'
  ];
  Ausstate = [

    'New South Wales',
    'Queensland',
    'South Australia',
    'Tasmania'
  ];
  Slstate = [
    'Kandy',
    'Galle',
    'Kegalle',
    'Mannar'
  ];
}
