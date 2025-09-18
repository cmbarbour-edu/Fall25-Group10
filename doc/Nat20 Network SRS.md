# Software Requirements Specification
## For <project name>

Version 0.1  
Prepared by <author>  
<organization>  
<date created> 

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Introduction](#1-introduction)
  * 1.1 [Document Purpose](#11-document-purpose)
  * 1.2 [Product Scope](#12-product-scope)
  * 1.3 [Definitions, Acronyms and Abbreviations](#13-definitions-acronyms-and-abbreviations)
  * 1.4 [References](#14-references)
  * 1.5 [Document Overview](#15-document-overview)
* 2 [Product Overview](#2-product-overview)
  * 2.1 [Product Functions](#21-product-functions)
  * 2.2 [Product Constraints](#22-product-constraints)
  * 2.3 [User Characteristics](#23-user-characteristics)
  * 2.4 [Assumptions and Dependencies](#24-assumptions-and-dependencies)
* 3 [Requirements](#3-requirements)
  * 3.1 [Functional Requirements](#31-functional-requirements)
    * 3.1.1 [User Interfaces](#311-user-interfaces)
    * 3.1.2 [Hardware Interfaces](#312-hardware-interfaces)
    * 3.1.3 [Software Interfaces](#313-software-interfaces)
  * 3.2 [Non-Functional Requirements](#32-non-functional-requirements)
    * 3.2.1 [Performance](#321-performance)
    * 3.2.2 [Security](#322-security)
    * 3.2.3 [Reliability](#323-reliability)
    * 3.2.4 [Availability](#324-availability)
    * 3.2.5 [Compliance](#325-compliance)
    * 3.2.6 [Cost](#326-cost)
    * 3.2.7 [Deadline](#327-deadline)

## Revision History
| Name     | Date    | Reason For Changes        | Version   |
| -------- | ------- | ------------------------- | --------- |
| Caleb    | 9/17    | Initial SRS document      | 1.0       |
| Nehemiah | 9/17    | System Admin Requirements | 1.1       |
| Caleb    | 9/18    | DM Requirements           | 1.2       |
|          |         |                           |           |

## 1. Introduction

### 1.1 Document Purpose
The purpose of this Software Requirements Specification (SRS) is to define the requirements for the Nat20 Network, a Dungeons & Dragons (D&D) campaign finder and manager. This document is intended for developers, testers, stakeholders, and system administrators involved in building and maintaining the application. It provides clarity on the system’s goals, features, and constraints to ensure alignment between all parties.

### 1.2 Product Scope
The purpose of Nat20 Network is to connect D&D players with dungeon masters and other players to enjoy campaigns. It is intended to provide a clear and easy to use format for dungeon masters to create and share campaigns that they have created with players who might be interested in joining said campaigns. The system is a web-based application aimed at simplifying the process of creating a campaign and finding players who wish to join the group online.

### 1.3 Definitions, Acronyms and Abbreviations
| Reference   | Definition                                                                                                                                                                          |
|-------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Java        | A programming language originally developed by James Gosling at Sun Microsystems. We will be using this language to build the backend service for LocalHarvest Hub                  |
| Postgresql  | Open-source relational database management system.                                                                                                                                  |
| SpringBoot  | An open-source Java-based framework used to create a micro Service. This will be used to create and run our application.                                                            |
| Spring MVC  | Model-View-Controller. This is the architectural pattern that will be used to implement our system.                                                                                 |
| Spring Web  | Will be used to build our web application by using Spring MVC. This is one of the dependencies of our system.                                                                       |
| API         | Application Programming Interface. This will be used to interface the backend and the fronted of our application.                                                                   |
| HTML        | Hypertext Markup Language. This is the code that will be used to structure and design the web application and its content.                                                          |
| CSS         | Cascading Style Sheets. Will be used to add styles and appearance to the web app.                                                                                                   |
| JavaScript  | An object-oriented computer programming language commonly used to create interactive effects within web browsers. Will be used in conjuction with HTML and CSS to make the web app. |
| RESTful API | REpresentational State Transfer API. This will be the architecture that the external API our system uses has implemented.                                                           |
| VS Code     | An integrated development environment (IDE) for Java. This is where our system will be created.                                                                                     |
| D&D/DND/DnD | Dungeons and Dragons, a tabletop role-playing game developed by Wizards of the Coast.                                                                                               |
| DM          | The dungeon master, also called the game master. This is the person responsible for running the D&D campaign for their group of players.                                            |
|             |                                                                                                                                                                                     |

### 1.4 References
* [Spring Boot Guides](https://spring.io/guides)
* [BootStrap HTML Toolkit](https://getbootstrap.com/docs/5.3/getting-started/introduction/)

### 1.5 Document Overview
This document outlines the Nat20 Network project requirements. Section 2 provides a high-level product overview, including major functions, constraints, user types, and dependencies and section 3 specifies detailed functional and non-functional requirements, including interfaces, performance, security, and compliance considerations.

## 2. Product Overview
Nat20 Network is a web-based application designed to help D&D players, both new and old, find online campaigns that are open for joining. Players can browse available campaigns, request to join them, create characters, and leave reviews on players and DMs that they have had in the past. DMs can manage their campaigns and players in their group, along with viewing monster status blocks and their player's characters. This system supports multiple user roles including players, DMs, and administrators, each with their own unique experience designed for their specific use-case.

### 2.1 Product Functions
Users will be able to create accounts and create characters for DnD campaigns.
Users will be able to create campaigns for others to join via a request to join system.
Users will be able to view DM profiles, and vice versa.
Admins will be able to view user reports and feedback.

### 2.2 Product Constraints
User interface must support multiple user roles with appropriate permissions, the platform must provide reliable uptime for campaign discovery. Standards must comply with community safety standards (moderation of inappropriate content), and scalable campaign hosting and account management must be supported.
  
### 2.3 User Characteristics
* There will be a main user, which is split into two categories: Player and DM. 
* Users can be both, but they will be logged in as a player unless they create their own campaign and start inviting players to join via a "Campaigns" tab.
* Admins are separate from the Users, meaning a user cannot be an admin.

### 2.4 Assumptions and Dependencies
* There is the assumption that the APIs we plan to use may cost this project to take up more space than anticipated, as well as the program being dependent on one of the APIs we plan to use, which is the DnD Player's Handbook API. 

## 3. Requirements

### 3.1 Functional Requirements 
* FR0: The system shall allow users to create an account as either a player or a DM.
* FR1: The system shall allow users to modify their profiles on their own at any time.
* FR2: The system shall allow DMs to create campaigns that are open to the public or available by invite only.
  * Each campaign will have additional information such as what edition is being used and a short description of its contents.
* FR3: The system shall allow DMs to view user-specific data associated with their previous play experiences.
* FR4: The system shall allow DMs to respond to reviews from their previous players regarding the behaviour and performance of the DM.
* FR5: The system shall allow SysAdmins to promote or demote users between roles (Player ↔ DM).
* FR6: The system shall allow SysAdmins to deactivate or delete user accounts.
* FR7: The system shall allow SysAdmins to reset passwords and assist with account recovery.
* FR8: The system shall allow SysAdmins to review and remove inappropriate or inactive campaigns.
* FR9: The system shall allow SysAdmins to moderate reported reviews and remove offensive or fraudulent content.


#### 3.1.1 User interfaces
Web pages using HTML, CSS, JavaScript, and an API.

#### 3.1.2 Hardware interfaces
* We plan on having the website be as straight-forward as possible, as we want to have as smooth of a process as possible with character creation and campaign creation. As for the devices that this program will be supported on, we've decided to go with computers only. We do not plan on making a mobile version of this program.

#### 3.1.3 Software interfaces
* Java JDK 21
* PostgreSQL 17
* Spring Boot 3.5.5
* RESTful API
* D&D 5e SRD API
* GraphQL September 2025 release

### 3.2 Non Functional Requirements 

#### 3.2.1 Performance
* NFR1: The Nat20 Network system shall consume less than 300 MB of memory.
* NFR2: A novice player shall be able to create a character in under 30 minutes.
* NFR3: An advanced player shall be able to create a character in under 15 minutes.
* NFR4: A novice DM should be able to create a new campaign in under 15 minutes. 
* NFR5: An advanced DM shall be able to create a new campaign in under 10 minutes. 

#### 3.2.2 Security
* The system is going to be available only to those who have created and activated an account.

#### 3.2.3 Reliability
Specify the factors required to establish the required reliability of the software system at time of delivery.

#### 3.2.4 Availability
NFR7: The system is going to be available at all times of the day. Maintenance shall be scheduled for low user hours such as 3 A.M EST to reduce the impact that it will have on user experience. 

#### 3.2.5 Compliance
Specify the requirements derived from existing standards or regulations

#### 3.2.6 Cost
NFR8: The expected monetary cost of the project is $0

#### 3.2.7 Deadline
* NFR9: The final product must be deployed by December 2025.
