/*
 * Duplicate Emails
 *
 * Top 87% (619ms)
 * 
 * Times on these ones are a little random
 */

SELECT email FROM Person GROUP BY email HAVING count(email) > 1;