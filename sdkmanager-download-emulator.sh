#!/bin/bash

/usr/bin/expect -c '
set timeout -1;
spawn '"${ANDROID_HOME}"'/tools/bin/sdkmanager "system-images;android-25;google_apis;x86";
  expect {
    "y/N" { exp_send "y\r" ; exp_continue }
    eof
  }
'