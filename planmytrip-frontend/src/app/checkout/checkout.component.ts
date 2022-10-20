import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { BookingService } from '../services/booking.service';
import { PackagesService } from '../services/packages.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  package:any=[]
  addPackageForm:any
  addBookingForm:any
  total:number=0;
  subtotal:number=0;
  finalTotal:number;
  tax:number;
  finalPrice:number;
  userDetails:any;
  constructor(private packageService:PackagesService,private bookingService:BookingService,private route:ActivatedRoute,private authService:AuthService) { }

  ngOnInit(): void {
    this.addPackageForm = new FormGroup({
      totalPeople:new FormControl(1,[Validators.min(1)]),
    })
    this.addBookingForm=new FormGroup({
      userId: new FormControl(null),
      packageId: new FormControl(null),
      totalPeople:new FormControl(this.addPackageForm.get('totalPeople').value),
      totalPrice:new FormControl(this.finalPrice,[Validators.required]),
      name:new FormControl(null,[Validators.required]),
      phoneNumber:new FormControl(null,[Validators.required ,Validators.maxLength(10)]),
      email:new FormControl(null,[Validators.required,Validators.email]),
      date:new FormControl(null,[Validators.required]),
      address:new FormControl(null,[Validators.required]),
      city:new FormControl(null,[Validators.required]),
      state:new FormControl(null,[Validators.required]),
      zip:new FormControl(null,[Validators.required, Validators.maxLength(6)])
    })
    this.userDetails=this.authService.userDetails;
    this.addBookingForm.get('email').setValue(this.userDetails.user.email);
    this.addBookingForm.get('name').setValue(this.userDetails.user.name);
    this.addBookingForm.get('userId').setValue(this.userDetails.user.id);
    

    this.packageService.fetchPackageDetail(this.route.snapshot.params['id']).subscribe({
      next:(value)=>{
        this.package = value
        for (let index = 0; index < this.package.package.activities.length; index++) {
          this.total += this.package.package.activities[index].activityPrice ;
          this.finalTotal=Math.ceil((this.total)* 100) /100;
        }
          
          this.subtotal =  Math.ceil((this.finalTotal+ this.package.package.price+95.6+25.6) * 100) / 100;

          this.tax=(this.subtotal*12)/100;
        this.addBookingForm.get('packageId').setValue(this.package.package.id);
        
      }
    });
  }
  onSubmit():void{
    this.finalPrice=Math.ceil(((this.subtotal+this.tax)*this.addPackageForm.value.totalPeople)*100)/100;
    this.addBookingForm.get('totalPrice').setValue(this.finalPrice);
    this.addBookingForm.get('totalPeople').setValue(this.addPackageForm.value.totalPeople);

  }
  onSubmitBooking():void{
    console.log(this.addBookingForm.value)
    this.bookingService.addBooking(this.addBookingForm.value)
    this.addBookingForm.reset()
  }

  
}
