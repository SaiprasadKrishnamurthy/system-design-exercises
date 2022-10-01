# Messenger System Design

## Functional Reqs:
* User-User direct messaging (Texts and Images)
* Group messaging (Texts and Images)

## Non Functional Reqs:
* 100M active users per day.
* Availability.
* Reliability.
* Consistency (it's ok for eventual, but not too slow. The messages will have to be delivered "near real time")

## Calculations
* 100M active users per day.
* Write: 100 messages per user per day (10,000000000 = 10 Billion messages per day)
* Read: Roughly thrice the write volume: (eg: in groups scenario, 1 message would be ready by 3 users = 30B reads per day.)

## Design:
![Design](./messenger_design.png?raw=true "Design")



    