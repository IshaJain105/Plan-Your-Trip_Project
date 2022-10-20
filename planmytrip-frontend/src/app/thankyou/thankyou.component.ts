import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingService } from '../services/booking.service';
import { PackagesService } from '../services/packages.service';

@Component({
  selector: 'app-thankyou',
  templateUrl: './thankyou.component.html',
  styleUrls: ['./thankyou.component.css']
})
export class ThankyouComponent implements OnInit {
  booking:any=[]
  package:any=[]
  total:number=0;
  subtotal:number=0;
  finalTotal:number;
  tax:number;
  finalPrice:number;
  constructor(private packageService:PackagesService,private bookingService:BookingService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.bookingService.fetchBookingDetail(this.route.snapshot.params['id']).subscribe({
      next:(value)=>{
        this.booking = value.booking
        console.log(this.booking)
        this.packageService.fetchPackageDetail(this.booking.packageId).subscribe({
          next:(value)=>{
            this.package = value.package
            for (let index = 0; index < this.package.activities.length; index++) {
              this.total += this.package.activities[index].activityPrice ;
              this.finalTotal=Math.ceil((this.total)* 100) /100;
            }
              
              this.subtotal =  Math.ceil((this.finalTotal+ this.package.price+95.6+25.6) * 100) / 100;
              this.tax= Math.ceil((this.subtotal*12)/100* 100) / 100;
            
          }
        });
      }
    });
  }
  

}
