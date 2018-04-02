import {Component, OnInit} from '@angular/core';
import {FactService} from '../shared/fact/fact.service';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-fact-list',
  templateUrl: './fact-list.component.html',
  styleUrls: ['./fact-list.component.css']
})
export class FactListComponent implements OnInit {
  displayedColumns = ['id.id', 'id.botId', 'name', 'content'];
  facts: Array<any>;
  dataSource: MatTableDataSource<any>;

  constructor(private factService: FactService) {
  }

  ngOnInit() {
    this.factService.getAll().subscribe(data => {
      this.facts = data._embedded.facts;
      this.dataSource = new MatTableDataSource(this.facts);
      console.log(this.dataSource);
    });
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
  }

}

