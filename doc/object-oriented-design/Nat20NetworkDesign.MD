# Nat20 Network - Software Design 

Version 1  
Prepared by Caleb Barbour, Bryson Parsons, and Nehemiah McClain\
Nat20 Network\
Oct 16, 2025

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Product Overview](#1-product-overview)
* 2 [Use Cases](#2-use-cases)
  * 2.1 [Use Case Model](#21-use-case-model)
  * 2.2 [Use Case Descriptions](#22-use-case-descriptions)
    * 2.2.1 [Actor: Dungeon Master](#221-actor-dungeon-master)
    * 2.2.2 [Actor: Customer](#222-actor-customer) 
* 3 [UML Class Diagram](#3-uml-class-diagram)
* 4 [Database Schema](#4-database-schema)

## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
|  Caleb  |10/16     | Initial Design      |    1      |
|Brycen|  10/21       |  Customer uses   |   3.1        |
|      |         |                     |           |

## 1. Product Overview
The Nat20 Network is a simple, easy to use web app with the goal of connecting DnD players and DMs together. DMs and players make use of the centralized platform to meet their needs, which is of course, creating and joining campaigns, with the players not needing to create or copy a created character sheet on the website. 
DMs create and publish DnD campaigns, and players request to join any available campaigns that they are interested in, which is then accepted by the DM.

## 2. Use Cases
### 2.1 Use Case Model
![Use Case Model](https://github.com/cmbarbour-edu/Fall25-Group10/blob/nmcclain-milestone4/doc/object-oriented-design/nat20use-case.png)

### 2.2 Use Case Descriptions

#### 2.2.1 Actor: Dungeon Master
##### 2.2.1.1 Sign Up
A DM can sign up for an account with their username, email, and password. Emails must be unique.
##### 2.2.1.2 Log In
A DM shall be able to sign in using their email and password. After logging in, the DM shall be taken to their dashboard, where they can create and manage campaigns, view campagin requests, view player feedback, and browse manuals.
##### 2.2.1.3 Update Profile
A DM shall be to modify their profile by going to their profile page. Here, they can change their email, password, and username. DMs can also delete their account.
##### 2.2.1.4 Create Campaigns
A DM shall be able to create a new campaign listing. They must provide a campaign name, description, shortened description, what edition is being used, and the privacy of the campaign (public or private). This campaign will be associated with the DM, as well as the players that join the campaign. 
##### 2.2.1.4 View Customer Stats
A DM shall be able to view several statistics such as the number of times a player has been kicked from a campaign and the highest level character they have played.

#### 2.2.2 Actor: Player
##### 2.2.2.1 Sign Up
A player can sign up to create their profile with a username, email, and password. Emails must be unique.
##### 2.2.2.2 Log In
A player shall be able to sign in using their registred email and password. After logging in, the player shall be directed their dashboard where they see an overview of their subscriptions.
##### 2.2.2.3 Browse Campaigns
A player shall be able to view available DnD campaigns. They can do this from the home page or using a search function. They can also filter boxes by name, descriptions, or farm. They will also be able to select one box and view more details.
##### 2.2.1.4 Request to Join Campaigns
Upon selecting a campaign, a player shall be able to request to join a campaign using a two click system, which will include a description as to why they want to join the campaign. The campaign will then appear on their dashboard once the DM has accepted the join request, and they will be able to ammend their joining of the campaign if they so wish. They can also be forcibly removed from the campaign by the DM, and the player will recieve a notification if they are removed.
##### 2.2.1.5 Review Campaigns
A player may write a review for a campaign they joined. They will be able to rate the campaign based on their experience in the campaign.

#### 2.2.3 Actor: SysAdmin
##### 2.2.3.1 Sign Up
A SysAdmin can sign up to create their profile with their name, email, password, and address. Emails must be unique.
##### 2.2.3.2 Log In
A SysAdmin shall be able to sign in using their registred email and password. After logging in, the SysAdmin shall be directed their dashboard, where they can investigate reviews, review and remove campaigns, and view usage statistics.
##### 2.2.3.3 Update Profile
A Sysadmin shall be able to modify their profile by going to their profile page. Here, they can change their email, password, and username. 
##### 2.2.3.4 View Usage Statistics
A SysAdmin will be able to view statistics about total users, total campaigns, average players in a campaign, and how many current users are online.
##### 2.2.3.5 Investigate Reported Reviews
A SysAdmin can look through submitted reports to determine if a player or DM needs to be removed from a campaign or removed completely.
##### 2.2.3.6 Review/Remove Campaigns
A SysAdmin can view all campaigns and can also remove campaigns for inappropriate content or violating any other terms of service.

## 3. UML Class Diagram
![UML Class Diagram](https://github.com/csc340-uncg/f25-team0/blob/main/doc/object-oriented-design/class-diagram.png)
## 4. Database Schema
![UML Class Diagram](https://github.com/cmbarbour-edu/Fall25-Group10/blob/cbarbour-milestone4/doc/object-oriented-design/schema.png)