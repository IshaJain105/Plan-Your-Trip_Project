import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingService } from '../services/booking.service';
import { PackagesService } from '../services/packages.service';

@Component({
  selector: 'app-user-bookings',
  templateUrl: './user-bookings.component.html',
  styleUrls: ['./user-bookings.component.css']
})
export class UserBookingsComponent implements OnInit {
  bookings:any=[]
  packages:any=[]
  subtotal:any=[]
  total:number=0;
  finalTotal:number;
  searchText:any;

  constructor(private packageService:PackagesService,private bookingService:BookingService,private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.bookingService.fetchAllBookingById(this.route.snapshot.params['id']).subscribe({
      next:(value)=>{
        
        this.bookings = value;
        for(let i=0;i<this.bookings.length;i++){
          this.packageService.fetchPackageDetail(this.bookings[i].packageId).subscribe({
            next:(value)=>{
              this.packages[i] = value.package
              for (let index = 0; index < this.packages[i].activities.length; index++) {
                this.total += this.packages[i].activities[index].activityPrice ;
                this.finalTotal=Math.ceil((this.total)* 100) /100;
                this.subtotal[i]=this.finalTotal;
                this.finalTotal=0
                this.total=0
              }
               
            }
          });

        }

      }
    });
  }

}
