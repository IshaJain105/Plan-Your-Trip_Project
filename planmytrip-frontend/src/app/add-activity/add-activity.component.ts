import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl,Validators} from '@angular/forms'
import { Router } from '@angular/router';
import { ActivityService } from '../services/activities.service';


@Component({
  selector: 'app-add-activity',
  templateUrl: './add-activity.component.html',
  styleUrls: ['./add-activity.component.css']
})
export class AddActivityComponent implements OnInit {
  activities:any=[]
  addActivityForm:any
  searchText:any;
  constructor(private activityService:ActivityService, private router:Router) { }

  ngOnInit(): void {
    this.getActivities();
    this.addActivityForm = new FormGroup({
      activityName:new FormControl(null,[Validators.required]),
      activityPrice:new FormControl(null,[Validators.required]),
    })
  }
  private getActivities(){
    this.activityService.getAllActivities().subscribe(data => {
      this.activities=data;
    });
  } 
  onSubmit():void{
    this.activityService.addActivity(this.addActivityForm.value)
    this.router.navigate(['/addActivity'])
    this.addActivityForm.reset()
  }

}
