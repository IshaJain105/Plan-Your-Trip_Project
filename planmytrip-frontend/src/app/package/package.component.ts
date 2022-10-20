import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PackagesService } from '../services/packages.service';

@Component({
  selector: 'app-package',
  templateUrl: './package.component.html',
  styleUrls: ['./package.component.css']
})
export class PackageComponent implements OnInit {
  package:any=[]
  total:number=0;
  subtotal:number=0;
  finalTotal:number;


  constructor(private packageService:PackagesService,private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.packageService.fetchPackageDetail(this.route.snapshot.params['id']).subscribe({
      next:(value)=>{
        this.package = value.package
        for (let index = 0; index < this.package.activities.length; index++) {
          this.total += this.package.activities[index].activityPrice ;
          this.finalTotal=Math.ceil((this.total)* 100) /100;
        }
          
          this.subtotal =  Math.ceil((this.finalTotal+ this.package.price+95.6+25.6) * 100) / 100;
        
      }
    });
  }
  onClickPackage(id:any):void{
    this.router.navigate(['/checkout',id]);
  }

}
