## Lab 6 Enterprise Service Bus

This laboratory will consist of a series of tasks designed to familiarize you with the concept 
[Enterprise Service Bus](http://en.wikipedia.org/wiki/Enterprise_service_bus). It is expected that 
students use the online documentation of the ESB [Apache ServiceMix](http://servicemix.apache.org/) 
during the laboratory.

### Task 6.1: Introduction to `ServiceMix`

Download (or ask a copy to your teacher) a copy of [Apache ServiceMix 5.0.0.SNAPSHOT](http://servicemix.apache.org/downloads/servicemix-5.0.0.html) for your OS. Next, decompress it in a folder. Open a terminal and go to the folder `apache-servicemix-5.0.0-SNAPSHOT\bin` and run `servicemix`. This will launch `ServiceMix` and the `SeviceMix console`. Hit `<tab>` to see the available commands.  

Explore the console and run the following commands:
* Run `help osgi:shutdown` and after understanding the command run `osgi:shutdown`.
* What does `list` show? And `features:list`? Do you recognize something? 
* Run `features:install webconsole` and open with a browser [http://localhost:8181/system/console]( http://localhost:8181/system/console) [user:smx, password:smx]. What do you see?
* Run `log:display`. Which command shows the last occurred exception recorded in the log?

### Task 6.2: EIP: The magic `Camel` route

### Task 6.3: REST: `JAX-RS` customer

### Task 6.4: SOAP: `JAX-WS` Hello world

### Task 6.5: Events: `ActiveMQ` example

### Task 6.6: Business logic: `Drools` rules  

### Task 6.7: Business logic: `Activiti`, a Business Process Management (BPM) platform  
