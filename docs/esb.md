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

Let's copy files automatically between folders using `Camel`. Create and copy to the `deploy` folder the following file.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<blueprint
    xmlns="http://www.osgi.org/xmlns/blueprint/v1.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
	http://www.osgi.org/xmlns/blueprint/v1.0.0
	http://www.osgi.org/xmlns/blueprint/v1.0.0/blueprint.xsd">
    <camelContext xmlns="http://camel.apache.org/schema/blueprint">
		<route>
			<from uri="file:input"/>
			<log message="Moving ${file:name} to the output directory"/>
			<to uri="file:output"/>
		</route>
    </camelContext>
</blueprint>
```
Questions:
* What is [OSGI](http://www.osgi.org/Main/HomePage)? What is a [Bluepring](http://www.ibm.com/developerworks/opensource/library/os-osgiblueprint/)? Are you **already** using an OSGI platform? Which?
* What had happen? How `list` and `log:display` help?
* Could you list the available `Camel` routes? Hint, use first `help camel`.
* Test the route. Copy a file to `input` and see how it is moved to `output`.
* Can you uninstall the route?

### Task 6.3: REST: `JAX-RS` customer

In order to understand this and following tasks you should see the source code of the examples. Import to your Eclipse the Maven projects found in the `examples` folder. Open the `README.txt` file of the `cxf-jaxrs-blueprint` example and follow the instructions to **fast** install and run the JAX-RS CXF examples.

Questions:
* From where the code was installed?
* What can be found at [http://localhost:8181/cxf/crm/customerservice?_wadl&_type=xml](http://localhost:8181/cxf/crm/customerservice?_wadl&_type=xml)?
* What is the advantage of using a `Blueprint` here?
* If you want to deploy a new version to `ServiceMix`, how you would proceed? What would be the role of the maven plugin `maven-bundle-plugin`?

### Task 6.4: SOAP: `JAX-WS` Hello world

### Task 6.5: Events: `ActiveMQ` example

### Task 6.6: Business logic: `Drools` rules  

### Task 6.7: Business logic: `Activiti`, a Business Process Management (BPM) platform  
