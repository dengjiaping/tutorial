CREATE TABLE `test`.`slow_logs`( `slow_log_id` INT(32) NOT NULL AUTO_INCREMENT ,   
  `query_time` FLOAT(4) NOT NULL ,    
   `lock_time` FLOAT(4) NOT NULL ,     
   `rows_sent` INT(32) NOT NULL ,     
   `rows_examined` INT(32) NOT NULL ,     
   `rows_affected` INT(32) NOT NULL ,     
   `sql` VARCHAR(10000000) NOT NULL ,    
    PRIMARY KEY (`slow_log_id`)  );

ALTER TABLE `test`.`slow_logs`     
ADD COLUMN `created_time` TIMESTAMP NOT NULL AFTER `sql`,     
ADD COLUMN `update_time` TIMESTAMP NOT NULL AFTER `created_time`,    
CHANGE `sql` `sql` LONGTEXT NOT NULL;
