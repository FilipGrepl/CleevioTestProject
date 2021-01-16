# Cleevio test project

## Project structure

com \
&nbsp;&nbsp;&nbsp;└── app \
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ├── controllers \
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; │  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ├── exceptionAdvices \
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; │  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ├── exceptions \
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; │  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ├── modelAssemblers \
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; │  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; └── validators \
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ├── database \
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; │  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ├── entity \
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; │  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ├── loader \
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; │  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; └── repository \
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ├── services \
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; └── watchEshop

## Description of project structure

To generate the basic project structure and its dependencies the Spring Initializr was used.
The whole project is divided into 4 main packages as you can see above. First of them - *controllers* - contains  *WatchController*, which handles REST requests. Exceptions that can occur are included in the *exceptions* subpackage. These errors are caught in the corresponding handlers which are included in the *exceptionAdvices* package. These handlers generate responses with corresponding error code and its description. There are also handled exceptions, which are thrown when the received data is in bad format or doesn't meet the specified constraints. The package *modelAssembler* contains a class for creating links to *WatchController* methods. For this purpose the Spring Hateoas project was used. These links have been used in the responses to the GET requests so that the response corresponds with RESTful API. Last subpackage, *validators*, contains validator, which checks the base64 format of fountain in POST and PUT request.

The second package contains, as the name suggests, classes which are related to a database. For this project the simple H2 in-memory database was used. The subpackage *entities* contains database entities and the subpackage *repositories* cosists of DAO objects for easy work with these entities. The subpackage *loader* contains the loader of the database for saving initialization data.

The third package *services* contains the service for manipulating *Watch* objects. For this purpose the corresponding DAO object from the package *repositories* was used. The last package - *watchEshop* - contains the class with the *main* method for starting the whole application.

## API description

### GET

- /watches/ - return all watches
- /watches/{*id*} - return watches by *id*

### POST

- /watches/ - save new watch

### PUT

- /watches/{*id*} - update watch by *id*

### DELETE

- /watches/{*id*} - delete watch by *id*

If an error occurs, the corresponding error code is returned along with the description of the error.

## Note

The GET, PUT and DELETE methods were implemented in addition to the assigment. The *consumes* and *produces* property of corresponding annotation (*@GetMapping*, *@PostMapping*, *@PutMapping*, *@DeleteMapping*) was used at point 5 of task. The *consumes* property specifies supported format of incoming data. The format of incoming data is selected using *Content-type* in a request header. Analogously the outcoming format is selected using *Accept* in a request header.
