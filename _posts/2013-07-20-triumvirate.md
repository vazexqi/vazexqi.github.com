---
layout: post
title: "Tmux, Vim and Zsh "
published: false
category: posts
---

It's been almost two weeks since I started working at Salesforce.com.
And so far I am really enjoying it. There are plenty of interesting and
challenging problems to work on. And we have a good set of internal
tools that we use to get our stuff down.

We work using a variety of different languages with a very large code
base. And, most of the time, the three tools that I have found
indispensable are tmux, vim (or your favorite terminal editor) and zsh
(with the oh-my-zsh plug-ins).

In fact, I would say that these three tools, when adequately configured,
are the most useful things that one can have in their repertoire of
developer tools. They work almost everywhere -- this is very important
when you are not sure which machine you need to be working on locally or
remotely. They are good are what they do -- handling everything from the
simple cases to the more complex ones where loading full fledge GUI
application is just not feasible.

So if you have any time at all, I think it is a good investment to start
learning how to use these tools. The learning curve might be steep at
first but you can always start small and move on from there. All of
these tools that I will be talking about are easily configured. To get
you started, I've shared my configuration files in my
[dotfiles](https://github.com/vazexqi/dotfiles) repository on Github.

Let's start with the most essential, tmux.

h1. tmux

tmux is a _terminal multiplexer_.

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

When I am done at home, I just detach tmux and reattach it again the
next day at the office.

This is not limited to working at the office and at home. I can
reconnect to a terminal on a remote machine from any other terminal and
have access to all my programs and the state that they were in.

As a bonus, because I can _multiplex_ between different programs from a
single terminal, I eliminate the need to open multiple terminal windows.
Opening multiple terminal windows for each new program gets unwieldy
pretty quickly.

There is at least one other alternative to tmux:
[screen](http://en.wikipedia.org/wiki/GNU_Screen) which has been around
for a longer time. It is worth learning simply for the fact that you can
count on it being installed on most systems whereas you would probably
need to install tmux on your own.

Regardless of which one you choose to learn, being able to use at least
one terminal multiplexer is a good investment especially if you
frequently use different machines to work on.

