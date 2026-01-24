/**
Problem

You have a straight road with a target at position target. There are multiple cars, each with:
position[i] → starting position of car i
speed[i] → speed of car i

Rules:
Each car drives toward the target at its constant speed.
If a faster car catches up to a slower car ahead, they merge into a fleet and move together at the slower car’s speed.
A car fleet is defined as one or more cars driving together, arriving at the same time.
Goal: Return the total number of fleets that will arrive at the target

Intuition

The key insight:
-Calculate time to reach the target for each car:
time[i] = (target - position[i]) / speed[i]

-Think of it as a car’s arrival time if it drives alone.

-Sort cars by starting position from closest to target to farthest.
Reason: We always consider catching up to cars ahead.
A car behind can only merge with cars in front, never vice versa.

-Iterate through cars:
Keep track of lastTime, the arrival time of the last fleet formed.
If the current car’s time t is greater than lastTime, it cannot catch up → it forms a new fleet.
Otherwise, it joins the fleet ahead.

This works because cars are considered in order from front to back, so any faster car behind automatically merges if it would arrive sooner.

**/

class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        int n = speed.size();
        vector<pair<int, double>> cars; // {position, time to reach target}

        // Step 1: Compute time each car takes to reach the target
        for(int i = 0; i < n; i++){
            double time = double(target - position[i]) / speed[i];
            cars.push_back({position[i], time});
        }

        // Step 2: Sort cars from closest to target to farthest
        sort(cars.rbegin(), cars.rend());

        int fleets = 0;          // Counter for number of fleets
        double lastTime = 0.0;   // Arrival time of last fleet

        // Step 3: Iterate through cars
        for(auto& [pos, t] : cars){
            // If current car takes longer than last fleet, it forms a new fleet
            if(t > lastTime){
                fleets++;
                lastTime = t; // Update last fleet time
            }
            // Else, car joins fleet ahead (no new fleet formed)
        }
        
        return fleets; // Total fleets arriving at target
    }
};

/**
Time Complexity is O(nlogn) as We loop over all n cars once → O(n) and Sorting n elements → O(n log n)
Space complexity is O(n) as cars vector stores n pairs of {position, time} → O(n).
**/
