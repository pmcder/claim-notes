## Overview

This is a clone of an property/casualty insurance company claims management system's
claim notes feature. Claims representatives would use this feature to add, edit, and
read claim file notes. Claim file notes are the primary way that claims handling
activities are documented. Any time an adjuster opens a claim file they type a note. A typical note might summarize a phone call to an insured, a police report, or the conclusion of
a liability investigation. 

## Running the project

You will need to build the database.The sql scripts to do so
are in claim_notes_app.db.sql
The current database url in the repositories is
jdbc:postgresql://localhost/claim_notes_db
and the driver is Postgres
so you will need to edit that if you are not using Postgres or the path to
your db is different.

You can run the project from your ide from display.DisplayMain.java

### Running with Maven
App is currently throwing an exception when connecting to the database.
See issues.
other than that, can be run with maven by cd'ing into project directory and running 
mvn clean package
java -jar target/


## Contributing 
I built this project as a simple, easy to understand implementation. Please feel free
to contribute to it. It is a great beginner Java project. There are several enhancements
needed to make all buttons fully functional that should only take a few lines of code. 
