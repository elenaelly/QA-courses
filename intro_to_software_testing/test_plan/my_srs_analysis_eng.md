The document defines the functional requirements as well as the overall design requirements for the GolfScore version 1.1 software.

The purpose of the program is to process the results of a golf tournament and generate reports showing who won the tournament and how the players performed on each course played.

GolfScore version 1.1. The program will display its name and version number on the screen during execution.

> Test cases:
> 1) Verify that the name and version number are displayed at run time.

GolfScore will be written in C or C++ and is designed to run on a PC running Windows 2000 or any later version.

> Test cases:
> 2) Written in C or C++
> 3) Runs on Windows 2000 PC
> 4) Runs on Windows XP
> 5) Runs on Windows Vista (NT 6.0) 2006
> 6) Works on Windows 7
> 7) Works on Windows 8
> 8) Runs on Windows 8.1
> 9) Runs on Windows 10
> 10) Runs on Windows 11

# 2 Functional Requirements
## 2.1 Description of the program

GolfScore is a program used to generate reports on the results of golfers in a golf tournament.

> Test cases:
> 11) a report on the results of golfers in a golf tournament is generated.

The input to the program will consist of a file containing two types of records, as described in Section 2.4 below.

> Test cases:
> 12) two types of records are created

The program output will consist of 3 reports as described in Section 2.5 below.

> Test cases:
> 13) The output of the program contains 3 reports.

The program is executed through a command line interface - there is no graphical interface associated with the application.

The program will run as a standalone executable and can be run from the command line, from an IDE (Integrated Development Environment), etc.

> Test cases:
> 14) The program runs as a standalone executable.
> 15) The program is launched from the command line.
> 16) The program is launched from the IDE
> 17) The program is launched from what else?

The input to the program will come from the record input file, and the output from the program will proceed to output record files in a printable format.

> Test cases:
> 18) The output format is printable.

Any errors in input or output will be handled as specified in Section 2.6 below.

> Test cases:
> 19) Errors are handled

## 2.2 GolfScore Challenge

GolfScore call format: >golf options filename output-directory

options one hyphen followed by one or more literal characters, no commas or spaces
                  
> Test cases:
> 20) Input starts without hyphens - not accepted
> 21) Input starts with two hyphens - not accepted
> 22) Input starts with a dash and contains one alphabetic character - accepted
> 23) Input starts with a hyphen and contains two alphabetic characters - accepted
> 24) Input contains comma - not accepted
> 25) Input contains space - not accepted
> 26) Input contains space and comma - not accepted
                  
                    -h Display help information on the screen; filename and output-directory are ignored if present
                    
> Test cases:
> 27) -h shows help information
> 28) -h with filename - filename is ignored
> 29) -h with output-directory - output-directory is ignored
> 30) -h with output-directory and filename - output-directory and filename are ignored
> 31) filename with one of the invalid characters (/\:*?«<>|) -
                  
                  
                    -c, -t, -g Generate course report (-c), tournament ranking report (-t), or golfer report (-g), respectively. Options can be combined, e.g. -cg

> Test cases:
> 31) -c reports the field
> 32) -t prints a tournament ranking report
> 33) -g prints the golfer's report
>34) -ct produces a field report and a tournament ranking report
> 35) -tc produces field report and tournament ranking report
> 36) -cg produces a course report and a golfer's report
> 37) -gc produces course report and golfer report
> 38) -tg produces Tournament Ranking Report and Golfer Report
> 39) -gt produces Tournament Ranking Report and Golfer Report
> 40) -ctg produces Tournament Ranking Report, Golfer Report and Course Report
>41) -cgt produces Tournament Ranking Report, Golfer Report and Course Report
>42) -tcg produces Tournament Ranking Report, Golfer Report and Course Report
>43) -tgc produces Tournament Ranking Report, Golfer Report and Course Report
>44) -gct produces Tournament Ranking Report, Golfer Report and Course Report
>45) -gtc produces Tournament Ranking Report, Golfer Report and Course Report
          
filename The name of the input file containing the data for reporting. This may be the full name; if no pathname is specified, the path where the program was launched will be used.

> Test cases:
> 46) specify the full path name
> 47) specify an unqualified pathname

output-directory The file directory name or path where the output files should be placed. 

If no pathname is specified, the path containing the filename will be used.

Examples: >golf -h Show help information
          >golf -ct c:\in.txt golfout Generate a course report and a tournament ranking report.
                                                            The entry is in the file in.txt in the root directory c:\,
                                                            the output should be placed in the c:\golfout directory.

> Test cases:
> 48) specify the full path name
> 49) specify an unqualified pathname

## 2.3 Program functionality

### 2.3.1 Tournament Assumptions

The number of golf courses specified for a tournament can be from 1 to 5.

> Test cases:
> 50) 1 field - accepted
> 51) 5 fields - accepted
> 52) 0 fields - not accepted
> 53) 55 fields - not accepted
> 54) -5 fields - not accepted

Each golfer is expected to play each course once.

> Test cases:
> 55) player plays 1 time - accepted
> 56) player will play 9 times / will not play - not accepted
> 57) player wins 100 times - accepted

The number of players participating in the tournament can be from 2 to 12.

> Test cases:
> 58) number of players 0 - not accepted
> 59) number of players -1 - not accepted
> 60) number of players 1 - not accepted
> 61) number of players 12 - accepted
> 62) number of players 13 - not accepted
> 63) number of players 2 - accepted

Each golf course has 18 holes and the value of each hole is 3, 4 or 5 strokes.

> Test cases:
> 64) golf course has 0 holes - not accepted
> 65) golf course has 19 holes - not accepted
> 66) golf course has 18 holes - accepted
> 67) hole value 0 - not accepted
> 68) hole 2 value - not accepted
> 69) hole value -2 - not accepted
> 70) hole 3 value - accepted
> 71) hole value 3.5 - not accepted
> 72) hole 4 value - accepted
> 73) hole value 5 - accepted
> 74) hole value -5 - not accepted

The player's score for each hole is determined as shown in Section 2.3.2 and is based on the number of under or over par shots made to complete that hole. Thus, the score and the number of strokes do not match.

> Test cases:
> 75) score and number of strokes do not match - accepted
> 76) score and number of strokes match - not accepted

The number of strokes a player has on a given golf course is the sum of the number of strokes on each of the 18 holes.

> Test cases:
> 77) A player's number of strokes on a given golf course is the sum of the number of strokes on each of the 18 holes. - accepted
> 78) The number of strokes a player makes on a given golf course is not the sum of the number of strokes on each of the 18 holes. - not acceptable

A golfer's score on a given golf course is the sum of the scores on each of the 18 holes.

> Test cases:
> 79) A golfer's score on a given course is the sum of the scores on each of the 18 holes. - accepted
> 80) A golfer's score on a given course is not the sum of the scores on each of the 18 holes. - not acceptable

A golfer's total tournament score is the sum of his or her points on all golf courses played.

> Test cases:
> 81) A golfer's total tournament score is the sum of his or her points on all golf courses played. - accepted
> 82) A golfer's total tournament score is not the sum of his or her scores on all golf courses played. - not acceptable

Note that the lower the golfer's number of strokes (relative to par), the higher his or her score on that hole.


### 2.3.2 Scoring

The points earned by a golfer for each hole played are as follows:
Number of hits Points
over par 0
denomination 1
1 less than the nominal 2
2 less than the nominal value 4
3 and further less than the face value 6

> Test cases:
> 83) number of hits over par - 0 points
> 84) the number of strokes is equal to the face value - 1 point
> 85) the number of strokes is 1 less than the face value - 2 points
> 86) number of strokes 2 less than par - 4 points
> 87) the number of strokes is 3 less than the face value - 6 points
> 88) the number of strokes is 4 less than the face value - 6 points


## 2.4 Data entry

The input to GolfScore will consist of a formatted text file containing the following entries in the order listed. Individual entries in the file end at the end of the line. The name of the input file is specified as a parameter in the program call line. [Cm. Section 2.2.]

> Test cases:
>89) Golfscore accepts formatted file
>90) The formatted file contains the entries in the specified order
> 91) The name of the input file is specified as a parameter in the program call line.

### 2.4.1 Course records

Course records are intended to describe the various courses used. One course record will be set for each golf course used in the tournament. Each entry contains the name of the course, an ID for the golfer entries and pars for each of its 18 holes. All course records come first in the input file.
Column 1 Empty
Columns 2-19 Course name
Column 20 One-character course ID
Columns 21-38 Value for holes 1-18, in order, one integer: 3, 4, or 5

> Test cases:
> 92) Each golf course has one course record.
> 93) Each entry contains the name of the course, an identifier for golfers' entries, and the value for each of its 18 holes.
> 94) All course records come first in the input file.

### 2.4.2 Delimiter record

The end of the course records will be indicated by a delimiter record in the following format.
Column 1 Nonempty

> Test cases:
> 95) The end of course records is indicated by a delimiter record in the following format.

### 2.4.3 Golfer records

There will be one Golfer's Record for each golfer on each course played; these entries can appear in any order. Each entry contains the golfer's name, course ID, and the number of golfer strokes on each of the 18 holes.
Column 1 Empty
Column 2 Course ID
Columns 3-9 are ignored
Columns 10-29 Golfer's name
Column 30 is ignored
Columns 31-48 Number of shots for each of the 18 holes

> Test cases:
> 96) Player Record - Record for every golfer on every course played

### 2.4.4 Delimiter record

The end of the golfer's records, and therefore the end of the input file itself, will also be determined by the delimiter record.
Column 1 Nonempty

> Test cases:
> 97) The end of the player's records is determined by the delimiter record.
> 98) The end of the input file is determined by the delimiter record.

## 2.5 Data output

GolfScore will generate up to 3 reports depending on the input parameters. The generated reports will be stored as text files in the directory specified in the program call line.


### 2.5.1 Tournament ranking report

A list of all golfers, with the player's name, points on each course, total tournament score, and that golfer's final standing (1st, 2nd, etc.). The list will be in descending order of the final result (i.e. the best golfer will be first). In the event of a tie, golfers will be listed in alphabetical order. The output file name for this report will be trank.rep.

> Test cases:
>99) Tournament Ranking Report Ranks Players in Descending Order
> 100) Golfers will be listed in alphabetical order in the Tournament Ranking Report in the event of a tie.
> 101) The name of the tournament rating report file is trank.rep.

### 2.5.2 Golfer's Report

This report is exactly the same as the Tournament Ranking report, except that golfers will be listed alphabetically by last name.
The output file name for this report will be golfer.rep.

> Test cases:
> 102) The Player Report will list golfers alphabetically by last name.
> 103) Player report name is golfer.rep.

### 2.5.3 Course report

This report will have one section for each golf course listed in the input course records. For each course, the report will show a list of all golfers with the golfer's name, the number of strokes for each hole for that course, and the total score for that course, listed in descending order by the number of golfers on that course.
The output file name for this report will be course.rep.

> Test cases:
> 104) In the course report, one section for each golf course listed in the input course records.
> 105) The course report for each course will show a list of all golfers with the golfer's name, the number of strokes for each hole for that course, and the total score for that course, listed in descending order by the number of golfers on that course.
> 106) The name of the course report is course.rep.

## 2.6 Error Handling

### 2.6.1 Input parameter errors

For any input parameter errors, including unrecognized parameters, the program will stop and display a message explaining the error.
The first field following the options is assumed to be the filename. If the file specified in the filename does not exist, an input parameter error will be reported.
The first field after the filename is assumed to be a directory. If the directory specified by the output directory does not exist, an input parameter error will be reported. If no output directory is specified, the directory containing the file name will be used.
Any field outside the output-directory field will be ignored and will not be considered an error.

### 2.6.2 Input errors

The following input data errors are checked:
i) Non-numeric data where numeric data is expected: the program will stop with the appropriate error message.
ii) nominal values ​​other than 3, 4 or 5: the program will stop with the appropriate error message.
iii) Any golfer who has two or more entries for the same course: additional entries after the first one will be ignored, a message will be displayed and processing will continue.

### 2.6.3 Output errors

If any of the requested output reports already exist, the program will pause and ask the user if the file should be overwritten. Prompt example: “File <file> already exists. Do you want to overwrite it? (Y/N)".
  
The user will then answer "Y" or "N".
If "Y", the output file will be overwritten;
if "N", the generated output will be discarded.
  
There will be a separate user prompt for each type of output report requested.
If the specified output report does not exist at the specified path, it will be created.
If any other errors occur when trying to write output files, the behavior of the program is not specified.

# 3. Results
GolfScore Executable
  
# 4. Performance Requirements
Once executed, GolfScore will complete processing within one minute.
