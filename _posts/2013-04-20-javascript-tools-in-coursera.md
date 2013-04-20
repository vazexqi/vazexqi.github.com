---
layout: post
title: "Creating Useful Tools using JavaScript for our Coursera Course"
category: posts
---

As instructors, we usually need to provide simple, yet useful auxiliary
tools for our courses. Auxiliary tools include specialized math
calculators, visualizations, etc. Such tools enhance the learning
process and provide students with new avenues to experiment and try
things out. In traditional courses, such tools are usually made
available in the form of applications that students run. Sometimes these
applications require specific versions of operating systems, frameworks
or libraries. There is the implicit assumption that the students will
have access to computing resources, e.g., their own machines or lab
computers that are capable of running those applications. In an online
learning environment such as Coursera with tens of thousands of
students, one cannot assume that all students have access to the same
computing resources. _What is the best way to implement and deploy such
tools?_

There are several solutions. We could choose only to use applications
that run on all major operating systems. For instance, we could ask
students to use applications written in Java, which runs on Windows, Mac
and Linux. While this works, it might be too much to expect students to
install the support for running Java. Recall that we are dealing with
_auxiliary_ tools. These tools are meant to be simple to use. Forcing a
student to install a whole runtime just to be able to run a simple tool
is not the best solution. We deemed this solution to have too much
overhead.

A more attractive solution would be to run the tools inside the web
browser. After all, the web browser is the quintessential tool for
online courses. Again, there are several approaches that we could use in
a web browser. We could consider using an in-browser runtime environment
such Java Applets, Adobe Flash or Microsoft Silverlight. All of these
are wonderful environments that allow you to build all forms of useful
tools. Unfortunately, as proven
[time](http://search.us-cert.gov/search?utf8=%E2%9C%93&affiliate=us-cert&query=flash&commit=Search)
and
[time](http://search.us-cert.gov/search?utf8=%E2%9C%93&sc=0&query=silverlight&m=&embedded=&affiliate=us-cert&filter=moderate&commit=Search)
again, they are also the source of many security vulnerabilities so most
students do not install them or have them disabled -- as they rightfully
should.

Fortunately, even without installing any in-browser runtime
environments, web browsers themselves are becoming more capable
computing platforms _out-of-the-box_. A few years back, developing for
web browser used to be a very unpleasant experience. There was no
standardized support for different functionalities and it was common for
applications to work in one web browser and not another. Modern web
browsers have begun to change that experience. Now, we can safely expect
most web browsers to support web standards such as HTML, CSS, SVG and
JavaScript consistently. More importantly, we can expect that the
applications we write will work gracefully on all web browsers. More
importantly, we can do this without a dedicated team of developers
testing on multiple versions of web browsers on multiple versions of
operating systems.

Indeed, that has been our experience so far. We have implemented three
tools for our [VLSI CAD: Logic to
Layout](https://class.coursera.org/vlsicad-001/wiki/view?page=WebbasedTools)
Coursera Course. The first tool is a simple _calculator_ for solving
linear equation systems. The second and third tool are _visualizations_
for two core assignments for the course. We are pleasantly surprised by
how well this has worked for us. And we would like to share some of our
experiences creating such tools.

All of these tools were implemented in less than 700 lines of code. And
all of them are released under the University of Illinois / NCSA Open
Source License so you are free to use them in your courses.

<div class="media">
<a href="http://db.tt/yhq13USO">
<img src="http://db.tt/yhq13USO" class="media-object noshadow"/>
</a>
</div>

### Simple Linear System Solver

We have implemented a very simple interface for solving systems of
linear equations directly from the web browser. Systems of linear
equations are common in many engineering disciplines. For simple
systems, it is possible to solve them by hand. However, for realistic
problems, the standard way is to use some solver in a dedicated (and
costly) application such as Matlab or Mathematica. These applications
can easily solve linear systems with thousands of equations.

For the purposes of a class, it is usually sufficient to have a solver
than can solve up to 10 equations. This is something that can be
reasonably done inside a web browser.

<div class="media">
<a href="http://db.tt/AqkMReZq">
<img src="http://db.tt/AqkMReZq" class="media-object noshadow"/>
</a>
</div>

The interface for our solver is simple. Students enter the input matrix
A and the input vector B, click on the "Solve" button and the result is
presented to them directly. As can be seen in the above figure, the tool
itself can also be directly embedded into the Coursera web page, giving
it proper _branding_ so that students know that they are still using a
tool from the course website.

We use the [Numeric.js](http://www.numericjs.com/) library by
Sebastien Loisel. The library implements many functions that you would
expect from a numerical library, all of which are rewritten in
JavaScript. Numeric.js has decent
[performance](http://www.numericjs.com/benchmark.html); it's capable of
reaching several hundred million of floating point operations per second
(MFLOPS).

<div class="media">
<a href="http://db.tt/CCdveHTN">
<img src="http://db.tt/CCdveHTN" class="media-object noshadow"/>
</a>
</div>

While we have only used its solver, Numeric.js comes with many different
functionalities as exemplified in its
[documentation](http://www.numericjs.com/documentation.html). It should
be a useful library for many different engineering courses that require
the use of a numerical library.

### Placer Result Visualization

For another assignment, we had students implement a placer. A placer
_places_ the gates on a chip. A good placer will distribute and place
chips as evenly as possible, while following some constraints. The
result of a placer is usually a textfile that describes where each gate
ends up on the chip, in the form of a x and y coordinate.

Because there can be thousands of such gates for an assignment (and
millions for an actual industrial chip), it is not easy to make sense of
the textfile. Thus, it is important to be able to visualize the result
of the placer. 

<div class="media">
<a href="http://db.tt/rlnAfIu5">
<img src="http://db.tt/rlnAfIu5" class="media-object noshadow"/>
</a>
</div>

Visualizing the result is simple: use a scatter plot. However, how could
we get the data to the visualization tool? Unlike the simple linear
equation solver tool, there are thousands of such gates and we cannot
expect the student to type all of them in. Instead, we leverage the
[File API](http://www.html5rocks.com/en/tutorials/file/dndfiles/) that
is part of the HTML5 standard. Using this interface, the student only
has to drag-and-drop her file into the web browser. The web browser then
reads the file and displays the results. Everything is done locally
inside the web browser.

You can see the tool in action in the video below:

<iframe width="560" height="315"
src="https://www.youtube-nocookie.com/embed/s3b6PBOYWKs?rel=0"
frameborder="0" allowfullscreen></iframe>

We used the [d3.js](http://d3js.org/) library by Mike Bostock. Mike
obtained his PhD under [Jeffrey Heer](http://hci.stanford.edu/jheer/) at
the Stanford Vis Group. Their group has studied and produced many useful
ideas and software for visualization of information. d3.js is a very
rich library that is capable of many different
[visualizations](https://github.com/mbostock/d3/wiki/Gallery). There is
a learning curve to using the tool. However, once we understood the
architecture it was easy to add new visualizations.

Before using d3.js, we implemented a version using [Google Scatter
Chart](https://developers.google.com/chart/interactive/docs/gallery/scatterchart).
While it was easier to use initially, it was difficult to change the
graph to look the way we needed it to. For instance, we had a very
specific requirement on how the axes needed to be marked in the graph.
Google's Scatter Chart API did not provide a way to do this. And because
it was close source, we could not modify the source code to do what we
wanted. Thus, we switched to d3.js because it provided more control
overall.

In our experience, the tool was seamless to use for the students and it
provided a useful visualization for them to verify their results.

### Router Result Visualization

For our last programming assignment, we had students implement a router.
A router _routes_ wires from a source pin to a destination pin. A good
router will route as many wires as possible, while avoiding obstacles
and minimizing the amount of "bends" that it needs to make to reach its
destination. The result of a router is usually a text file that describes
the path from a source pin to a destination pin.

Again, because there can be hundreds of such routes (and millions for an
actual industrial chip), it is not easy to make sense of the text file.
Thus, it is important to be able to visualize the paths. Visualization
helps students _eyeball_ problems with their routing implementation,
e.g., if two routes intersect or if the routes go through an obstacle.

<div class="media">
<a href="http://db.tt/dDMhuR4m">
<img src="http://db.tt/dDMhuR4m" class="media-object noshadow"/>
</a>
</div>

For this tool, we used the same drag-and-drop interface provided
through the File API in HTML5. And we used the d3.js visualization
library.

We were able to successfully visualize a 1000 by 1000 grid with 1000
routes. To give you a scale of how big this is, if we were to print it
out, it will take a 144 in x 144 in paper. It took less than 10 seconds
and consumed 256 MB of memory on Google Chrome on a 2010 MacBook Pro
with a 2.53 GHz Core i5 processor with 8 GB of RAM. In summary, we thought
that performance was decent for what we needed to do. And it did not
demand too much from the student's computer.

You can see the tool in action in the video below:

<iframe width="560" height="315"
src="https://www.youtube-nocookie.com/embed/4m0V6fpwROA?rel=0"
frameborder="0" allowfullscreen></iframe>

----

In summary, our experiences with creating these auxiliary tools have
convinced us of the possibilities of doing _as much as possible_ from
the web browser. Before we implemented the tools, we were worried about
the performance of JavaScript-based tools inside web browsers. We were
worried that it would be too slow or take up too much resources on the
student's machine.

It is safe to say that our fears were alleviated. Our VLSI CAD: Logic to
Layout course has about 17,000 students registered. Of this, about 1,000
are actively doing the assignments and using the tools.

As future work, it is worth exploring how far we can take this approach
of doing everything inside JavaScript. My colleague who is a teaching
assistant for our [Creative, Serious and Playful Science of Android Apps
course](https://www.coursera.org/course/androidapps101) on Coursera
is looking into using [Doppio](http://int3.github.io/doppio/about.html)
to enable students to program with Java inside their web browser.

Other projects such as
[Emscripten](https://github.com/kripken/emscripten) will also be worth
exploring. For our course, we had the luxury of being able to
re-implement everything from scratch. Sometimes, however, instructors
have old versions of C/C++ programs that they would like to run in the
web browser. In those cases, Emscripten might prove to be a useful first
approach toward migrating legacy code to the web browser.

