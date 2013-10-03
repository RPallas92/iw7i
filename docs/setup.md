## Lab 1. Setup

This laboratory will consist of a series of tasks designed to familiarize you with the tools and
technologies related to Web Engineering.

### Task 1.1: Git basics in Eclipse

[Git](http://git-scm.com/) is a distributed revision control and source code management. Git was initially 
designed and developed by [Linus Torvalds](http://en.wikipedia.org/wiki/Linus_Torvalds) in 2005. A
[recent survey](http://ianskerrett.wordpress.com/2013/06/12/eclipse-community-survey-results-for-2013/) 
reports Git has a 30% adoption among Eclipse users. You should read 
[Git Basics](http://git-scm.com/book/en/Git-Basics) to get going with Git.

[GitHub](https://github.com/) is a web-based hosting service for software development projects that use Git.
GitHub offers free accounts for open source projects. GitHub is 
[one of the most popular](http://readwrite.com/2011/06/02/github-has-passed-sourceforge) code repository site
for open source projects.

**[MANDATORY] Clone an existing repository using Eclipse git**

Create first a [free GitHub account](https://github.com/signup/free). Then install the following Eclipse 
plugins:
* `Eclipse GitHub intgration with task focused software` (via `Install New Software...`).
* [RECOMMENDED] `GitHub Flavored Markdown viewer plugin`  (via `Eclipse Marketplace ...`).
* [RECOMMENDED] `Markdown Text Editor`  (via `Eclipse Marketplace ...`).

Go to `Import -> Git -> Repositories` from GitHub and then search `iw7i` and select `fjlopez/iw7i` (this
repository!).

**[MANDATORY] Import a project from a cloned repository**

Open `Git Repository Exploring` perspective. Then, select `fjlopez/iw7i` and then `Import Projects...`. 
Next select `import as general project` from the `working directory` and then use `iw7i` as project name.
Finally, back to the `Java EE` perspective.

**[RECOMMENDED] Install command line tool**

It is recommended to install `git` command line tools from [git site](http://git-scm.com/downloads). 
GitHub has developed [a command line wrapper](http://hub.github.com/) for OS X and Linux that eases the use
of this tool when you are working with a GitHub repository.

**[RECOMMENDED] Install GUI tool**

There are available commercial and free enhanced GUI tools for browsing and committing for Windows, OS X and
Linux [here](http://git-scm.com/downloads/guis).

### Task 1.2: Apache Maven basics in Eclipse

[Apache Maven](http://maven.apache.org/) is a software project management and comprehension tool. Based on 
the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation 
from a central piece of information (`pom.xml`).

[Maven Integration for Eclipse (m2e)](http://eclipse.org/m2e/) provides tight integration for Maven into 
Eclipse with the following features:
* Launching Maven builds from within Eclipse.
* Dependency management for Eclipse build path based on Maven's pom.xml.
* Resolving Maven dependencies from the Eclipse workspace without installing to local Maven repository.
* Automatic downloading of the required dependencies from the remote Maven repositories.
* Wizards for creating new Maven projects, pom.xml and to enable Maven support on plain Java project.
* Quick search for dependencies in Maven remote repositories.
* Quick fixes in the Java editor for looking up required dependencies/jars by the class or package name.

`m2e` is shiped with Eclipse IDE for Java EE Developers. 

**[MANDATORY] Enable the Maven nature of the project**

The presence of the `pom.xml` file shows the project has already a Maven nature. You must tell
tell Eclipse to let `m2e` to manage the project explicitly. Therefore, select the project `iwyi` and select
`Configure -> Convert to Maven Project`.

**[MANDATORY] Discover nested Maven projects**

Maven allows to organize large projects in subprojects named modules. `m2e` can discover these modules and
make them available as projects. Go to `File -> Import -> Maven -> Existing Maven Projects`. Several projects 
should appear, click `Next`. Eclipse should request to install additional Maven plugins 
(e.g `m2e connector for build-helper-maven-plugins`).

**[RECOMMENDED] Install command line tool**

The version embedded in Eclipse IDE is Maven 3.0.4. You should install a stable Maven 3.0.x version on your
machine from the [download page](http://maven.apache.org/download.cgi). Maven is a command line Java tool, 
so you must have installed a Java Development Kit (JDK) (a JRE is not sufficient). Installation steps are 
platform dependent and are listed in the download page.

### Task 1.3: Setup a eclipse-managed Tomcat v7.0 Server

[Tomcat v7.0 Server](http://tomcat.apache.org/tomcat-7.0-doc/index.html) implements the [Java Servlet 3.0]
(https://tomcat.apache.org/tomcat-7.0-doc/servletapi/index.html) specification. It is very easy to integrate 
Tomcat in Eclipse IDE for Java EE Developers for deploying Web projects for testing and debuging. 

**[RECOMMENDED] Create a project for Tomcat binaries**

Create a general eclipse project (`File -> New -> Project -> General -> Project`) and name it 
`Tomcat v7.0 Server`. Then ownload the [core binary distribution of the stable version]
(http://tomcat.apache.org/download-70.cgi) of Tomcat v7.0 and uncompress it in the project folder.

**[MANDATORY] Create a Server instance managed by Eclipse**

Go to `File -> New -> Other... -> Server -> Server`. Then select `Apache -> Tomcat v7.0 Server`. Use as
`Tomcat installation directory` the root folder of the binaries of a Tomcat 7.0 server. To test it go
to the `Server view` and click on the server named `Tomcat v7.0 Server at localhost` to access to a panel
that presents detailed informatio about the server. Next start the server with the start button in the 
`Server view`. Test the server is running (e.g. navigate to http://localhost:8080/ and test that 
returns 404). Finally, stop the server.

### Task 1.4: Working with serialization formats

The student should be already familiar with [XML](), [JSON]() and [Protocol Buffers](). Eclipse IDE for Java EE Developers
is shipped with tools for working with XML and XML Schema but lacks support for JSON and Protocol Buffers.

**[MANDATORY] Test XML and XML Schema support provided by Eclipse**

The project `iw7i-xml` has the following Java classes that can be run:
* `iw7i.serialization.xml.AddPerson` creates and writes contacts to a XML file
* `iw7i.serialization.xml.ListPeople` reads and list its contents.
* `iw7i.serialization.xml.GenerateSchema` generates a XML Schema files.

It uses the [JAXB API](https://jaxb.java.net/) shipped with Java 7 for annotating, marshalling and 
unmarschalling Java business classes. 

Create a XML file and examine it with the tools provided by Eclipse. Generate the XML Schema and compare it with
the described Java classes.

**[MANDATORY] Install and test JSON support**

Eclipse does not provides a JSON editor. Install the plugin `JSON Editor Plugin 0.9.7` (via 
`Eclipse Marketplace ...`). Create a JSON file with the help of the project `iw7i-json`. It has the following
Java classes that can be run:
* `iw7i.serialization.json.AddPerson` creates and writes contacts to a Java file
* `iw7i.serialization.json.ListPeople` reads and list its contents.

This project uses the [Google GSON](https://code.google.com/p/google-gson/) library for converting Java objects into
a JSON representation and vice versa. You do not require to download such library and its dependences because Maven 
has already performed this task on behalf of you. The `pom.xml` contains the following declaration:

```xml
<dependencies>
	<dependency>
		<groupId>com.google.code.gson</groupId>
		<artifactId>gson</artifactId>
		<version>2.2.4</version>
	</dependency>
</dependencies>
```

This declaration tells maven to find in an external repository (e.g. [Maven Central Repository](http://search.maven.org/))
such artifact and make it available in compilation time.

Create a JSON file and examine it with the tools provided by the installed Eclipse. Format it in a humman-readable way 
using the provided tools.

**[RECOMMENDED] Install and test Protocol Buffers support**

Eclipse does not provide support for the Protocol Buffers infrastructure (editor + preprocessor). You should have already
acquired some expertise in installing Eclipse plugins. Install the plugin `Protocol Buffers Development Tools` from 
[Google Code](https://code.google.com/p/protobuf-dt/) to edit `.protoc` files. 

The project `iw7i-protobuf` has the following Java classes that can be run:
* `iw7i.serialization.protobuf.AddPerson` creates and writes contacts to a Protocol Buffers file
* `iw7i.serialization.protobuf.ListPeople` reads and list its contents.

And the required generated code in Java to run (`iw7i.serialization.protobuf.AddressBookProtos`).

If you want to generate code you must
install the [Protocol Buffers code generator](https://code.google.com/p/protobuf/). You should configure the plugin to
tell where is the code generator and where the code generated should be available. Maven expects that the generated code 
should be at `src-gen/main/java` as the `pom.xml` has the following snippet:

```xml
<plugin>
 <groupId>org.codehaus.mojo</groupId>
	<artifactId>build-helper-maven-plugin</artifactId>
	<version>1.7</version>
	<executions>
	 <execution>
		 <id>add-source</id>
			<phase>generate-sources</phase>
			<goals>
			 <goal>add-source</goal>
			</goals>
			<configuration>
			 <sources>
				 <source>src-gen/main/java</source>
				</sources>
			</configuration>
		</execution>
	</executions>
</plugin>
```

### Task 1.5: Working with a Dynamic Web Module

The project `iw7i-servlets` is a Servlet 3.0 Web application able to generate dynamic content. In the `pom.xml` file 
is declared as a `war`.

**[MANDATORY] Run and test the application**

First you should finish the configuration of the system. Go to `iw7i` properties and then `Project Facets -> Dynamic Web Module -> Runtimes`
and select `Apache Tomcat 7.0`. Next you can run the Web application in `Run as -> Run on Server`. Now the application should
be running in the Web container and Eclipse should open an embedded browser pointing at http://localhost:8080/iw7i-servlets/index.html
Note that each change in the source code is automatically republished by the server, enabling near real-time testing of the Web application.

**[CHALLENGE] Run and test the application from the command line**

Use Google to discover how to use Maven and an embedded [Jetty](http://www.eclipse.org/jetty/) for running a Servlet 3.0 
application from the command line.



