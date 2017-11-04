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
