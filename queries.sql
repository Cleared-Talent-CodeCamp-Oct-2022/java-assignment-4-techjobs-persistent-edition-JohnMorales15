-- Part 1: Test it with SQL
SELECT * From job;
-- Part 2: Test it with SQL
SELECT name FROM employer WHERE location="St. Louis City";
-- Part 3: Test it with SQL
DROP TABLE job;
-- Part 4: Test it with SQL
SELECT *
FROM skill
INNER JOIN job_skills ON job_skills.skills_id = skill.id
ORDER BY name ASC;