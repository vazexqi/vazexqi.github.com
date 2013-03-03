---
layout: post
title: "Gradle GUI"
category: posts
---

I'm really enjoying the [Gradle](http://www.gradle.org/) build tool for
my JVM-based projects. All of our [Coursera VLSI
CAD](https://www.coursera.org/course/vlsicad) course backend software is
built, tested and deployed using Gradle.

One feature that I just discovered recently is the [Gradle
GUI](http://www.gradle.org/docs/current/userguide/tutorial_gradle_gui.html)
feature.  In short, Gradle comes bundled with a very simple GUI, as can
be seen below:

<div class="media">
<a href="http://db.tt/bm9Tuquc">
<img src="http://db.tt/bm9Tuquc"
class="media-object noshadow"/>
</a>
</div>

At first glance, I was quite impressed by it since no other build tool
that I have used comes with a GUI built-in. It's probably useful for new
users of Gradle who might be less familiar with its options. Or it could
be useful for taking a quick glance at the list of tasks and their
descriptions for bigger projects.

Unfortunately, this feature seems to be less important and useful for
intermediate and advanced users of Gradle. As you use Gradle more, you
begin to _remember_ most of its usual commands and the names of your own
custom commands. Even if you don't remember them, it's usually easier to
just use the history function of your shell (up and down arrows) to
recall a particular command **or** to use a gradle shell
[plug-in](https://github.com/robbyrussell/oh-my-zsh/pull/428) for
auto-completion.

One feature that I think might be useful to add to the GUI for both new
and old users of Gradle would be some form of a dependency tree
structure. Those things are hard to "visualize" from just reading the
build.gradle file and having a graph of that (e.g., the Gradle Java
plug-in relationship between task
[diagram](http://www.gradle.org/docs/current/userguide/img/javaPluginTasks.png)) would be useful.


