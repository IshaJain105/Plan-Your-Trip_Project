import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPackageComponent } from './admin-package.component';

describe('AdminPackageComponent', () => {
  let component: AdminPackageComponent;
  let fixture: ComponentFixture<AdminPackageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminPackageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminPackageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
