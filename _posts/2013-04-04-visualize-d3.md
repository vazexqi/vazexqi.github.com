---
layout: post
title: "Visualizations using D3.js"
category: posts
---

In my last
[post](http://vazexqi.github.com/posts/2013/03/20/visualize-netlist.html),
I mentioned how I was using the Google Scatter chart API to visualize
some data that was pertinent for our [VLSI CAD: Logic to
Layout](https://www.coursera.org/course/vlsicad) course.

Well, it turns out that Google Scatter chart has some drawbacks -- like
all blackbox software, it's not really customizable. It's great for
quick-and-dirty charting but when you need something very specific,
there is just no way to get it done.

In our case, we wanted a very particular way of displaying the grid
lines. Instead of the regular interval of 10, we need something more
unusual, i.e., 12.5. The reason for this is because of the way the
algorithm works. It subdivides our 100x100 region in 8x8 regions where
each region has height and width of 12.5. These 8x8 regions are
important because they are where the algorithm should place things. If
the algorithm is carried out correctly, then each of those 8x8 regions
should have approximately the same amount of _gates_ in them.

There just wasn't a way to accomplish this using the current Google
Scatter Chart API. Others have
[requested](https://groups.google.com/forum/?fromgroups=#!topic/google-visualization-api/kH3XwfQSFE8) for this as well.

Well, enter [d3.js](http://d3js.org). For those unfamiliar with d3, it's
one of the best visualization libraries out there for Javascript –- and,
trust me, there are a lot of visualization libraries for Javascript. In
my opinion, what really sets d3 apart from the rest is the _conceptual
integrity_ of its design. Conceptual Integrity is a term made popular by
Fred Brooks in _The Mythical Man-month_. It refers to a software that is
properly designed such that every component that you examine has a
cohesive design that resonates with the other components. If that sounds
too _meta_ for you, then just think of it as very well designed piece of
software with very few hidden surprises. Once you grasp how it works,
the same ideas permeate the entire design; there are very few corner
cases.

While this is my first time using d3, I had used its predecessor,
[Protovis](http://mbostock.github.com/protovis/). I was very happy with
it because it was flexible enough to handle everything that we needed.
Here is the particular visualization that we had to do with it for my
health instrumentation [project](http://db.tt/HNP8YH2w):

<div class="media">
<a href="http://db.tt/TLVlgykM">
<img src="http://db.tt/TLVlgykM"
class="media-object noshadow"/>
</a>
</div>

The figure above shows the amount of exercise we were getting for each
hour of the day for 7 weeks. The amount of exercise was measured using a
pedometer. A mini pie chart is drawn for each active hour. The size of
the pie chart corresponds directly with the amount of exercise. We used
a pie chart because we wanted to also distinguish _rigorous_ activity
from just _normal_ activity. The darker sections of the pie chart
represent rigorous activity.

Anyway, before I digress, here's the end result of using d3. If you
compare it with the previous post, there is very little visual
difference, which is good. The point is to remain consistent with the
previous visualization while being able to add important visual cues.

<div class="media">
<a href="http://db.tt/Xgb68Qd4">
<img src="http://db.tt/Xgb68Qd4"
class="media-object noshadow"/>
</a>
</div>

The main advantage d3 has is the fact that you can control everything
from the axis position and title to the way that you want the graph
rendered, animated and displayed. If you scrutinize closely, you will
see that the blue dots are segregated into the 8x8 regions pretty
nicely. Had we not been able to control the gridlines, this visual cue
would have been harder to detect.

The code is available from
[https://gist.github.com/vazexqi/5316324](https://gist.github.com/vazexqi/5316324).
I am fairly new to Javascript so the code might be less idiomatic that I
like. But I'm getting there :-)

I already have another visualization done using d3 and I will post about
it when it is finally completed. Needless to say, d3 is now part of my
arsenal of visualization toolkits.


