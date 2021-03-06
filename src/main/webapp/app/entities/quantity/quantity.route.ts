import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Quantity } from 'app/shared/model/quantity.model';
import { QuantityService } from './quantity.service';
import { QuantityComponent } from './quantity.component';
import { QuantityDetailComponent } from './quantity-detail.component';
import { QuantityUpdateComponent } from './quantity-update.component';
import { QuantityDeletePopupComponent } from './quantity-delete-dialog.component';
import { IQuantity } from 'app/shared/model/quantity.model';

@Injectable({ providedIn: 'root' })
export class QuantityResolve implements Resolve<IQuantity> {
    constructor(private service: QuantityService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((quantity: HttpResponse<Quantity>) => quantity.body));
        }
        return of(new Quantity());
    }
}

export const quantityRoute: Routes = [
    {
        path: 'quantity',
        component: QuantityComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'projectghApp.quantity.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'quantity/:id/view',
        component: QuantityDetailComponent,
        resolve: {
            quantity: QuantityResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'projectghApp.quantity.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'quantity/new',
        component: QuantityUpdateComponent,
        resolve: {
            quantity: QuantityResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'projectghApp.quantity.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'quantity/:id/edit',
        component: QuantityUpdateComponent,
        resolve: {
            quantity: QuantityResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'projectghApp.quantity.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const quantityPopupRoute: Routes = [
    {
        path: 'quantity/:id/delete',
        component: QuantityDeletePopupComponent,
        resolve: {
            quantity: QuantityResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'projectghApp.quantity.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
