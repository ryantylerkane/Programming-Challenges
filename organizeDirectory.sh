# write your code in Bash
#!/bin/bash

#We can create the directories before traversing each file as we are guaranteed at least one file of each extension category.
mkdir -p images
mkdir -p music
mkdir -p videos

for file in * #For each file in the current directory check its extension and move to proper subdirectory or remove it if it is a log file.
do
    if [[ $file == *.mp3 || $file == *.flac ]]
    then
            mv $file music
    elif [[ $file == *.jpg || $file == *.png ]]
    then
            mv $file images
    elif [[ $file == *.avi || $file == *.mov ]]
    then 
            mv $file videos
    elif [[ $file == *.log ]]
    then
            rm $file #Remove the log file from the directory.
    fi
done