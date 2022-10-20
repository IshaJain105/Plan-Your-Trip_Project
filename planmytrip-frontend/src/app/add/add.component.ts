import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import {FormGroup,FormControl,Validators} from '@angular/forms'
import { Activity } from '../model/activity';
import { ActivityService } from '../services/activities.service';
import { AreaOfInterestService } from '../services/areaOfInterest.service';
import { AuthService } from '../services/auth.service';
import { PackagesService } from '../services/packages.service';
import { TypeService } from '../services/type.service';
@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  addPackageForm:any
  activityList:any=[]
  areaOfInterestList:any=[]
  typesList:any=[]
  
  constructor(private packageService:PackagesService,
              private activityService:ActivityService, 
              private typeService:TypeService, 
              private areaOfInterestService:AreaOfInterestService) { }

  ngOnInit(): void {
    this.addPackageForm = new FormGroup({
      cityName:new FormControl(null,[Validators.required]),
      price:new FormControl(null,[Validators.required]),
      imageUrl:new FormControl(null,[Validators.required]),
      activities:new FormControl(null),
      areaOfInterest:new FormControl(null),
      type:new FormControl(null),
    })
    this.typeService.getAllTypes().subscribe({
      next:(value)=>{
        this.typesList = value
      }
    })
    this.activityService.getAllActivities().subscribe({
      next:(value)=>{
        this.activityList = value

      }
    })

    this.areaOfInterestService.fetchAllAreaOfInterest().subscribe({
      next:(value)=>{
        this.areaOfInterestList = value
      }
    })
    
  }
  
  onSubmit():void{
    console.log(this.addPackageForm.value)
    this.packageService.addPackage(this.addPackageForm.value)
    this.addPackageForm.reset()
  }


}
