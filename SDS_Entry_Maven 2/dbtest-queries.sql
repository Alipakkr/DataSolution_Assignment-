-- QUERY database
--  Task 2 Question number 1
SELECT SUM(claimed_charge)
FROM document
WHERE status = 'EXPORTED';

--     Total is 3450

-- Task 2 Question number 2
SELECT insured_name, insured_address, claimed_charge
FROM document
JOIN batch ON document.batch_id = batch.id
WHERE document.status = 'TO_REPRICE'
AND batch.customer_id IN (1, 2);

-- Output is
-- insured_name	insured_address	claimed_charge
-- Geeta	           KTM	          11100
-- Shankar	       KTM	          500
-- Shyam	           NGT	          100
-- Biraj	           KTM	          510
-- Shankar	       NGT	          1500
-- Ujjwal            NGT	          80000
-- Bishwo            LALIT	      600
-- Ram	           KTM	          100
-- Krishna	       KTM	          110
