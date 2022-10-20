import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PackagesService } from '../services/packages.service';

@Component({
  selector: 'app-admin-package',
  templateUrl: './admin-package.component.html',
  styleUrls: ['./admin-package.component.css']
})
export class AdminPackageComponent implements OnInit {
  package:any=[]
  total:number=0
  finalTotal:number;
  constructor(private packageService:PackagesService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.packageService.fetchPackageDetail(this.route.snapshot.params['id']).subscribe({
      next:(value)=>{
        this.package = value.package
        
        for (let index = 0; index < this.package.activities.length; index++) {
          this.total += this.package.activities[index].activityPrice ;
          this.finalTotal=Math.ceil((this.total)* 100) /100;
        }
        
      }
    });
  }
  
  updatePackage(id:any){
    this.router.navigate(['/update',id])
  }

}
