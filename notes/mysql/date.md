mysql
===========
```
SELECT TIMESTAMPDIFF(DAY,NOW(),stop_time),
	CASE  WHEN DATE_FORMAT(NOW(),'%Y-%m-%d')=DATE_FORMAT(stop_time,'%Y-%m-%d') THEN 9999999
        WHEN TIMESTAMPDIFF(DAY,NOW(),stop_time) >0 THEN 9999999- TIMESTAMPDIFF(DAY,NOW(),stop_time)
        ELSE  TIMESTAMPDIFF(DAY,NOW(),stop_time) END ranking,
       v.* FROM user_vouchers v WHERE m_id = 864044 ORDER BY is_used, ranking DESC;
```
