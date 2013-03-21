---
layout: post
title: "Visualizing Netlist files using Google Scatter Plot"
category: posts
---

One of the assignments for our [VLSI CAD: Logic to
Layout](https://class.coursera.org/vlsicad-001/class/index) will require
students to write a placer. A placer is basically a program that
determines the best layout for placing gates on a chip subjected to
certain constraints such as minimum wire length, even distribution on
the chip, etc.

It turns out that the file format for describing the final placement is
very simple:

{% highlight ruby %}
# Each line has three components: <gate id> <x-position> <y-position>
1 75 93.75
2 14.5833 62.5
3 19.7917 87.5
4 47.3111 64.5833
5 62.5 25
6 43.0778 87.5
7 44.5839 45.5646
8 31.25 87.5
9 25 45.0639
10 42.487 23.2346
11 87.5 22.8231
12 62.5 40.625
13 25 21.8506
14 73.4375 89.0625
15 68.75 62.5
16 88.2292 66.4583
17 88.5634 88.7695
18 88.125 44.1667
{% endhighlight %}

Now a very effective way to quickly check if your placer is working is
to _visualize_ it. Now, there are many ways to visualize such things.
Most engineers would resort to using R or Matlab (or its open source
equivalent, Octave). However, with an enrollment of 15, 000+ students,
we want a means that is the easiest.

What can be easier than using Javascript in the browser? Everyone has a
browser (or two, or three) installed on their machine. It also turns out
there are a ton of great visualization frameworks out there for
Javascript. I chose the simplest one: [Google
Charts](https://developers.google.com/chart/).

I've used an earlier version of the Google Charts API to visualize some
performance benchmarks and it was pretty easy to set up. However, that
required using other language (Scala, Groovy) to read in a file and
generate the data.

Can we do it all in Javascript? That is, can we read in a file directly
from Javascript? With HTML 5 we
[can](http://www.html5rocks.com/en/tutorials/file/dndfiles/).

So by combining modern HTML5 features and a great visualization library,
we get useful visualizations for _free_. And turns out Javascript and
SVG is fast enough in the web browser to display around 12, 000 points
with no problems.

Here it is in action:

<div class="media">
<iframe width="420" height="315"
src="http://www.youtube-nocookie.com/embed/aPEjCaRS-HE?rel=0"
frameborder="0" allowfullscreen></iframe>
</div>

You can find the code on my Github page
[here](https://github.com/vazexqi/CourseraVLSICAD/blob/704aee5070ef890362e1abd3d92356d591d3475d/NetlistVisualization/visualize.html).

