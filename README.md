Sorry for the no-context stacktrace paste...

Here are the steps
1. `git clone https://github.com/nguyenq/tess4j.git`
2. `cd tess4j`
3. `mvn clean package` (it will create both shaded and normal jar)
4. Install the normal jar into local repository
    `mvn install:install-file -Dfile=target/tess4j-2.0.0-SNAPSHOT.jar -DpomFile=pom.xml `

Now
`git clone https://github.com/brucardoso2/tess4jtest.git`
`mvn clean package` (it will create both shaded and normal jar)

Now run the shaded jar:
`java -jar target/ShadedMaven-1.0-SNAPSHOT-shaded.jar <imagefile>`
