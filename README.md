# Program-Covid19
1.	Connect Maven with Eclipse for sending e-mails:
Download maven.apache.org from: 
https://maven.apache.org/download.cgi  
Save it on Program Files
Download activation.jar from: http://www.java2s.com/Code/Jar/a/Downloadactivationjar.htm 
Download mail.jar from : http://www.java2s.com/Code/Jar/m/Downloadmailjar.htm 
Paste activation.jar and mail.jar at:
Program Files(x86) -> apache-maven-3.6.3-> lib
Then follow the next steps:
Open Eclipse  → File → New → Other.. → Maven → Maven Project → Tick at: Create a simple project(skip archetype selection). → Next →  Fill Group Id and Artifact Id. 
After your maven project is made follow the next steps:
Right click at the Maven Project → Build Path → Configure Build Path → Libraries → Add External JARs →  Go to Program Files(x86) → apache-maven-3.6.3 → lib → Choose all files .jar → Open → Apply → Apply and Close
2.	Connect our Maven Project with Excel
After we have created a Maven project we have to follow the next steps to create make it suitable for excel as well
Open tour Maven Project and click on the pom.xml file. In that file we need to have to following: 
<project xmlns="http://maven.apache.org/POM/4.0.0" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>MavenUtil</groupId>
  <artifactId>MavenUtil</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <dependencies>
  	<dependency>
  		<groupId>org.apache.poi</groupId>
  		<artifactId>poi-ooxml</artifactId>
   		<version>4.1.2</version>
  	</dependency> 
  </dependencies>  
</project>
After that we need to go to the folder we have our project saved in our computer and click right and create a new Microsoft Excel Worksheet. Refresh our project in Eclipse and there should be a (name).xlsx file made. We gave the name datalast.xlsx and in the file, added another sheet with the name “Contacts”.
 
We create another Microsoft Excel Worksheet, since we want two .xlsx files for our project (we named ours resultlast). If all these steps are completed, we are all set. 
 
3.	Add Eclipse Project to GitHub:
Start a project/Create a repository → Go to GitHub → Click on: New Repository → Fill the gap Repository Name → Tick at: Public → Create Repository → Copy the URL →  Go to Eclipse → Open Perspective → Git Repositories (Git) → Choose from down-left: Clone a Git Repository and add the clone to this view → Paste the URL from Eclipse → Next> → Next> → Finish → Right click at my Maven Project → Team → Share Project → Choose to the gap Repository the repository you want to share → Finish → Go to Package Explorer → Right click at my Maven Project → Team → Click on Commit → Select the Unstaged Changes → Drag and drop to Staged Changes → Write a Commit Message → Commit and Push → Next → Fill the Login gaps → Finish 
