# Nat20 Network Requirements Testing
## Actors
- Dungeon Master (Provider)
- Player (Customer)
- System Administrator

### Use Cases
#### 1. DM: Create provider profile use case:
1. DM D1 logs in for the first time and creates a profile.
2. D1 creates new public campaigns S1 and S2 with values for campaign title, description, short description, and edition. Campaign privacy must be set to public.  
D1 exits the app.

#### 2. Player: Create customer profile:
1. Player P1 logs in for the first time and creates a profile.

#### 3. Player:  View and subscribe to services:
1. P1 views available campaigns S1 and S2.
2. P1 requests to subscribe to S1.

#### 4. DM: Approve player join request and view statistics
1. DM D1 logs in and views P1's statistics.
2. D1 accepts P1's campaign request. D1 exits.  

#### 5. Player: Write review
1. P1 logs in and views their campaigns.
2. P1 writes a positive review of campaign S1. P1 exits.

#### 6. Player: Modify profile
1. P1 modifies their profile.

#### 7. Provider:  Reply to Review an Modify Profile use cases
1. DM D1 logs in and reads their review and replies with thanks. 
2. D1 modifies his profile. D1 exits.