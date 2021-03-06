import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProjectghSharedModule } from 'app/shared';
import {
    BatchQuantityComponent,
    BatchQuantityDetailComponent,
    BatchQuantityUpdateComponent,
    BatchQuantityDeletePopupComponent,
    BatchQuantityDeleteDialogComponent,
    batchQuantityRoute,
    batchQuantityPopupRoute
} from './';

const ENTITY_STATES = [...batchQuantityRoute, ...batchQuantityPopupRoute];

@NgModule({
    imports: [ProjectghSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        BatchQuantityComponent,
        BatchQuantityDetailComponent,
        BatchQuantityUpdateComponent,
        BatchQuantityDeleteDialogComponent,
        BatchQuantityDeletePopupComponent
    ],
    entryComponents: [
        BatchQuantityComponent,
        BatchQuantityUpdateComponent,
        BatchQuantityDeleteDialogComponent,
        BatchQuantityDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProjectghBatchQuantityModule {}
