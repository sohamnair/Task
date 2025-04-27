CREATE MATERIALIZED VIEW ElectronicsToItemMapping AS 
SELECT * 
FROM Electronics ele
FULL OUTER JOIN ItemDetails itemD 
ON ele.id = itemD.electronics_id;