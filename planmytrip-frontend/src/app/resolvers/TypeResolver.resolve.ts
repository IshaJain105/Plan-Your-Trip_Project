import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from "@angular/router";
import { Observable } from "rxjs";
import { TypeService } from "../services/type.service";

@Injectable({providedIn:'root'})
export class TypeResolver implements Resolve<any>{

    constructor(private typeService:TypeService){}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot):Observable<any> {
        return this.typeService.getAllTypes();
    }
    
}