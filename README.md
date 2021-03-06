# BundleCalculator Modification 3.0

## Main tech stacks and tools
- Lombok
- Junit5
- Grandle
- Java 8

## Context
Social media Influencers have been basing the price of their social media post on a single post basis. So If a brand required 10 posts (for example spread over a period) then they would be charged 10x the cost of a single post. One company has decided to allow social media influencers to sell posts in bundles and charge the brand on a per bundle basis. So if the Influencer sold image based posts in bundles of 5 and 10 and brand ordered 15 they would get a bundle of 10 and a bundle of 5.

The company currently allows the influencer to monitize the following submission formats:

Submission format | Format code | Bundles
----------------- | ----------- | -------
Image | IMG | 5 @ $450 10 @ $800
Audio | Flac | 3 @ $427.50 6 @ $810 9 @ $1147.50
Video | VID | 3 @ $570 5 @ $900 9 @ $1530

## Task

Given a brands order, you are required to determine the cost and bundle breakdown for each submission format. For simplicity, each order should contain the minimal number of bundles.

### Input:
Each order has a series of lines with each line containing the number of items followed by the submission format code
An example input:
```
10 IMG
15 FLAC
13 VID
```

### Output:
A successfully passing test(s) that demonstrates the following output: (The format of the output is not important)
```
10 IMG $800
  1 x 10 $800
15 FLAC $1957.50
  1 x 9 $1147.50
  1 x 6 $810
13 VID $2370
  2 x 5 $1800
  1 x 3 $570
```



## How to run this project
1. Clone this repository into local computer
2. Open the project folder with the intellij IDEA.
3. Change the Java version to Java 8 in intellij. <br>
4. Go to the src/main/java/com/jr/bundlecalculatorapp/ open the BundleCalculatorApplication.java and run the main function.
## Unit Tests Results
At this time, the unit test reached 100% coverage of the project. 
<div align="left">
	<img src="https://github.com/Rick-Qian259/BundleCalculator/blob/master/Images/TestCoverage.jpg" alt="Editor" width="700" height="400">
</div>

<!-- ## The project directory structure changes
I redesigned the project logic and delete the last edition's brand, image, video, flac classes. Replaced them with a Enum class brand, it simplified programm logic.
The comparsion shows below.
<div align="left">
	<img src="https://github.com/Rick-Qian259/BundleCalculator/blob/master/Images/directory%20structure1.0.jpg" alt="Editor" width="400" height="400">
	<img src="https://github.com/Rick-Qian259/BundleCalculator/blob/master/Images/directory%20structure2.0.jpg" alt="Editor" width="400" height="400">
</div> -->
