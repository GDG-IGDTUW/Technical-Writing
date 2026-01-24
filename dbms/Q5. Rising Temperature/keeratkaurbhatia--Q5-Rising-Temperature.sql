/*
Approach: using a join to compare each row in w1 to the day before w2 using DATEDIFF. and then filtering the result where w1.temperature > w2.temperature 
TC: O(n) if proper indexing, else O(n^2) because in indexing lookup will be facilitated by indexes/primary keys. if not, then all rows have to be checked to find the match each time
SC: O(1) as no extra data structure created
*/

SELECT w1.id 
FROM Weather w1
JOIN Weather w2 
ON DATEDIFF(w1.recordDate, w2.recordDate) = 1
WHERE w1.temperature > w2.temperature;
