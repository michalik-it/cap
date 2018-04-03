import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class FactService {
  public API = '//localhost:8080/api';
  public FACT_API = this.API + '/facts';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.FACT_API);
  }

  get(id: string, botId: string) {
    return this.http.get(this.FACT_API + '/' + botId + '-' + id);
  }

  save(fact: any): Observable<any> {
    let result: Observable<Object>;
    if (fact['href']) {
      console.log('Before safe');
      console.log(fact);
      result = this.http.put(fact.href, fact);
    } else {
      result = this.http.post(this.FACT_API, fact);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}
