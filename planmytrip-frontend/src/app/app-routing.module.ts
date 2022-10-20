import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ExploreComponent } from './explore/explore.component';
import { HomeComponent } from './home/home.component';
import { HomepageComponent } from './homepage/homepage.component';
import { AuthGuard } from './services/auth-guard.service';
import { PackageResolver } from './resolvers/PackageResolver.resolve';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { ActivityResolver } from './resolvers/ActivityResolver.resolve';
import { AreaOfInterestResolver } from './resolvers/AreaOfInterestResolver.resolve';
import { PackageComponent } from './package/package.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { AdminHomepageComponent } from './admin-homepage/admin-homepage.component';
import { AddComponent } from './add/add.component';
import { ShowAllComponent } from './show-all/show-all.component';
import { PackageDetailResolver } from './resolvers/PackageDetailResolver.resolve';
import { UpdateComponent } from './update/update.component';
import { AddActivityComponent } from './add-activity/add-activity.component';
import { AddInterestComponent } from './add-interest/add-interest.component';
import { TypeResolver } from './resolvers/TypeResolver.resolve';
import { AdminPackageComponent } from './admin-package/admin-package.component';
import { ThankyouComponent } from './thankyou/thankyou.component';
import { UserBookingsComponent } from './user-bookings/user-bookings.component';
import { AllBookingComponent } from './all-booking/all-booking.component';
const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: UserLoginComponent},
  {path: 'register', component: UserRegisterComponent},
  {path: 'package/:id',canActivate:[AuthGuard] , resolve:{package:PackageDetailResolver} ,component: PackageComponent},
  {path: 'adminPackage/:id', resolve:{package:PackageDetailResolver} ,component: AdminPackageComponent},
  {path: 'homepage', canActivate:[AuthGuard] ,component: HomepageComponent},
  {path: 'explore',canActivate:[AuthGuard] , resolve:{packages:PackageResolver,activities:ActivityResolver,areaOfInterest:AreaOfInterestResolver ,typeResolver:TypeResolver},
  component: ExploreComponent},
  {path: 'checkout/:id',canActivate:[AuthGuard] , component: CheckoutComponent},
  {path: 'admin_homepage',canActivate:[AuthGuard] , component: AdminHomepageComponent},
  {path: 'add' ,canActivate:[AuthGuard] ,resolve:{activities:ActivityResolver,areaOfInterest:AreaOfInterestResolver ,typeResolver:TypeResolver}, component: AddComponent},
  {path: 'update/:id',canActivate:[AuthGuard] , resolve:{package:PackageDetailResolver} ,component: UpdateComponent},
  {path: 'addActivity',canActivate:[AuthGuard] , component: AddActivityComponent},
  {path: 'addInterest',canActivate:[AuthGuard] , component: AddInterestComponent},
  {path: 'showAll',canActivate:[AuthGuard] , component: ShowAllComponent},
  {path: 'thankyou/:id' ,canActivate:[AuthGuard] , component: ThankyouComponent},
  {path: 'userBooking/:id' ,canActivate:[AuthGuard] , component: UserBookingsComponent},
  {path: 'allBooking' , canActivate:[AuthGuard] ,component: AllBookingComponent},


  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{onSameUrlNavigation:'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
