---
layout: post
title: "Logging to file using SLF4J"
category: posts
---

Part of being a TA for our [VLSI CAD: Logic to
Layout](https://www.coursera.org/course/vlsicad) is the very important task of
implementing the auto-graders that power the assignments. The auto-graders are
run on the Coursera servers and auto-scaled (new instances are spawned) as
necessary. With about 10, 000 students registered for the class, the possibility
that somethings goes wrong is _highly_ probable.

Thus, it is extremely useful to have some file of logging implemented,
preferably one that has the ability to log to file and rotate the logs as
necessary.

_Fortunately_, there is no shortage of logging frameworks for Java. I say that
in a tongue-in-cheek way because as I was starting to implement this a few days
ago, I was overwhelmed by the sheer number of different logging frameworks from
the built-in java.util.logging, [commons
logging](http://commons.apache.org/logging/),
[log4j](http://logging.apache.org/log4j/1.2/index.html) to
[logback](http://logback.qos.ch/).

After reading more about the different frameworks, I realize that I necessarily
have to fully _commit_ to one. I could use, yet another framework, to _decouple_
the dependency. Thus, enters [SLF4J](http://www.slf4j.org/manual.html).
According to the website:

> The Simple Logging Facade for Java or (SLF4J) serves as a simple facade or
> abstraction for various logging frameworks, such as java.util.logging, log4j and
> logback. SLF4J allows the end-user to plug in the desired logging framework at
> deployment time.

There is even a nice image on the SLF4J website that shows how this works under
the hood:

<div class="media">
<a href="http://www.slf4j.org/images/concrete-bindings.png">
<img src="http://www.slf4j.org/images/concrete-bindings.png"
class="media-object"/>
</a>
</div>

Because setting up logging can be quite complicated the first time one uses it,
the purpose of this post is to serve as a quick reference (possibly for myself
in the future too, when I have to do this again from scratch). I am going to
showcase how to do logging in [Groovy](http://groovy.codehaus.org/) using the
[Gradle](http://www.gradle.org/) build tool.

----

### Setting up the files

Gradle follows a sensible _convention-over-configuration_ scheme on where to
place your source files. Instead of making things more complicated, we are going
to stick with that scheme. This means, that all source files should go into
`src/main/groovy`. Here's a screenshot of where the files should go to help:

<div class="media"> 
<a href="http://db.tt/RzuGL16Y">
<img
src="http://dl.dropbox.com/u/11541918/Blog/images/logging_directory_structure.png"
class="media-object noshadow"/></a>
</div>

For each of the files that I will describe below, stick them in the right
location following the convention above.

### Setting up Gradle

We are going to use Gradle to set up the dependencies, manage the build process
and the lauching of our example.

<script src="https://gist.github.com/vazexqi/5024526.js"></script>

The script above will fetch all the dependencies for you.

### The MyExample class

This is the example class that we will be using. It's a very simple program that
prints a heartbeat every 30 seconds (so you can easily see something happening
to the console).

<script src="https://gist.github.com/vazexqi/5024557.js"></script>

This code snippet uses a bit of Groovy _magic_ available since version
1.8. It uses the `@sfl4j` type annotation to introduce a new variable
called `log` that maps to a call to the logger. That way, you no longer
have to write ugly code that instantiates a logger for each of your
classes.

### The logback.xml file

By default the loggers will all output only to console. Since the purpose of
this post is to show you how to actually log things to file with a
rotating/rolling log file, I've also included the configuration file that I have
used.

<script src="https://gist.github.com/vazexqi/5024574.js"></script>

The configuration file above creates two kinds of `Appenders`. The first one
called `STDOUT` appends to the console, and the second one called `FILE` appends
to file. We configure the `FILE` appender so that it uses a rolling scheme. It
will create a new log file daily and keep up to 7 days's worth of history.

The logback website has a rich set of `Appenders` that one can use. There is
even one that can e-mail the logs to your account. Check out
[http://logback.qos.ch/manual/appenders.html](http://logback.qos.ch/manual/appenders.html)
for more code snippets.


### Running the example

<div class="media"> 
<a href="http://db.tt/kw3flQg9">
<img
src="http://dl.dropbox.com/u/11541918/Blog/images/logging_running.png"
class="media-object noshadow"/></a>
</div>

Assuming that you have gradle installed, you just need to execute `gradle
runMyExample`.

It should print "Still alive..." every 30 seconds or so **both** on the console
and into the log files.

---

If you wish, you can download the files for this project from
[here](http://db.tt/W6rY4hRI).


