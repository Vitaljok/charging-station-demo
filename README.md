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
``git checkout tags/step-NNN`` where `NNN` is zero padded number of desired step.

Run `npm install` if any dependencies are changed when switching steps.

## Step 0 - front end project initialization
Front-end project is initialized using Angular CLI utility `ng new front-end` and is committed "as-is".

## Step 1 - initial structure of application page
Adding basic application page structure: navigation *header* with links to List and Tree views, page *content* section and *footer*.
