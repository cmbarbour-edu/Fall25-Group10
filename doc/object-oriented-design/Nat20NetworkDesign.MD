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
|      |         |                     |           |
|      |         |                     |           |

## 1. Product Overview
LocalHarvest Hub is a simple, comprehensive, easy to use web app with the goal of connecting consumers to locally grown produce. Farmers and customers make use of the centralized platform to meet their needs. 
Farmers create and publish produce boxes, customers subscribe any available boxes that they are interested in, either as a one-off or recurring subscription.

## 2. Use Cases
### 2.1 Use Case Model
![Use Case Model](https://github.com/csc340-uncg/f25-team0/blob/main/doc/Object-Oriented-Design/use-case.png)

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

#### 2.2.2 Actor: Customer
##### 2.2.2.1 Sign Up
A customer can sign up to create their profile with their name, email, password, and address. Emails must be unique.
##### 2.2.2.2 Log In
A customer shall be able to sign in using their registred email and password. After logging in, the customer shall be directed their dashboard where they see an overview of their subscriptions.
##### 2.2.2.3 Browse Produce Boxes
A customer shall be able to view available produce boxes. They can do this from the home page or using a search function. They can also filter boxes by name, descriptions, or farm. They will also be able to select one box and view more details.
##### 2.2.1.4 Subscribe to Produce Box
Upon selecting a box, a customer shall be able to subscribe for the box using a one-click action. This box will then appear on their dashboard, and they will be able to ammend the subscription.
##### 2.2.1.5 Review Produce Box
A customer may write a review for a box they subscribed to. They will be able to rate the box based on freshness and delivery.

## 3. UML Class Diagram
![UML Class Diagram](https://github.com/csc340-uncg/f25-team0/blob/main/doc/object-oriented-design/class-diagram.png)
## 4. Database Schema
![UML Class Diagram](https://github.com/cmbarbour-edu/Fall25-Group10/blob/cbarbour-milestone4/doc/object-oriented-design/schema.png)