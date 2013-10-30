## Lab 3 RESTful WS

This laboratory will consist of a series of tasks designed to familiarize you with the tools and
technologies related to RESTful Web Services.

### Task 3.1: Install and run `iw7i-hellorestfulcli` and `iw7i-hellorestfulws`

**[MANDATORY] Run `iw7i-hellorestfulcli` and `iw7i-hellorestfulws`** 

The first step is to update your `git` projects. The outcome of this step should be retrieving
from `GitHub` the following `maven modules`:
* `iw7i-hellorestfulws`. This module is a standalone simple RESTful Web Service that can be run with the class
`iw7i.restfulws.hellows.Server`. This class publishes the service at `http://localhost:8080/helloWorld`.
* `iw7i-hellorestfulcli`. This module is a simple client that uses the class `javax.ws.rs.client.ClientBuilder` 
* for accessing the RESTful endpoint. The class `iw7i.restfulws.hellows.ClientRS` runs the client.

### Task 3.2: Install and test `iw7i-abook-rs`

**[MANDATORY] Run tests of `iw7i-abook-rs`** 

This project is an example of a simple Address Book turned into a RESTful WS. The class `iw7i.restfulws.abook.AddressBookService` acts a service. The URI policy is:
* `/contacts` returns all the entries. `GET` and `POST` are the only allowed methods.
* `/contacts/person/{id}` returns the data of a contact. `GET`, `PUT` and `DELETE` are allowed in this enpoint.
The representation is only available as JSON. 

The class The class `iw7i.restfulws.abook.AddressBookServiceTest` contains a set of `junit` tests that start a the service at
`http://localhost:8282/` and interacts with it. The approach shown here can be reused for testing the integration of Web Services.

**[OPTIONAL] Improve `iw7i-abook-rs`** 

The code can be improved in different RESTful ways:
* `/contacts/phone/{number}` should return the corresponding phone number plus a link to the related persons 
* `/contacts/name:{name}` or `/contacts?name={name}`  should return a filtered list of resources
* `/contacts` returns too much information about contacts. It's be better to return only a list of URL and a label.
* The service has too much explicit business logic, place it in an `AddressBookDAO` instance (see [DAO](http://www.oracle.com/technetwork/java/dataaccessobject-138824.html))

**[OPTIONAL] Create a command line cliente of `iw7i-abook-rs`** 

Adapt the code of `iw7i-json` to use `iw7i-abook-rs` to create two clients: `AddPerson`, that adds 
new entries, and `ListPerson`, that lists the data available through the service.
