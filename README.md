Description
Application for the Forest Service to track animals during an environmental impact study.

Project which I am provided with the code containing the basic classes, Spark setup, VelocityTemplateEngine, vtl template structure, routing in App.java, tests, and database setup instructions, which I am to test, correct errors, and complete the requirements for.

The Forest Service is considering a proposal from a timber company to clearcut a nearby forest of Douglas Fir. Before this proposal may be approved, they must complete an environmental impact study. This application was developed to allow Rangers to track wildlife sightings in the area.

Table of Contents
Sections
Install
Installation Requirements
Manual Database Creation
Usage
Screen Shots
Known Bugs
Sources
Maintainer
Contribute
License
Install
All installation instructions are for macOS

Setup/Installation Requirements
Install Java JRE (Runtime Environment).
Install Postgres.
Install Gradle.
Clone this repository onto your desktop. This will place the all files and folders in onto your computer.
Start Postgres in an additional terminal tab by entering postgres.
In yet another terminal window start psql with psql.
In psql tab enter CREATE DATABASE wildlife_tracker;.
In terminal tab enter psql wildlife_tracker < wildlife_tracker.sql.
In psql tab enter \c wildlife_tracker then \dt.
In terminal tab enter gradle run.
Navigate to 0.0.0.0:4567 in your internet browser.
Manual Database Creation
To create the necessary databases, launch postgres, then psql, and run the following commands:

CREATE DATABASE wildlife_tracker;
\c wildlife_tracker;
CREATE TABLE animals (id serial PRIMARY KEY, name varchar);
CREATE TABLE endangered_animals (id serial PRIMARY KEY, name varchar, health varchar, age varchar);
CREATE TABLE sightings (id serial PRIMARY KEY, animal_id int, location varchar, ranger_name varchar, date TIMESTAMP);
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
Usage
