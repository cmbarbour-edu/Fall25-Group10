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
Describe the purpose of the SRS and its intended audience.

### 1.2 Product Scope
The purpose of Nat20 Network is to connect D&D players with dungeon masters and other players to enjoy campaigns. It is intended to provide a clear and easy to use format for dungeon masters to create and share campaigns that they have created with players who might be interested in joining said campaigns. The system is a web-based application aimed at simplifying the process of creating a campaign and finding players who wish to join the group online.

### 1.3 Definitions, Acronyms and Abbreviations
| Reference  | Definition                                                                                                                                                                         |
|------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Java       | A programming language originally developed by James Gosling at Sun Microsystems. We will be using this language to build the backend service for LocalHarvest Hub                 |
| Postgresql | Open-source relational database management system.                                                                                       |
| SpringBoot | An open-source Java-based framework used to create a micro Service. This will be used to create and run our application.                                                           |
| Spring MVC | Model-View-Controller. This is the architectural pattern that will be used to implement our system.                                                                         |
| Spring Web | Will be used to build our web application by using Spring MVC. This is one of the dependencies of our system.                                                                      |
| API        | Application Programming Interface. This will be used to interface the backend and the fronted of our application.                                                                  |
| HTML       | Hypertext Markup Language. This is the code that will be used to structure and design the web application and its content.                                                         |
| CSS        | Cascading Style Sheets. Will be used to add styles and appearance to the web app.                                                                                         |
| JavaScript | An object-oriented computer programming language commonly used to create interactive effects within web browsers. Will be used in conjuction with HTML and CSS to make the web app. |
| RESTful API | REpresentational State Transfer API. This will be the architecture that the external API our system uses has implemented.                                                           |
| VS Code    | An integrated development environment (IDE) for Java. This is where our system will be created.                                                                                    |
| D&D/DND/DnD | Dungeons and Dragons, a tabletop role-playing game developed by Wizards of the Coast.                                                                                         |
| DM          | The dungeon master, also called the game master. This is the person responsible for running the D&D campaign for their group of players.                                            |
|        |                                                                                       |

### 1.4 References
* [Spring Boot Guides](https://spring.io/guides)
* [BootStrap HTML Toolkit](https://getbootstrap.com/docs/5.3/getting-started/introduction/)

### 1.5 Document Overview
Describe what the rest of the document contains and how it is organized.

## 2. Product Overview
Nat20 Network is a web-based application designed to help D&D players, both new and old, find online campaigns that are open for joining. Players can browse available campaigns, request to join them, create characters, and leave reviews on players and DMs that they have had in the past. DMs can manage their campaigns and players in their group, along with viewing monster status blocks and their player's characters. This system supports multiple user roles including players, DMs, and administrators, each with their own unique experience designed for their specific use-case.

### 2.1 Product Functions
Summarize the major functions the product must perform or must let the user perform. Details will be provided in Section 3, so only a high level summary (such as a bullet list) is needed here. Organize the functions to make them understandable to any reader of the SRS. A picture of the major groups of related requirements and how they relate, such as a top level data flow diagram or object class diagram, is often effective.

### 2.2 Product Constraints
This subsection should provide a general description of any other items that will limit the developer’s options. These may include:  

* Interfaces to users, other applications or hardware.  
* Quality of service constraints.  
* Standards compliance.  
* Constraints around design or implementation.
  
### 2.3 User Characteristics
Identify the various user classes that you anticipate will use this product. User classes may be differentiated based on frequency of use, subset of product functions used, technical expertise, security or privilege levels, educational level, or experience. Describe the pertinent characteristics of each user class. Certain requirements may pertain only to certain user classes. Distinguish the most important user classes for this product from those who are less important to satisfy.

### 2.4 Assumptions and Dependencies
List any assumed factors (as opposed to known facts) that could affect the requirements stated in the SRS. These could include third-party or commercial components that you plan to use, issues around the development or operating environment, or constraints. The project could be affected if these assumptions are incorrect, are not shared, or change. Also identify any dependencies the project has on external factors, such as software components that you intend to reuse from another project, unless they are already documented elsewhere (for example, in the vision and scope document or the project plan).

## 3. Requirements

### 3.1 Functional Requirements 
* FR0: The system shall allow users to create an account as either a player or a DM.
* FR1: The system shall allow users to modify their profiles on their own at any time.
* FR2: The system shall allow DMs to create campaigns that are open to the public or available by invite only.
  * Each campaign will have additional information such as what edition is being used and a short description of its contents.
* FR3: The system shall allow DMs to view user-specific data associated with their previous play experiences.
* FR4: The system shall allow DMs to respond to reviews from their previous players regarding the behaviour and performance of the DM.

#### 3.1.1 User interfaces
Define the software components for which a user interface is needed. Describe the logical characteristics of each interface between the software product and the users. This may include sample screen images, any GUI standards or product family style guides that are to be followed, screen layout constraints, standard buttons and functions (e.g., help) that will appear on every screen, keyboard shortcuts, error message display standards, and so on. Details of the user interface design should be documented in a separate user interface specification.

Could be further divided into Usability and Convenience requirements.

#### 3.1.2 Hardware interfaces
Describe the logical and physical characteristics of each interface between the software product and the hardware components of the system. This may include the supported device types, the nature of the data and control interactions between the software and the hardware, and communication protocols to be used.

#### 3.1.3 Software interfaces
* Java JDK 21
* PostgreSQL 17
* Spring Boot 3.5.5
* RESTful API
* D&D 5e SRD API
* GraphQL September 2025 release

### 3.2 Non Functional Requirements 

#### 3.2.1 Performance
* NFR4: A novice DM should be able to create a new campaign in under 15 minutes. 
* NFR5: An advanced DM shall be able to create a new campaign in under 10 minutes. 

#### 3.2.2 Security
Specify any requirements regarding security or privacy issues surrounding use of the product or protection of the data used or created by the product. Define any user identity authentication requirements. Refer to any external policies or regulations containing security issues that affect the product. Define any security or privacy certifications that must be satisfied.

#### 3.2.3 Reliability
Specify the factors required to establish the required reliability of the software system at time of delivery.

#### 3.2.4 Availability
Specify the factors required to guarantee a defined availability level for the entire system such as checkpoint, recovery, and restart.

#### 3.2.5 Compliance
Specify the requirements derived from existing standards or regulations

#### 3.2.6 Cost
Specify monetary cost of the software product.

#### 3.2.7 Deadline
* NFR9: The final product must be deployed by December 2025.
