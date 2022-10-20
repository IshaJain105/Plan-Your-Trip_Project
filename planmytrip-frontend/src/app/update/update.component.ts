import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl,Validators} from '@angular/forms'
import { ActivatedRoute, Router } from '@angular/router';
import { Package } from '../model/package';
import { ActivityService } from '../services/activities.service';
import { AreaOfInterestService } from '../services/areaOfInterest.service';
import { PackagesService } from '../services/packages.service';
import { TypeService } from '../services/type.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  
  id:number
  updatedActivityList:any=[]
  updatedAreaOfInterestList:any=[]
  updatedTypesList:any=[]
  package1:any={}


  constructor(
              private packageService:PackagesService,
              private activityService:ActivityService, 
              private typeService:TypeService, 
              private areaOfInterestService:AreaOfInterestService,
              private route:ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.packageService.fetchPackageDetail(this.id).subscribe(value=>{
        this.package1 = value.package;
    });
    
    this.typeService.getAllTypes().subscribe(value=>{
        this.updatedTypesList = value
    })
    this.activityService.getAllActivities().subscribe(value=>{
        this.updatedActivityList = value
    })

    this.areaOfInterestService.fetchAllAreaOfInterest().subscribe(value=>{
        this.updatedAreaOfInterestList = value
    })
    
  }
  onSubmit():void{
    this.packageService.updatePackage(this.package1).subscribe(data=>{
      this.router.navigate(['/showAll'])
    })
  }
  
}
