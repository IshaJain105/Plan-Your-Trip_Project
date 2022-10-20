import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Booking } from '../model/booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  booking: any = [];
  bookingDetail:any;
  constructor(private http: HttpClient, private router:Router) { }
  addBooking(booking:Booking){
    this.http.post('http://localhost:8005/booking/addBooking', booking)
    .subscribe({
      next:(v)=>{
        this.bookingDetail = v;
        console.log(this.bookingDetail)
        this.router.navigate(['/thankyou',this.bookingDetail.booking.id])
      }, error: (e) => {
        console.log("errors")
        console.log(e)
      }
    })
  }
  fetchBookingDetail(id:any):Observable<any>{
    return this.http.get<any>(`http://localhost:8005/booking/booking-detail/${id}`);
  }
  fetchAllBookingById(id:any):Observable<any>{
    return this.http.get<any>(`http://localhost:8005/booking/fetchAllBookingById/${id}`);
  }
  fetchAllBookings(): Observable<any> {
    return this.http.get('http://localhost:8005/booking/get-all-bookings');
  }
  
}
