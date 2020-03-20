import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import { Account } from "./account.model";

@Injectable()
export class AccountService {

  constructor(private http: HttpClient) {

  }

  get() {
    return this.http.get('/api/test/');
  }

  check(id: number) {
    return this.http.get(`/api/test/check/${id}`);
  }

  create(account: Account) {
    return this.http.post('/api/test/create', account);
  }

  deposit(account: Account) {
    return this.http.post('/api/test/deposit', account);
  }

  withdraw(account: Account) {
    return this.http.post('/api/test/withdraw', account);
  }

}
