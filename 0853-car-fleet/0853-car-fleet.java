class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        
        // Each car is represented as [position, time_to_target]
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            // Calculate time taken by each car to reach the target
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // Sort cars based on starting position in descending order
        // So we process the car closest to the target first
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double lastFleetTime = 0;

        // Traverse each car
        for (int i = 0; i < n; i++) {
            double currentTime = cars[i][1];

            // If this car takes more time than the last fleet,
            // it can't catch up and forms a new fleet
            if (currentTime > lastFleetTime) {
                fleets++;
                lastFleetTime = currentTime;
            }
            // Else, it merges into the fleet ahead (slower car)
        }

        return fleets;
    }
}

/*
\U0001f9e0 Short Notes:
- A car fleet is a group of cars that travel together at the speed of the slowest car in the fleet.
- Sort by position descending so cars closer to target are handled first.
- Calculate time to reach target for each car.
- Use stack logic (or a variable) to group cars into fleets based on time comparison.

\U0001f552 Time Complexity: O(n log n)
- Sorting the cars by position takes O(n log n)
- The for-loop runs in O(n)

\U0001f4e6 Space Complexity: O(n)
- Used to store time-to-target values for each car.
- No extra stack needed; we use a simple counter and a variable to track fleet formation.
*/