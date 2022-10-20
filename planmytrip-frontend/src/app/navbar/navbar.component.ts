import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  userDetails:any;
  constructor(private authService:AuthService,private router:Router) { }

  ngOnInit(): void {
    
  }

  isLoggedIn():boolean{
    this.userDetails= this.authService.userDetails;
    return this.authService.isLoggedIn;
  }
  isAdmin():boolean{
    if(this.userDetails.user.role=='ROLE_ADMIN'){
      return true;
    }
    return false;
  }
  onLogout():void{
    this.authService.isLoggedIn = false;
  }
  onClickUser(id:any):void{
    this.router.navigate(['/userBooking',id]);
  }
  onClickAdmin():void{
    this.router.navigate(['/allBooking']);
  }


}
