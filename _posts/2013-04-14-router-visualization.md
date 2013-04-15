---
layout: post
title: "Visualize Router Result using d3.js"
category: posts
---

<div class="media pull-left">
<a href="http://db.tt/JHZjMRlC">
<img src="http://db.tt/JHZjMRlC"
class="media-object noshadow"/>
</a>
</div>

This is another post about how we are using d3.js for our visualization
needs in our [Coursera
course](https://www.coursera.org/course/vlsicad). As part of the last
programming assignment for the course, we are asking students to design
and implement a router.  The core algorithm for the router resembles the
[A Star Search
Algorithm](http://en.wikipedia.org/wiki/A*_search_algorithm), with a few
more constraints. Students are supposed to take a file describing the
grid that they are operating on (along with its constraints and cost
model) and a list of nets (with starting and ending positions) that they
are supposed to route. They produce an output file describing the paths
to take to route each net.

Of course, with any path routing assignment, it makes sense to provide
some form of visualization. It is just more rewarding and intuitive to
_see_ the final routing than to try to imagine it by looking at a text
file with numbers.

A simple example on a 6x5 grid with two nets is shown above. The blue
cells show obstacles on the first layer (yes, this is a 3D problem) and
the orange cells show obstacles on the second layer. If you squint, you
can also see some gray cells -- those are cells that have some cost
associated with them.

A blue route specifies a path through the first layer. Correspondingly, an orange route specifies a path through the second layer. Paths can go up and down layers. When they do, we denote this using the cross symbol. A green square denotes the start of a route; a red square denotes the
end of a path.

So far we have tried it up to a 500 x 500 grid with about 20 paths and
it has been pretty responsive. This just shows how far SVG performance
has come in modern web browsers and how suitable it is for medium scale
visualization. Of course, real routing problems for industrial
benchmarks are much larger, but with the right tweaking, it is probably
possible to use Javascript and SVG to handle most of the visualization.

The code is available from this
[gist](https://gist.github.com/vazexqi/5385456) (it's about 600 lines of code so
it's not wise to embed it here) and it is licensed under the
Illinois/NCSA Open Source license. d3.js was quite instrumental in
producing this form of visualization. Using d3.js, I was able to
incrementally add features as we went along. It was easy (taking less
than an hour) to add a new feature as we were using the tool itself when
we implement our own version of the router. It was also easy to
[tweak](/posts/2013/04/04/visualize-d3.html) the layout to meet our
exact needs -- something that would have been quite hard or impossible
to do if we were using a library.

You can see a video of the tool in action below:

<iframe width="640" height="360"
src="https://www.youtube-nocookie.com/embed/4m0V6fpwROA?rel=0"
frameborder="0" allowfullscreen></iframe>

