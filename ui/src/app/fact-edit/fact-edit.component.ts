import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from 'rxjs/Subscription';
import {ActivatedRoute, Router} from '@angular/router';
import {FactService} from '../shared/fact/fact.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-fact-edit',
  templateUrl: './fact-edit.component.html',
  styleUrls: ['./fact-edit.component.css']
})
export class FactEditComponent implements OnInit, OnDestroy {

  fact: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private factService: FactService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      const botId = params['botId'];
      if (id) {
        this.factService.get(id, botId).subscribe((fact: any) => {
          console.log(fact);
          if (fact) {
            this.fact = fact;
            this.fact.href = fact._links.self.href;
          } else {
            console.log(`Fact with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/fact-list']);
  }

  save(form: NgForm) {
    this.factService.save(form).subscribe(
      result => {
        this.gotoList();
      },
      error => {
        console.error(error);
      })
    ;
  }

  remove(href) {
    this.factService.remove(href).subscribe(
      result => {
        this.gotoList();
      },
      error => {
        console.error(error);
      });
  }
}
