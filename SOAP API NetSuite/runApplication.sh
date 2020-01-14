#!/usr/bin/env bash
echo 'Building the application (it may take a while)...'
./gradlew --no-daemon --console=plain -q runApplication
