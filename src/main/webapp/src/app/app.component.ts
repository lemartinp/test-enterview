import { Component } from '@angular/core';
import {AccountService} from "./account.service";
import {Account} from "./account.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'webapp';
  idNumber: number;
  name: string;
  value: number;

  constructor(private accountService: AccountService) {}

  ngOnInit(){}

  create(){
    let account: Account = new Account(this.idNumber,this.name, this.value);
    this.accountService.create(account).subscribe(response => {
      console.log('Response for account creation: ', response);
    });
  }
  check(){
    this.accountService.check(this.idNumber).subscribe(response => {
      console.log('Response for checking account: ', response);
      this.value = response["value"];
    });
  }
  withdraw(){
    let account: Account = new Account(this.idNumber,this.name, this.value);
    this.accountService.withdraw(account).subscribe(response => {
      console.log('Response for withdrawing account: ', response);
      this.value = response["value"];
    });
  }
  deposit(){
    let account: Account = new Account(this.idNumber,this.name, this.value);
    this.accountService.deposit(account).subscribe(response => {
      console.log('Response for making deposit account: ', response);
      this.value = response["value"];
    });
  }
}
