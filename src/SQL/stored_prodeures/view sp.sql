USE `rit`;
DROP procedure IF EXISTS `View SP`;

DELIMITER $$
USE `rit`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `View SP`()
BEGIN
SELECT
    routine_name
FROM
    information_schema.routines
WHERE
    routine_type = 'PROCEDURE'
        AND routine_schema = 'rit';
END$$

DELIMITER ;