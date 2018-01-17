# Charging station demo service
Demo project used during series of application development workshops.
Includes topics related to:
* front-end development
* back-end development (to-be-added)
* deployment and other topics (to-be-added)

# Get started with front-end
To starting project development:
* install actual version of [Node.js](https://www.nodejs.org/)
* install Angular CLI `npm install -g @angular/cli`
* clone repository `git clone https://github.com/Vitaljok/charging-station-demo.git`
* move to front-end directory `cd charging-station-demo/front-end`
* install dependencies `npm install`
* start local development server `ng serve`

# Get started with back-end
To start project back-end development:
* install [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/) or other IDE of your choice
* clone repository `git clone https://github.com/Vitaljok/charging-station-demo.git`
* import Gradle project from `./web-api/` folder

Use `git pull` to get fresh updates from repository.

# Workshop steps

Workshop progress is saved in form of separate commits with tags `step-NNN`.
In order to move to specific step use
`git checkout tags/step-NNN` where `NNN` is zero padded number of desired step, for example `git checkout tags/step-004`.

Run `npm install` if any dependencies are changed when switching steps.

## Step 0 - front end project initialization
Front-end project is initialized using Angular CLI utility `ng new front-end` and is committed "as-is".

## Step 1 - initial structure of application page
Adding basic application page structure: navigation *header* with links to List and Tree views, page *content* section and *footer*.

## Step 2 - Bootstrap library and styling
* Added [Bootstrap](http://getbootstrap.com/) library `npm install --save bootstrap@4.0.0-beta.2`
* Included Bootstrap styles into compilation configuration `.angular-cli.json`
* Styled application page

## Step 3 - Using standalone charging station variables on page
* Added `ChargingStation` class
* Initialized two distinct variables
* Used initialized variables in the template

## Step 4 - Using array of charging stations on page
* Changed charging stations variables to array
* Used `ngFor` directive in template
* Adding conditional styling via `ngClass` directive

## Step 5 - Refactoring internal component variables to data service
* Created service using `ng generate service Data`
* Moved `stations` array from component to service
* Moved `ChargingStation` class to separate `domain.ts` file and used imports
* Added fake processing delay to service method
* Defined `DataService` in module providers to get *dependency injection* work
* Injected `DataService` into component's constructor and used it during `OnInit` life-cycle hook.

## Step 6 - Moving to asynchronous service processing using Observables
* Changed service method to return `Observable`
* Used subscription approach to get data asynchronously

## Step 7 - Creating separate component for list of charging stations
* Created new component using `ng generate component StationList` (it also adds new component to `app.module.ts` declarations)
* Moved list design to `station-list.component.html`
* Moved data fetching to `station-list.component.ts`
* Used new `<app-station-list>` tag in `app.component.html`

## Step 8 - Creating new component for tree of charging stations
* Created new component using `ng generate component StationTree`
* Used list component as base for design and data fetching routines
* Added new `<app-station-tree>` tag in `app.component.html`

## Step 9 - Adding routing between views
* Defined application routes in `app.module.ts`
* Used `<router-outlet>` in application template
* Updated navigation links with `routerLink` directive
* Styled active navigation link with `routerLinkActive` directive

## Step 10 - Fetching data from back-end API
* Adding `HttpModule` to `app.module.ts`
* Changing `DataService` implementation to use provided back-end API
* (alternative)
  * install [JSON server](https://github.com/typicode/json-server) using `npm install -g json-server`
  * run own fake back-end API `json-server db.json`

## Step 11 - Creating new component for station details
* Created new component using `ng generate component StationDetails`
* Added parametrized route in `app.module.ts`
* Retrieving provided route parameter via `ActivatedRoute`
* Adding `routerLink` to station list and tree components

## Step 12 - Fetching station details from back-end API
* Adding API call to `DataService`
* Created `proxy.conf.json` configuration
* Changed startup script in `package.json`

## Step 13 - Details view design
* Form structure via `form-group`
* Various input elements
* Dynamic city dropdown list

## Step 14 - Data binding to details form
* Added `FormsModule` to `app.module.ts`
* Changing `ChargingStation` class to allow parameterless constructor
* Bi-directional data binding via `[(ngModel)]`
* Button event binding via `(click)`

## Step 15 - Providing data modifications to back-end
* Added methods to `DataService`
* Calling service methods from the component
* Implemented deleting functionality

## Step 16 - Functionality for creating new stations
* Defining new route in `app.module.ts`
* Adding methods to `DataService`
* Component initialization changes
* Adding controls to design

## Step 17 - Form validation
* Input element validation via styles
* Whole form validation via in-line variable

## Step 18 - Creating back-end project
* Created new Gradle + Java project via wizard
* Added `.gitignore` file

## Step 19 - Creating plain Java application
* `Application` class with `main` method
* `PaymentService` class with calculations
* Unit tests for service

## Step 20 - Moving application to Spring container
* Adding Spring Bood dependencies
* Refactoring `Application` class
* Adding unit tests for application

## Step 21 - Migrating to Web application
* Created `PaymentController`
* Request mapping and response
* Refactoring `Application` class

## Step 22 - REST controller and parameters
* Created `StationBean` class
* Created `StationController`

## Step 23 - Refactoring
* Added Lombok dependency
* Moved classes to `stations` package

## Step 24 - Database setup
* Added Spring JPA dependency
* Added H2 embedded database
* Custom configuration in `application.yml`
* Simple `Station` entity

## Step 25 - Query database for REST requests
* Created `StationRepository`
* Created `StationService`
* Initialized database
* Modified `StationController`
