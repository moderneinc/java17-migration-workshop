# Moderne CLI 

In this adventure, you will use the [Moderne
CLI](https://docs.moderne.io/moderne-cli/cli-intro), a free tool that allows
developers to run OpenRewrite recipes without configuring any build plugin, to
migrate a repository to Java 17.

Afterwards, you'll use the CLI to publish your own OSS repository to the Moderne
platform so that you can run recipes on it without having to build it over and
over.

## Prepare your environment

1. Create a Moderne Access Token by going to
   [https://app.moderne.io/settings/access-token](https://app.moderne.io/settings/access-token).
   Once there, enter a name for the token and press `generate`.

3. Export your token as an envorinment variable

```shell
export MODERNE_ACCESS_TOKEN="mat-YOUR_TOKEN_HERE"
```

4. Switch to Java 8 (or the JDK required to build your repository) so you can properly build this repository. 
You might need to download Java 8 and update your `JAVA_HOME` environment variable. If you are
on a Unix-based system, we recommend using [SDKMan](https://sdkman.io/):

```shell
sdk install java 8.0.372-tem
sdk use java 8.0.372-tem
```
  * If you want to use `sdk` and the `java 8.0.372-tem` distribution 
    is not available for you, select any distribution that represents a Java 8 version.
    
  * If you aren't on a Unix-based system or you don't want to install SDKMan,
    you'll need to install Java 8 and run something like:

```shell
export JAVA_HOME=REPLACE_FOR_LOCATION_OF_JAVA_8
```
If you are in a MacOS, you have an utility to list the existing JVMs running:

```shell
/usr/libexec/java_home -V
```

6. Clone your repository. In this example we will use an example repository

```shell
cd example
```

8. Ìt requires Maven. Please, make sure it runs on your machine:

```shell
mvn package -DskipTests
``` 

## Migrate to Java 17 using the Moderne CLI

1. Run the build command to generate the repository LST

```shell
mod build
```

2. Now, switch to Java 17 to run recipes. This is a requirement of the CLI daemon.

```shell
export JAVA_HOME=REPLACE_FOR_LOCATION_OF_JAVA_17
```
 
3. Now it is time to migrate to Java 17. Use the following command from the `spring-petclinic` repository:

```shell
mod run --recipeName org.openrewrite.java.migrate.UpgradeToJava17 --recipeGAVs org.openrewrite.recipe:rewrite-migrate-java --skipBuild
```

4. The previous command should have updates your source files. You can then see the changes made by running:

```shell
git diff
```
