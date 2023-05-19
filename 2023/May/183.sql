/*
 * Customers Who Never Order
 *
 * Top 85% (874ms)
 * 
 * Times on these ones are a little random
 */

SELECT name AS Customers FROM Customers 
WHERE Customers.id NOT IN
(
  SELECT customerid FROM Orders
);