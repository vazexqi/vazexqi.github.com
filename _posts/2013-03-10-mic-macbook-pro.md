---
layout: post
title: "Using a Headset to Record on a MacBook Pro (2010)"
category: posts
---

I am in charge of producing some short 5 minute screencasts to introduce
some VLSI CAD tools for our
[Coursera](https://www.coursera.org/course/vlsicad) course. Our resident
audio/video (AV) expert recommended that I use an external headset to do
the recording to get the best possible sound. The particular headset
that he had? The _classy_ Califone 3066Av, as shown below (mine comes in
beige, which is even more old school).

<div class="media">
<a href="http://www.califone.com/products/3066.php">
<img src="http://www.califone.com/images/products/3066av.jpg"
class="media-object">
</a>
</div>

Now as you can see from the photo above, there are two cables: a red one
(mic) and black (headphones). Intuitively, one would expect to plug the
red cable into the "audio in" on the MacBook Pro and the black cable into
the "audio out". Here's what I did initially:


<div class="media">
<a href="http://db.tt/9L5rpcan">
<img src="http://db.tt/9L5rpcan"
class="media-object"/>
</a>
</div>

Unfortunately this did not work! My MacBook Pro was not able to pick up
any audio signal from the microphone. This caused some initial confusion
because I thought that the headset was broken. I verified that it was
indeed working by trying it out on a Windows machine which had a
dedicated sound card.

_So, what could be causing it to not work on a MacBook Pro?_

There are two interesting things that I discovered:

1. The audio-in jack on the MacBook Pro requires that the signal is
   amplified before coming in. If you are using the audio-in jack for
sound recording through some amplifier, then you are OK. However, it
will not work for a normal pheadset.
1. The audio-out jack on the MacBook Pro can _sometimes_ function as an
   dual audio-in and audio-out. This seems to work for the iPhone
headset. Plug the iPhone headset in and you can use it both for
recording and for listening.

_But neither of these discoveries help me solve my problem._

The only other solution is to get a USB headset. Those have been known
to work on the MacBook Pros. However, according to our resident AV
expert, most USB headsets are designed for VoIP applications and, thus,
contain active noise cancellation. When used for audio recording, they
produce muffled sound, or as he would call it "truly shit recordings".

_What was the final solution?_

Because I didn't want to produce "truly shit recordings", I needed to
find a different work around. Fortunately, I found an old Philips PSC805
Aurilium external [sound
card](http://download.p4c.philips.com/files/p/psc805_17/psc805_17_dfu_aen.pdf) lying around. I plugged the USB connection into my USB port and connected the headset to _its_ mic in and headphone jacks, like so:

<div class="media">
<a href="http://db.tt/0WENuZFQ">
<img src="http://db.tt/0WENuZFQ"
class="media-object"/>
</a>
</div>

The conclusion: if you are using an external non-USB headset with your
MacBook Pro, you might want to consider getting an external sound card
or something that can amplify the audio signal. It's not that the
headset doesn't work; it's that the MacBook Pro by itself does not
amplify the signals through the audio-in jack.

