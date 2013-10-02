# 0. Setup

## Connect to a Git repository

**Eclipse step-by-step configuration**
* Create a [free **GitHub** account](https://github.com/signup/free)
* Install plugin *Eclipse GitHub intgration with task focused software*  (via *Install New Software...*)
* [OPTIONAL] Install plugin *GitHub Flavored Markdown viewer plugin*  (via *Eclipse Marketplace ...*)
* [OPTIONAL] Install plugin *Markdown Text Editor*  (via *Eclipse Marketplace ...*)
* Go to Import -> Git -> Repositories from GitHub
  * Search iw7i and select fjlopez/iw7i
* Open Git Repository Exploring Perspective
* Select `fjlopez/iw7i` and import Projects...
  * Select `import as general project` from the `working directory`
  * Use `iw7i` as project name
* Back to the `Java EE` perspective

**Command line support**
* http://git-scm.com/downloads
* Command line wrapper http://hub.github.com/ (OS X and Linux)

**GUI support**
http://git-scm.com/downloads/guis

**Additional documentation**
* http://git-scm.com/book/en/Git-Basics

## Apache Maven

[Apache Maven](http://maven.apache.org/) is a software project management and comprehension tool. Based on the concept of a 
project object model (POM), Maven can manage a project's build, reporting and documentation from 
a central piece of information (`pom.xml`).

[Maven Integration for Eclipse (m2e)](http://eclipse.org/m2e/) provides tight integration for Maven into Eclipse with the following features:
* Launching Maven builds from within Eclipse
* Dependency management for Eclipse build path based on Maven's pom.xml
* Resolving Maven dependencies from the Eclipse workspace without installing to local Maven repository
* Automatic downloading of the required dependencies from the remote Maven repositories
* Wizards for creating new Maven projects, pom.xml and to enable Maven support on plain Java project
* Quick search for dependencies in Maven remote repositories
* Quick fixes in the Java editor for looking up required dependencies/jars by the class or package name

m2e is shiped with Eclipse IDE for Java EE Developers. 

**Eclipse step-by-step configuration**
* Select the project `iwyi` and select `Configure -> Convert to Maven Project`  
* Go to `File -> Import -> Maven -> Existing Maven Projects`
* Several projects should appear, click `Next`
  * Eclipse should request to install additional Maven plugins (e.g `m2e connector for build-helper-maven-plugins`)

**Command line support**
The version embedded in Eclipse IDE is Maven 3.0.4. You should install a stable Maven 3.0.x version on your
machine from the [download page](http://maven.apache.org/download.cgi). Maven is a command line Java tool, 
so you must have installed a Java Development Kit (JDK) (a JRE is not sufficient). Installation steps are 
platform dependent and are listed in the download page.

## Serialization formats

* Install plugin *JSON Editor Plugin 0.9.7* (via *Eclipse Marketplace ...*)
  * Test it by creating JSON files based on [JSON examples](http://json.org/example.html) 

## Lab 1: Eclipse-managed Tomcat v7.0 Server

* Prepare the binaries
  * Go to File -> New -> Project -> General -> Project
  * Name: *Tomcat v7.0 Server*
  * Download the [core binary distribution of the stable version](http://tomcat.apache.org/download-70.cgi) of Tomcat v7.0 and uncompress
it in the project folder.
* Create a Server instance in eclipse
  * Go to File -> New -> Other... -> Server -> Server
  * Select Apache -> Tomcat v7.0 Server
  * Browse to the root folder of the Tomcat server
* Test it
  * Go to the Server view
  * Click the server to access the overview
  * Start the server
  * Test the browser is running (e.g. navigate to http://localhost:8080/ and test that returns 404)
  * Stop the server
