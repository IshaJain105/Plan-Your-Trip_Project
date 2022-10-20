import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AreaOfInterestService } from '../services/areaOfInterest.service';

@Component({
  selector: 'app-add-interest',
  templateUrl: './add-interest.component.html',
  styleUrls: ['./add-interest.component.css']
})
export class AddInterestComponent implements OnInit {
  interests:any=[]
  addInterestForm:any
  searchText:any;
  constructor(private interestService:AreaOfInterestService,private router:Router) { }

  ngOnInit(): void {
    this.getInterests();
    this.addInterestForm = new FormGroup({
      name:new FormControl(null,[Validators.required]),
    })
  }
  private getInterests(){
    this.interestService.fetchAllAreaOfInterest().subscribe(data => {
      this.interests=data;
    });
  } 
  onSubmit():void{
    this.interestService.addInterest(this.addInterestForm.value)
    this.router.navigate(['/addInterest'])
    this.addInterestForm.reset()
  }

}