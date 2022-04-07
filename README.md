# Grupp3-Serverprogrammering

How to build

First way - Eclipse
1. Open the Projects with eclipse
2. Make sure to have wildfly and derby server running
3. Then build by right clicking "Build.xml" and click "run as ant build"
4. Then the file should get deployed to your wildfiy (OBS! check which destination it will end upp in and change it in Build.xml)
5. U should be able to do both https calls with something like INSOMNIA and the client functions should be working


Second way - Ant
1. Download the files
2. Change in the "META-INF" folder "persistence.xml" from "update" to "create"
3. Go to target directory with ur preffered Console (We used Ubuntu)
4. write the command "ant -d"
5. U should get a new folder in ur current one which should have a "StudentManagement.war" file inside it
6. Upload it to wildfly together with db.derby.bin
8. U should be able to do both https calls with something like INSOMNIA and the client functions should be working

Can also test the code without building if you have eclipse by just running the test client and using the menu
