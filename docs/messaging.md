## Lab 4 Message Oriented Services

This laboratory will consist of a series of tasks designed to familiarize you with the tools and
technologies related to Message Oriented Services. It is expected that students use the online documentation
about the WebSockets API during the laboratory extensively.

### Task 4.1: Install and run `iw7i-chat`

**[MANDATORY] Run `iw7i-chat`** 

The first step is to update your `git` projects. The outcome of this step should be retrieving
from `GitHub` the following `maven modules`:
* `iw7i-messaging`. This module is a POM module that encolses `iw7i-chat`.
* `iw7i-chat`. This module is a websockets-based online chat system. The maven command `mvn clean package jetty:run` will
starts the web application at `http://localhost:8080/websocket/`. 

**[MANDATORY] Identify missing but expected features**

### Task 4.2: Trace websocket protocol on the server side

**[MANDATORY] Trace websocket protocol**

Use a logger to trace on open, on close, on message and on error events. Add as many additional methods as required.

### Task 4.3: Broadcast messages

The code as-is is an echo service. In order to be a proper chat system each received message should be
broadcasted to all connected users.  

**[MANDATORY] Broadcast any received message to all connected users and trace it**

### Task 4.4: Multiple rooms support

Once the server is able to broadcast messages the systems work a a chat system with a single room. 
The client allows to connect to four rooms. Add support to multiple rooms in the server, that is, 
messages are only broadcasted to the connected members of the same room. 

**[MANDATORY] Add multiple rooms support**

### Task 4.5: Eliza-bot

[ELIZA](http://en.wikipedia.org/wiki/ELIZA) was the first chatterbot. A chatterbot is a computer program 
designed to simulate an intelligent conversation with one or more human users. An implemetation in Java
based very closely on the original program can be found [here](http://www.chayden.net/eliza/Eliza.html).


**[OPTIONAL] Adapt an existing chatterbot (e.g. Eliza) to connect to a room of the chat system**



