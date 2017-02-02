
Android ActionBarCompat-Basic Sample
===================================

This in class activity is based on one of the Google offical code samples found
at https://github.com/googlesamples/android-ActionBarCompat-Basic.

Introduction
------------

The goal of this activity is to add some basic menu bar funcitonality to the sample
code.  You may need to install some additional Android components to get the system 
to build.

Pre-requisites
--------------

- Android SDK 25
- Android Build Tools v25.0.2
- Android Support Repository

Getting Started
---------------

After you clone the repository, open the project.  If you get any build errors, you 
may need to follow the prompts in the errors to install the missing libraries.

Once the project builds, look through the code to become familiar with it.  In 
particular, look at the menu xml file to see how that works.

You are going to add functionality to the three menu buttons.

- The first menu button should alternate starting and stopping the service included in the project.  
- The second menu button should open a URL entered into the EditText on screen in the default web browser.
- The third menu button should open a new Activity that you create.

For all of these, feel free to add fields/methods as you see fit to accomplish the tasks.

The first two tasks are relatively simple, while the third is much more open-ended and
requires you to create more files.  

After you successfully complete the first two tasks, create a new Activity screen that will be launched
by the third button that will:

- Allow a user to set a username, first name, and last name;
- When you return to the original Activity, display this information in a SnackBar.

When you are finished with this activity, zip up your project and submit it to the assignment
in Collab.

License
-------

Copyright 2016 The Android Open Source Project, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
