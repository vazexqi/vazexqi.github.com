---
layout: post
title: "tmux, vim and zsh"
published: false
category: posts
---

It's been about three weeks since I started working at Salesforce.com.
And so far I am really enjoying it. There are plenty of interesting and
challenging problems to work on. And we have a good set of internal
tools that we use to get our stuff down.

We work using a variety of different languages with a very large code
base. And, most of the time, the three tools that I have found
indispensable are tmux (or your favorite terminal multiplexer), vim (or
your favorite terminal editor) and zsh (with the oh-my-zsh plug-ins).

In fact, I would say that these three tools, when adequately configured,
are the most useful things that one can have in their repertoire of
developer tools. They work almost everywhere -- this is very important
when you are not sure which machine you need to be working on locally or
remotely. They are good are what they do -- handling everything from the
simple cases to the more complex ones where loading full fledge GUI
application through the internet is just not feasible.

So if you have any time at all, I think it is a good investment to start
learning how to use these tools. I started off during my years at the
university. The initial learning curve might be steep but you can always
start small and move on from there. All of these tools that I will be
talking about are easily configured. To get you started, I've shared my
configuration files in my
[dotfiles](https://github.com/vazexqi/dotfiles) repository on Github.

Let's start with the most essential, tmux.

## tmux

[tmux](http://tmux.sourceforge.net/) is a _terminal multiplexer_.

> It lets you switch easily between several programs in one terminal,
> detach them (they keep running in the background) and reattach them to a
> different terminal.

Why is this useful? 

Everyday, I get to my office, open the terminal at my workstation and
hack away. I open several programs in the terminal -- usually a
combination of vim, perforce, etc. I do my work and go home. Sometimes,
at home I would like to reconnect to my workstation and continue working
from home. tmux lets me _reattach_ to the same terminal at my
workstation so I get the same opened programs. So I can manipulate all
my opened programs easily.

When I am done at home, I just detach tmux and I can reattach it again
the next day at the office.

This is not limited to working at the office and at home. I can
reconnect to a terminal on a remote machine from any other terminal and
have access to all my programs and the state that they were in.

As a bonus, because I can _multiplex_ between different programs from a
single terminal, I eliminate the need to open multiple terminal windows.
Opening multiple terminal windows for each new program gets unwieldy
pretty quickly. How often do you see your co-workers desktops littered
with a ton of open terminal windows without a clear way to identify the
right one quickly?

There is at least one other alternative to tmux:
[screen](http://en.wikipedia.org/wiki/GNU_Screen) which has been around
for a longer time. It is worth learning simply for the fact that you can
count on it being installed on most systems whereas you would probably
need to install tmux on your own.

Regardless of which one you choose to learn, being able to use at least
one terminal multiplexer is a good investment especially if you
frequently use different machines to work on. I would recommend reading
[Pragmatic Tmux](http://pragprog.com/book/bhtmux/tmux) to get up to
speed quickly on tmux. Here's a video of the author, Brian Hogan,
promoting the usefulness of tmux:

<iframe width="420" height="315"
src="//www.youtube.com/embed/JXwS7z6Dqic" frameborder="0"
allowfullscreen></iframe>

## vim

I'm not going to turn this into a vim vs emacs post so you can just pick
whichever text editor you are comfortable with. In fact, if you prefer
to use nano or pico, that is probably fine too. You just need to be able
to use a terminal-based (not GUI-based) editor fairly well.

I am not bashing full-featured text editors such as TextMate or its,
now-more-sexy counterpart, Sublime Text. Those GUI editors are wonderful
and I use them too. However, sometimes you just don't have the luxury of
installing and configuring a GUI-based too. What if the computer you are
trying to connect to doesn't allow to load a UI instance? You need some
fallback plan.

vim (and other venerable text editors) are almost always around on any
\*nix based machines. Therefore you can always rely on them on remote
machines especially when you are trying to edit some configuration file.

Another advantage that I have found with such editors is that they are
really fast compared to full IDEs. Now, don't get me wrong, I think IDEs
are indispensable (heck, I worked on creating useful tools that plug
into Eclipse as part of my PhD). However, sometimes they can be just too
slow. And for dynamic languages such as JavaScript, current IDEs do not
offer any advantage over a well-configured text editor. The usual
features that IDEs have for statically-typed languages such as Java or
C\# -- code completion, call hierarchy, find all references, etc -- are
not available for JavaScript meaning that you are pretty much left
with regular expression search.

## zsh

